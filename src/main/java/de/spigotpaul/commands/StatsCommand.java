package de.spigotpaul.commands;

import java.sql.ResultSet;

import de.spigotpaul.JumpLeague;
import de.spigotpaul.methods.mysql.Stats;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StatsCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

		if(JumpLeague.getInstance().getMysqlactivated()){
			if (args.length > 0) {
				OfflinePlayer p2 = Bukkit.getOfflinePlayer(args[0]);
	
				if ((p2.getUniqueId().toString() == null) || (!Stats.playerExists(p2.getUniqueId().toString()))) {
					p.sendMessage(JumpLeague.getInstance().getPrefix() + "§7Der Spieler §8(§e" + p2.getName() + "§8) §7wurde nicht gefunden§8!");
	
				} else {
	
					JumpLeague.getInstance().getExecutorService().submit(() -> {
						int deaths = Stats.getDeaths(p2.getUniqueId().toString());
						int kills = Stats.getKills(p2.getUniqueId().toString());
						int wins = Stats.getWonneneSpiele(p2.getUniqueId().toString());
						int vspiele = Stats.getVerloreneSpiele(p2.getUniqueId().toString());
						int gespielte = Stats.getGespielteSpiele(p2.getUniqueId().toString());
						int zbetten = Stats.getBetten(p2.getUniqueId().toString());
						int ranking = getUserRanking(p2.getUniqueId().toString());
	
						double KD = ((double) kills) / ((double) deaths);
						String kd = Double.valueOf(KD).toString();
	
						p.sendMessage("§8§m------------------------------------------------");
						p.sendMessage("");
						p.sendMessage("§a§o■ §8┃ §2Spielername §8● §7" + p2.getName());
						p.sendMessage("");
						p.sendMessage("§a§o■ §8┃ §2Alle Spiele §8● §7" + gespielte);
						p.sendMessage("§a§o■ §8┃ §2Gewonnene Spiele §8● §7" + wins);
						p.sendMessage("§a§o■ §8┃ §cVerlorene Spiele §8● §7" + vspiele);
						p.sendMessage("");
						p.sendMessage("§a§o■ §8┃ §2Kills §8● §7" + kills);
						p.sendMessage("§a§o■ §8┃ §2Death §8● §7" + deaths);
						p.sendMessage("§a§o■ §8┃ §2KD §8● §7" + kd.replace("NaN", "0").replace("Infinity", "0"));
						p.sendMessage("");
						p.sendMessage("§a§o■ §8┃ §2Platz §8● §7" + ranking);
						p.sendMessage("");
						p.sendMessage("§8§m------------------------------------------------");
					});
	
				}
	
			} else {
				JumpLeague.getInstance().getExecutorService().submit(() -> {
					int deaths = Stats.getDeaths(p.getUniqueId().toString());
					int kills = Stats.getKills(p.getUniqueId().toString());
					int wins = Stats.getWonneneSpiele(p.getUniqueId().toString());
					int vspiele = Stats.getVerloreneSpiele(p.getUniqueId().toString());
					int gespielte = Stats.getGespielteSpiele(p.getUniqueId().toString());
					int zbetten = Stats.getBetten(p.getUniqueId().toString());
					int ranking = getUserRanking(p.getUniqueId().toString());
	
					double KD = ((double) kills) / ((double) deaths);
					String kd = Double.valueOf(KD).toString();
					p.sendMessage("§8§m------------------------------------------------");
					p.sendMessage("");
					p.sendMessage("§a§o■ §8┃ §2Alle Spiele §8● §7" + gespielte);
					p.sendMessage("§a§o■ §8┃ §2Gewonnene Spiele §8● §7" + wins);
					p.sendMessage("§a§o■ §8┃ §cVerlorene Spiele §8● §7" + vspiele);
					p.sendMessage("");
					p.sendMessage("§a§o■ §8┃ §2Kills §8● §7" + kills);
					p.sendMessage("§a§o■ §8┃ §2Death §8● §7" + deaths);
					p.sendMessage("§a§o■ §8┃ §2KD §8● §7" + kd.replace("NaN", "0").replace("Infinity", "0"));
					p.sendMessage("");
					p.sendMessage("§a§o■ §8┃ §2Platz §8● §7" + ranking);
					p.sendMessage("");
					p.sendMessage("§8§m------------------------------------------------");
				});
			}
		} else {
			p.sendMessage(JumpLeague.getInstance().getPrefix() + "§7MySQL ist derzeitig Deaktiviert.");
		}
		return true;
		

	}

	public static Integer getUserRanking(String uuid) {
		boolean done = false;
		int n = 0;

		try {
			ResultSet rs = JumpLeague.getInstance().getMysql().query("SELECT UUID FROM JumpLeague ORDER BY GESPIELE DESC;");
			while ((rs.next()) && (!done)) {
				n++;
				if (rs.getString(1).equalsIgnoreCase(uuid)) {
					done = true;
				}
			}
			rs.close();
		} catch (Exception err) {
			System.err.println("[] gSystem-Error-User-getUserRanking []");
			System.err.println(err);
			System.err.println("[] gSystem-Error-User-getUserRanking []");
		}
		return Integer.valueOf(n);
	}

}
