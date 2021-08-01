package de.spigotpaul.listeners;

import java.util.Random;

import de.spigotpaul.JumpLeague;
import de.spigotpaul.methods.manager.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerRespawnListener implements Listener {
	
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		PlayerManager playerManager = JumpLeague.getInstance().getPlayerManager().get(player.getName());
		
		if(playerManager.getLives() > 0) {
			Random r = new Random();
			Integer integer = r.nextInt(JumpLeague.getInstance().getMaxPlayers());
			
			event.setRespawnLocation(JumpLeague.getInstance().getLocationManager().getInGameLocation(player, "deathmatch", integer));
			
			Bukkit.getScheduler().runTaskLater(JumpLeague.getInstance(), new Runnable() {				
				@Override
				public void run() {
					player.getInventory().setContents(playerManager.getPlayerContent());
					player.getInventory().setArmorContents(playerManager.getArmorContent());
				}
			}, 13);
		} else {
			player.setGameMode(GameMode.SPECTATOR);
			
			event.setRespawnLocation(JumpLeague.getInstance().getLocationManager().getLocation(player, "spec"));
		}
	}

}
