package de.spigotpaul.methods.countdowns;

import de.spigotpaul.JumpLeague;
import de.spigotpaul.methods.mysql.Stats;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class LobbyCountdown {
	
	public int lobbyCountdown = 61;
	private boolean isStarted = false;
	
	@SuppressWarnings("static-access")
	public void startCountdown() {
		if(!isStarted) {
			Thread t = Thread.currentThread();
			
			for(int i = 0; i != 1000; i++) {
				if(Bukkit.getOnlinePlayers().size() < JumpLeague.getInstance().getMinPlayers()) {
					if(Bukkit.getOnlinePlayers().size() != 0) {
						for(Player all : Bukkit.getOnlinePlayers()) {
							int required = JumpLeague.getInstance().getMinPlayers() - Bukkit.getOnlinePlayers().size();
							
							JumpLeague.getInstance().getActionBarManager().sendActionBar(all, "§cEs wird noch auf §8(§e" + required + "§8) §cweitere Spieler gewartet§8!");
						}
					}
					if(lobbyCountdown <= 52) {
						i = 0;
						lobbyCountdown = 61;
						
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.setLevel(60);
							all.setExp(0);
						}
					}
				} else {
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.setLevel(lobbyCountdown);
						all.setExp(0);
					}
					
					if(lobbyCountdown == 60 || lobbyCountdown == 30 || lobbyCountdown == 15 || lobbyCountdown == 10 || lobbyCountdown <=5 && lobbyCountdown >= 2) {
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.playSound(all.getLocation(), Sound.NOTE_BASS_DRUM, 1, 1);
						}
						
						Bukkit.broadcastMessage(JumpLeague.getInstance().getPrefix() + "§7Die §eRunde §7startet in §8(§e" + lobbyCountdown + "§8) §7Sekunden§8!");
					} else if(lobbyCountdown == 1) {
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.playSound(all.getLocation(), Sound.NOTE_BASS_DRUM, 1, 1);
						}
						
						Bukkit.broadcastMessage(JumpLeague.getInstance().getPrefix() + "§7Die §eRunde §7startet in §8(§e" + lobbyCountdown + "§8) §7Sekunde§8!");
					} else if(lobbyCountdown == 0) {
						Bukkit.getScheduler().callSyncMethod(JumpLeague.getInstance(), () ->{
							int teleportKey = 1;
							
							for(Player all : Bukkit.getOnlinePlayers()) {
								all.teleport(JumpLeague.getInstance().getLocationManager().getInGameLocation(all, "spawn", teleportKey));
								all.setGameMode(GameMode.SURVIVAL);
								all.getInventory().clear();
								
								JumpLeague.getInstance().getScoreboardManager().setInGameScoreboard(all);
								JumpLeague.getInstance().getPlayerManager().get(all.getName()).setLastCheckPoint(all.getLocation());
								
								teleportKey += 1;
							}
							return null;
						});
						
						if(JumpLeague.getInstance().getMysqlactivated()) {
							for(Player all : Bukkit.getOnlinePlayers()) {
								Stats.addGespielteSpiele(all.getUniqueId().toString(), 1);
							}
						}
						
						JumpLeague.getInstance().getWarteCountdown().startCountdown();
						return;
					}
				}
				
				lobbyCountdown--;
				try {
					t.sleep(1*999);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
