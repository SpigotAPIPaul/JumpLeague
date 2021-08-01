package de.spigotpaul.listeners;

import de.spigotpaul.JumpLeague;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockChangeListener implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event) {
		if(JumpLeague.getInstance().getBuildPlayer().contains(event.getPlayer().getName())) {
			return;
		}
		
		event.setCancelled(true);
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		if(JumpLeague.getInstance().getBuildPlayer().contains(event.getPlayer().getName())) {
			return;
		}
		
		event.setCancelled(true);
	}

}
