package de.spigotpaul.commands;

import de.spigotpaul.JumpLeague;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JumpLeagueCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if(s instanceof Player) {
			Player player = (Player)s;
			
			if(cmd.getName().equalsIgnoreCase("JumpLeague")) {
				if(player.hasPermission("JumpLeague.Admin")) {
					if(args.length == 2) {
						if(args[0].equalsIgnoreCase("set")) {
							if(args[1].equalsIgnoreCase("lobby")) {
								JumpLeague.getInstance().getLocationManager().setLocation(player, "lobby");
							} else if(args[1].equalsIgnoreCase("spec")) {
								JumpLeague.getInstance().getLocationManager().setLocation(player, "spec");
							} else if(args[1].equalsIgnoreCase("grenze")) {
								JumpLeague.getInstance().getLocationManager().setLocation(player, "grenze");
							}
						}
					} else if(args.length == 3) {
						if(args[0].equalsIgnoreCase("set")) {
							if(args[1].equalsIgnoreCase("spawn")) {
								Integer integer = Integer.valueOf(args[2]);
								
								JumpLeague.getInstance().getLocationManager().setInGameLocation(player, "spawn", integer);
							} else if(args[1].equalsIgnoreCase("deathmatch")) {
								Integer integer = Integer.valueOf(args[2]);

								JumpLeague.getInstance().getLocationManager().setInGameLocation(player, "deathmatch", integer);
							}
						}
					} else {
						player.sendMessage(JumpLeague.getInstance().getPrefix() + "§8/§ejumpleague §7set <Lobby|Spec|Grenze>");
						player.sendMessage(JumpLeague.getInstance().getPrefix() + "§8/§ejumpleague §7set <Spawn|Deathmatch> <Zahl>");
					}
				}
			}
		}
		return false;
	}

}
