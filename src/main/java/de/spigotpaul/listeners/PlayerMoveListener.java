package de.spigotpaul.listeners;

import de.spigotpaul.JumpLeague;
import de.spigotpaul.methods.gamestate.GameState;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		if (JumpLeague.getInstance().getGameState().equals(GameState.WAIT)) {
			Location to = event.getTo();
			Location from = event.getFrom();
			if (((from.getX() != to.getX()) || (from.getZ() != to.getZ()))) {
				event.getPlayer().teleport(from);
			}
		} else if (JumpLeague.getInstance().getGameState().equals(GameState.INGAME)) {
			if(!JumpLeague.getInstance().getAlivePlayers().contains(event.getPlayer().getName())) {
				return;
			}
			if(event.getPlayer().getLocation().getY() <= JumpLeague.getInstance().getLocationManager().getLocation(event.getPlayer(), "grenze").getY()) {
				event.getPlayer().teleport(JumpLeague.getInstance().getPlayerManager().get(event.getPlayer().getName()).getLastCheckPoint());
				return;
			}
			
			if (event.getPlayer().getLocation().subtract(0, 1, 0).getBlock().getType() == Material.DIAMOND_BLOCK) {
				if(!JumpLeague.getInstance().getPlayerManager().get(event.getPlayer().getName()).getLastCheckPoints().contains(event.getPlayer().getLocation().subtract(0, 1, 0).getBlock().getLocation())) {
					if (event.getPlayer().getLocation().getBlock().getType() == Material.GOLD_PLATE) {
						if(JumpLeague.getInstance().getInGameCountdown().inGameCountdown > 11) {
							JumpLeague.getInstance().getInGameCountdown().inGameCountdown = 11;
						}
						
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.sendMessage(JumpLeague.getInstance().getPrefix() + "§8(§e" + event.getPlayer().getName() + "§8) §7hat das §eZiel §7erreicht§8!");
							all.sendTitle("§8(§e" + event.getPlayer().getName() + "§8)", "§7hat das §eZiel §7erreicht§8!");
						}

						JumpLeague.getInstance().getPlayerManager().get(event.getPlayer().getName()).setLastCheckPoint(event.getPlayer().getLocation());
						JumpLeague.getInstance().getPlayerManager().get(event.getPlayer().getName()).addLastCheckPoint(event.getPlayer().getLocation().subtract(0,1,0).getBlock().getLocation());
					}
				}
			} else if (event.getPlayer().getLocation().subtract(0, 1, 0).getBlock().getType() == Material.IRON_BLOCK) {
				if(!JumpLeague.getInstance().getPlayerManager().get(event.getPlayer().getName()).getLastCheckPoints().contains(event.getPlayer().getLocation().subtract(0, 1, 0).getBlock().getLocation())) {
					if (event.getPlayer().getLocation().getBlock().getType() == Material.GOLD_PLATE) {
						JumpLeague.getInstance().getPlayerManager().get(event.getPlayer().getName()).addCheckPoint();
						JumpLeague.getInstance().getPlayerManager().get(event.getPlayer().getName()).setLastCheckPoint(event.getPlayer().getLocation());
						JumpLeague.getInstance().getPlayerManager().get(event.getPlayer().getName()).addLastCheckPoint(event.getPlayer().getLocation().subtract(0,1,0).getBlock().getLocation());
						
						JumpLeague.getInstance().getScoreboardManager().updateInGameCheckPoint(event.getPlayer());
						
						event.getPlayer().sendMessage(JumpLeague.getInstance().getPrefix() + "§7Du hast den CheckPoint §8(§e" + JumpLeague.getInstance().getPlayerManager().get(event.getPlayer().getName()).getCheckPoint() + "§8) §7erreicht.");
					}
				}
			}
		}
	}

}
