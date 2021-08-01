package de.spigotpaul.listeners;

import de.spigotpaul.JumpLeague;
import de.spigotpaul.methods.gamestate.GameState;
import de.spigotpaul.methods.manager.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.setJoinMessage(null);

		JumpLeague.getInstance().getPlayerManager().put(event.getPlayer().getName(), new PlayerManager());
		
		if(JumpLeague.getInstance().getGameState().equals(GameState.LOBBY)) {
			JumpLeague.getInstance().getPlayerManager().get(event.getPlayer().getName()).setLobbyState(event.getPlayer());
			JumpLeague.getInstance().getAlivePlayers().add(event.getPlayer().getName());
			
			if(Bukkit.getOnlinePlayers().size() == JumpLeague.getInstance().getMinPlayers()) {
				JumpLeague.getInstance().getLobbyCountdown().lobbyCountdown = 60;
			}
		} else {
			JumpLeague.getInstance().getPlayerManager().get(event.getPlayer().getName()).setInGameState(event.getPlayer());
		}
	}

}
