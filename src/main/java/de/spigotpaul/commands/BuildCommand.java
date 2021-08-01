package de.spigotpaul.commands;

import de.spigotpaul.JumpLeague;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if(s instanceof Player) {
			Player player = (Player)s;
			
			if(cmd.getName().equalsIgnoreCase("Build")) {
				if(player.hasPermission("JumpLeague.Admin")) {
					if(JumpLeague.getInstance().getBuildPlayer().contains(player.getName())) {
						JumpLeague.getInstance().getBuildPlayer().remove(player.getName());
						
						player.sendMessage(JumpLeague.getInstance().getPrefix() + "");
					} else {
						JumpLeague.getInstance().getBuildPlayer().add(player.getName());
						
						player.sendMessage(JumpLeague.getInstance().getPrefix() + "§7Sie können jetzt bauen§8!");
					}
				}
			}
		}
		return false;
	}

}
