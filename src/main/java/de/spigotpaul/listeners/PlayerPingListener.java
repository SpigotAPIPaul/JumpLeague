package de.spigotpaul.listeners;

import de.spigotpaul.JumpLeague;
import de.spigotpaul.methods.gamestate.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class PlayerPingListener implements Listener {
	
	@EventHandler
	public void onPing(ServerListPingEvent event){
		event.setMaxPlayers(JumpLeague.getInstance().getMaxPlayers());
		
		if(JumpLeague.getInstance().getGameState().equals(GameState.LOBBY)){
			event.setMotd("§eLobby");
		} else if(JumpLeague.getInstance().getGameState().equals(GameState.INGAME)){
			event.setMotd("§6InGame");
		} else if(JumpLeague.getInstance().getGameState().equals(GameState.DEATHMATCH)){
			event.setMotd("§cDeathmatch");
		} else if(JumpLeague.getInstance().getGameState().equals(GameState.RESTART)){
			event.setMotd("§4Restart");
		}
	}

}
