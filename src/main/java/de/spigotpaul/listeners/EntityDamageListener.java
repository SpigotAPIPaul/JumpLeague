package de.spigotpaul.listeners;

import de.spigotpaul.JumpLeague;
import de.spigotpaul.methods.gamestate.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		if(!JumpLeague.getInstance().getGameState().equals(GameState.DEATHMATCH)) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		if(!JumpLeague.getInstance().getGameState().equals(GameState.DEATHMATCH)) {
			event.setCancelled(true);
		}
	}

}
