package de.spigotpaul.methods.countdowns;

import de.spigotpaul.JumpLeague;
import de.spigotpaul.methods.gamestate.GameState;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class RestartCountdown {

	public int restartCountdown = 15;

	@SuppressWarnings("static-access")
	public void startCountdown() {
		JumpLeague.getInstance().setGameState(GameState.RESTART);
		Thread t = Thread.currentThread();

		for (int i = 0; i != 1000; i++) {
			if (restartCountdown == 15 || restartCountdown == 10 || restartCountdown <= 5 && restartCountdown >= 2) {
				for (Player all : Bukkit.getOnlinePlayers()) {
					all.playSound(all.getLocation(), Sound.NOTE_BASS_DRUM, 1, 1);
				}

				Bukkit.broadcastMessage(JumpLeague.getInstance().getPrefix() + "§7Der Server startet in §8(§e" + restartCountdown + "§8) §7Sekunden neu§8!");
			} else if (restartCountdown == 1) {
				for (Player all : Bukkit.getOnlinePlayers()) {
					all.playSound(all.getLocation(), Sound.NOTE_BASS_DRUM, 1, 1);
				}

				Bukkit.broadcastMessage(JumpLeague.getInstance().getPrefix() + "§7Der Server startet in §8(§e" + restartCountdown + "§8) §7Sekunden neu§8!");
			} else if (restartCountdown == 0) {
				Bukkit.getServer().shutdown();
			}

			restartCountdown--;
			try {
				t.sleep(1 * 999);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
