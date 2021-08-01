package de.spigotpaul.methods.manager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.spigotpaul.JumpLeague;

public class MessagesManager {
	
	public void sendMessageToPlayer(Player player, String message) {
		player.sendMessage(JumpLeague.getInstance().getPrefix() + message);
	}
	
	public void sendMessageToAll(String message) {
		for(Player all : Bukkit.getOnlinePlayers()) {
			all.sendMessage(JumpLeague.getInstance().getPrefix() + message);
		}
	}

}
