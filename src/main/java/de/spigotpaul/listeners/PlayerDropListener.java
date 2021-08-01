package de.spigotpaul.listeners;

import de.spigotpaul.JumpLeague;
import de.spigotpaul.methods.gamestate.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropListener implements Listener {
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent event){
		if(JumpLeague.getInstance().getGameState().equals(GameState.DEATHMATCH)){
			return;
		} else {
			event.setCancelled(true);
		}
	}
}