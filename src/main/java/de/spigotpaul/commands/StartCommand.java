package de.spigotpaul.commands;

import de.spigotpaul.JumpLeague;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if(s instanceof Player) {
			Player player = (Player)s;
			
			if(cmd.getName().equalsIgnoreCase("Start")) {
				if(player.hasPermission("JumpLeague.Start")) {
					if(JumpLeague.getInstance().getLobbyCountdown().lobbyCountdown <= 11){
						player.sendMessage(JumpLeague.getInstance().getPrefix() + "§7Das Spiel startet bereits§8!");
						return false;
					}
					
					JumpLeague.getInstance().getLobbyCountdown().lobbyCountdown = 10;					
					player.sendMessage(JumpLeague.getInstance().getPrefix() + "Das Spiel startet§8!");
				}
			}
		}
		return false;
	}

}
