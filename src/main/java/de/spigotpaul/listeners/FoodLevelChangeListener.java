package de.spigotpaul.listeners;

import de.spigotpaul.JumpLeague;
import de.spigotpaul.methods.gamestate.GameState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FoodLevelChangeListener implements Listener {
	
	@EventHandler
	public void onFoodLevelChange(FoodLevelChangeEvent event) {
		if(!JumpLeague.getInstance().getGameState().equals(GameState.DEATHMATCH)) {
			event.setCancelled(true);
		}
	}

}
