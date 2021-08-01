package de.spigotpaul.listeners;

import de.spigotpaul.JumpLeague;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		
		if(event.getClickedBlock() != null) {
			if(event.getClickedBlock().getType() == Material.CHEST) {
				event.setCancelled(true);
				
				if(!JumpLeague.getInstance().getAlivePlayers().contains(event.getPlayer().getName())) {
					return;
				}
				
				JumpLeague.getInstance().getChestManager().openChest(player, event.getClickedBlock().getLocation().getBlock().getLocation());
			}
		}
	}

}
