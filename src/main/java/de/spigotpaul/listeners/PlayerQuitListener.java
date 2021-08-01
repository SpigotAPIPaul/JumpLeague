package de.spigotpaul.listeners;

import de.spigotpaul.JumpLeague;
import de.spigotpaul.methods.gamestate.GameState;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.spigotpaul.methods.mysql.Stats;

public class PlayerQuitListener implements Listener {
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		event.setQuitMessage(null);
		
		if(JumpLeague.getInstance().getBuildPlayer().contains(event.getPlayer().getName())) {
			JumpLeague.getInstance().getBuildPlayer().remove(event.getPlayer().getName());
		}
		if(JumpLeague.getInstance().getScoreBoard().containsKey(event.getPlayer().getName())) {
			JumpLeague.getInstance().getScoreBoard().remove(event.getPlayer().getName());
		}
		if(JumpLeague.getInstance().getPlayerManager().containsKey(event.getPlayer().getName())) {
			JumpLeague.getInstance().getPlayerManager().remove(event.getPlayer().getName());
		}
		if(JumpLeague.getInstance().getAlivePlayers().contains(event.getPlayer().getName())) {
			JumpLeague.getInstance().getAlivePlayers().remove(event.getPlayer().getName());
			
			if(JumpLeague.getInstance().getGameState().equals(GameState.INGAME) || JumpLeague.getInstance().getGameState().equals(GameState.DEATHMATCH)) {
				JumpLeague.getInstance().getMessagesManager().sendMessageToAll("§e§o■ §8┃ §6JumpLeague §8● (§e" + event.getPlayer().getName() + "§8) §cist ausgeschieden§8!");
				
				for(Player all : Bukkit.getOnlinePlayers()) {
					if(JumpLeague.getInstance().getScoreBoard().containsKey(event.getPlayer().getName())) {
						JumpLeague.getInstance().getScoreboardManager().updateInGamePlayer(all);
					}
				}
				
				if(JumpLeague.getInstance().getMysqlactivated()) {
					JumpLeague.getInstance().getExecutorService().submit(() ->{
						Stats.addVerloreneSpiele(event.getPlayer().getUniqueId().toString(), 1);
					});
				}
			}
		}
	}

}
