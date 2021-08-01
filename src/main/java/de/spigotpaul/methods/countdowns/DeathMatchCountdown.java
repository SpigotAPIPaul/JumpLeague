package de.spigotpaul.methods.countdowns;

import de.spigotpaul.JumpLeague;
import de.spigotpaul.methods.gamestate.GameState;
import de.spigotpaul.methods.mysql.Stats;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class DeathMatchCountdown {
	
	public int deathMatchCountdown = 600;

	@SuppressWarnings({ "static-access", "deprecation" })
	public void startCountdown() {
		JumpLeague.getInstance().setGameState(GameState.DEATHMATCH);
		Thread t = Thread.currentThread();

		for (int i = 0; i != 1000; i++) {			
			for(Player all : Bukkit.getOnlinePlayers()) {
				JumpLeague.getInstance().getScoreboardManager().updateDeathMatchTime(all);
			}
			
			if(JumpLeague.getInstance().getAlivePlayers().size() <= 1) {
				if(JumpLeague.getInstance().getAlivePlayers().size() != 0) {
					Bukkit.broadcastMessage(JumpLeague.getInstance().getPrefix() + "§8(§e" + JumpLeague.getInstance().getAlivePlayers().get(0) + "§8) §7hat das Spiel gewonnen§8!");
					
					Bukkit.getScheduler().callSyncMethod(JumpLeague.getInstance(), () ->{
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.sendTitle("§8(§e" + JumpLeague.getInstance().getAlivePlayers().get(0) + "§8)", "§7hat das §eSpiel §7gewonnen§8!");
							all.teleport(JumpLeague.getInstance().getLocationManager().getLocation(all, "lobby"));
						}
						return null;
					});
					
					if(JumpLeague.getInstance().getMysqlactivated()) {
						JumpLeague.getInstance().getExecutorService().submit(() ->{
							Stats.addGewonneSpiele(Bukkit.getPlayer(JumpLeague.getInstance().getAlivePlayers().get(0)).getUniqueId().toString(), 1);
						});
					}
					
					JumpLeague.getInstance().getRestartCountdown().startCountdown();
					return;
				}
			
				JumpLeague.getInstance().getRestartCountdown().startCountdown();
				return;
			}
			
			if (deathMatchCountdown == 10 || deathMatchCountdown <= 5 && deathMatchCountdown >= 2) {
				for (Player all : Bukkit.getOnlinePlayers()) {
					all.playSound(all.getLocation(), Sound.NOTE_BASS_DRUM, 1, 1);
				}

				Bukkit.broadcastMessage(JumpLeague.getInstance().getPrefix() + "§7Das §eSpiel §7endet in §8(§e" + deathMatchCountdown + "§8) §7Sekunden§8!");
			} else if (deathMatchCountdown == 1) {
				for (Player all : Bukkit.getOnlinePlayers()) {
					all.playSound(all.getLocation(), Sound.NOTE_BASS_DRUM, 1, 1);
				}

				Bukkit.broadcastMessage(JumpLeague.getInstance().getPrefix() + "§7Das §eSpiel §7endet in §8(§e" + deathMatchCountdown + "§8) §7Sekunden§8!");
			} else if (deathMatchCountdown == 0) {
				Bukkit.broadcastMessage(JumpLeague.getInstance().getPrefix() + "§cNiemand hat gewonnen§8!");
				
				JumpLeague.getInstance().getRestartCountdown().startCountdown();
				return;
			}

			deathMatchCountdown--;
			try {
				t.sleep(1 * 999);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
