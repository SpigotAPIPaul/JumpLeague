package de.spigotpaul.methods.countdowns;

import de.spigotpaul.JumpLeague;
import de.spigotpaul.methods.gamestate.GameState;
import de.spigotpaul.methods.mysql.Stats;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class WarteCountdown {

	public int warteCountdown = 10;

	@SuppressWarnings({ "static-access", "deprecation" })
	public void startCountdown() {
		JumpLeague.getInstance().setGameState(GameState.WAIT);
		Thread t = Thread.currentThread();

		for (int i = 0; i != 1000; i++) {
			
			if(JumpLeague.getInstance().getAlivePlayers().size() <= 1) {
				if(JumpLeague.getInstance().getAlivePlayers().size() != 0) {
					Bukkit.broadcastMessage(JumpLeague.getInstance().getPrefix() + "§8(§e" + JumpLeague.getInstance().getAlivePlayers().get(0) + "§8) §7hat das §eSpiel §7gewonnen§8!");
					
					Bukkit.getScheduler().callSyncMethod(JumpLeague.getInstance(), () ->{
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.sendTitle("§8(§e" + JumpLeague.getInstance().getAlivePlayers().get(0), "§8) §7hat das §eSpiel §7gewonnen§8!");
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
			}
			
			if (warteCountdown == 10 || warteCountdown <= 5 && warteCountdown >= 2) {
				for (Player all : Bukkit.getOnlinePlayers()) {
					all.playSound(all.getLocation(), Sound.NOTE_BASS_DRUM, 1, 1);
				}

				Bukkit.broadcastMessage(JumpLeague.getInstance().getPrefix() + "§7Du kannst dich in §8(§e" + warteCountdown + "§8) §7Sekunden bewegen§8!");
			} else if (warteCountdown == 1) {
				for (Player all : Bukkit.getOnlinePlayers()) {
					all.playSound(all.getLocation(), Sound.NOTE_BASS_DRUM, 1, 1);
				}

				Bukkit.broadcastMessage(JumpLeague.getInstance().getPrefix() + "§7Du kannst dich in §8(§e" + warteCountdown + "§8) §7Sekunde bewegen§8!");
			} else if (warteCountdown == 0) {
				Bukkit.broadcastMessage(JumpLeague.getInstance().getPrefix() + "§7Du kannst dich §ejetzt §7bewegen§8!");
				
				JumpLeague.getInstance().getInGameCountdown().startCountdown();
				return;
			}

			warteCountdown--;
			try {
				t.sleep(1 * 999);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
