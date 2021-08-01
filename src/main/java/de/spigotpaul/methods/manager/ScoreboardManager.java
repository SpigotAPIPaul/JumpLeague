package de.spigotpaul.methods.manager;

import de.spigotpaul.methods.countdowns.WaitCountdown;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.spigotpaul.JumpLeague;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardManager {
	
	public void setLobbyScoreboard(Player player) {
		org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
		Scoreboard s = sm.getNewScoreboard();
		s.registerNewObjective("board", "dummy");
		Objective o = s.getObjective("board");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("§6JumpLeague");
		o.getScore("§7     §8§m-------------  §7").setScore(16);
		o.getScore("§7§8").setScore(15);
		o.getScore("§8┌│ §7Profil").setScore(14);
		o.getScore("§8» §e" + player.getName()).setScore(13);
		o.getScore("§9§3").setScore(12);
		o.getScore("§8┌│ §7Map").setScore(11);
		o.getScore("§8» §e" + JumpLeague.getInstance().getConfig().getString("Map")).setScore(10);
		o.getScore("§8§9").setScore(9);
		o.getScore("§8┌│ §7Spieler").setScore(8);
		o.getScore("§8» §e" + Bukkit.getOnlinePlayers().size()).setScore(7);
		o.getScore("§4§f§7").setScore(4);
		o.getScore("§8┌│ §7Coins").setScore(3);
		o.getScore("§8» §e0").setScore(2);
		o.getScore("§4§f").setScore(1);
		o.getScore("§7     §8§m-------------").setScore(0);
		player.setScoreboard(s);
	}


	public void updateLobbyPlayer(Player player) {
		org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
		Scoreboard s = sm.getNewScoreboard();
		s.registerNewObjective("board", "dummy");
		Objective o = s.getObjective("board");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("§6JumpLeague");
		o.getScore("§7     §8§m-------------  §7").setScore(16);
		o.getScore("§7§8").setScore(15);
		o.getScore("§8┌│ §7Profil").setScore(14);
		o.getScore("§8» §e" + player.getName()).setScore(13);
		o.getScore("§9§3").setScore(12);
		o.getScore("§8┌│ §7Map").setScore(11);
		o.getScore("§8» §e" + JumpLeague.getInstance().getConfig().getString("Map")).setScore(10);
		o.getScore("§8§9").setScore(9);
		o.getScore("§8┌│ §7Spieler").setScore(8);
		o.getScore("§8» §e" + Bukkit.getOnlinePlayers().size()).setScore(7);
		o.getScore("§4§f§7").setScore(4);
		o.getScore("§8┌│ §7Coins").setScore(3);
		o.getScore("§8» §e0").setScore(2);
		o.getScore("§4§f").setScore(1);
		o.getScore("§7     §8§m-------------").setScore(0);
		player.setScoreboard(s);
	}

	public void setInGameScoreboard(Player player) {
		org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
		Scoreboard s = sm.getNewScoreboard();
		s.registerNewObjective("board", "dummy");
		Objective o = s.getObjective("board");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);

		Bukkit.getScheduler().runTask(JumpLeague.getInstance(), new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i != 15; i++) {
					o.setDisplayName("§6JumpLeague §8│ §7" + returnTime(player));
				}

				o.getScore("§7     §8§m-------------  §7").setScore(16);
				o.getScore("§7§8").setScore(15);
				o.getScore("§8┌│ §7Profil").setScore(14);
				o.getScore("§8» §e" + player.getName()).setScore(13);
				o.getScore("§9§3").setScore(12);
				o.getScore("§8┌│ §7Map").setScore(11);
				o.getScore("§8» §e" + JumpLeague.getInstance().getConfig().getString("Map")).setScore(10);
				o.getScore("§8§9").setScore(9);
				o.getScore("§8┌│ §7Spieler").setScore(8);
				o.getScore("§8» §e" + JumpLeague.getInstance().getAlivePlayers().size()).setScore(7);
				o.getScore("§4§f§7").setScore(4);
				o.getScore("§8┌│ §7CheckPoint").setScore(3);
				o.getScore("§8» §e" + JumpLeague.getInstance().getPlayerManager().get(player.getName()).getCheckPoint()).setScore(2);
				o.getScore("§4§f").setScore(1);
				o.getScore("§7     §8§m-------------").setScore(0);
				player.setScoreboard(s);
			}
		});

		}


	public void updateInGamePlayer(Player player) {
		org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
		Scoreboard s = sm.getNewScoreboard();
		s.registerNewObjective("board", "dummy");
		Objective o = s.getObjective("board");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);

		Bukkit.getScheduler().runTask(JumpLeague.getInstance(), new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i != 15; i++) {
					o.setDisplayName("§6JumpLeague §8│ §7" + returnTime(player));
				}

				o.getScore("§7     §8§m-------------  §7").setScore(16);
				o.getScore("§7§8").setScore(15);
				o.getScore("§8┌│ §7Profil").setScore(14);
				o.getScore("§8» §e" + player.getName()).setScore(13);
				o.getScore("§9§3").setScore(12);
				o.getScore("§8┌│ §7Map").setScore(11);
				o.getScore("§8» §e" + JumpLeague.getInstance().getConfig().getString("Map")).setScore(10);
				o.getScore("§8§9").setScore(9);
				o.getScore("§8┌│ §7Spieler").setScore(8);
				o.getScore("§8» §e" + JumpLeague.getInstance().getAlivePlayers().size()).setScore(7);
				o.getScore("§4§f§7").setScore(4);
				o.getScore("§8┌│ §7CheckPoint").setScore(3);
				o.getScore("§8» §e" + JumpLeague.getInstance().getPlayerManager().get(player.getName()).getCheckPoint()).setScore(2);
				o.getScore("§4§f").setScore(1);
				o.getScore("§7     §8§m-------------").setScore(0);
				player.setScoreboard(s);
			}
		});
	}

	public void updateInGameCheckPoint(Player player) {
		org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
		Scoreboard s = sm.getNewScoreboard();
		s.registerNewObjective("board", "dummy");
		Objective o = s.getObjective("board");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);

		Bukkit.getScheduler().runTask(JumpLeague.getInstance(), new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i != 15; i++) {
					o.setDisplayName("§6JumpLeague §8│ §7" + returnTime(player));
				}

				o.getScore("§7     §8§m-------------  §7").setScore(16);
				o.getScore("§7§8").setScore(15);
				o.getScore("§8┌│ §7Profil").setScore(14);
				o.getScore("§8» §e" + player.getName()).setScore(13);
				o.getScore("§9§3").setScore(12);
				o.getScore("§8┌│ §7Map").setScore(11);
				o.getScore("§8» §e" + JumpLeague.getInstance().getConfig().getString("Map")).setScore(10);
				o.getScore("§8§9").setScore(9);
				o.getScore("§8┌│ §7Spieler").setScore(8);
				o.getScore("§8» §e" + JumpLeague.getInstance().getAlivePlayers().size()).setScore(7);
				o.getScore("§4§f§7").setScore(4);
				o.getScore("§8┌│ §7CheckPoint").setScore(3);
				o.getScore("§8» §e" + JumpLeague.getInstance().getPlayerManager().get(player.getName()).getCheckPoint()).setScore(2);
				o.getScore("§4§f").setScore(1);
				o.getScore("§7     §8§m-------------").setScore(0);
				player.setScoreboard(s);
			}
		});
	}

	public void updateInGameTime(Player player) {
		org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
		Scoreboard s = sm.getNewScoreboard();
		s.registerNewObjective("board", "dummy");
		Objective o = s.getObjective("board");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);

		Bukkit.getScheduler().runTask(JumpLeague.getInstance(), new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i != 15; i++) {
					o.setDisplayName("§6JumpLeague §8│ §7" + returnTime(player));
				}

				o.getScore("§7     §8§m-------------  §7").setScore(16);
				o.getScore("§7§8").setScore(15);
				o.getScore("§8┌│ §7Profil").setScore(14);
				o.getScore("§8» §e" + player.getName()).setScore(13);
				o.getScore("§9§3").setScore(12);
				o.getScore("§8┌│ §7Map").setScore(11);
				o.getScore("§8» §e" + JumpLeague.getInstance().getConfig().getString("Map")).setScore(10);
				o.getScore("§8§9").setScore(9);
				o.getScore("§8┌│ §7Spieler").setScore(8);
				o.getScore("§8» §e" + JumpLeague.getInstance().getAlivePlayers().size()).setScore(7);
				o.getScore("§4§f§7").setScore(4);
				o.getScore("§8┌│ §7CheckPoint").setScore(3);
				o.getScore("§8» §e" + JumpLeague.getInstance().getPlayerManager().get(player.getName()).getCheckPoint()).setScore(2);
				o.getScore("§4§f").setScore(1);
				o.getScore("§7     §8§m-------------").setScore(0);
				player.setScoreboard(s);
			}
		});
	}

	public void setDeathMatchScoreboard(Player player) {
		org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
		Scoreboard s = sm.getNewScoreboard();
		s.registerNewObjective("board", "dummy");
		Objective o = s.getObjective("board");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("§6JumpLeague §8│ §7" + returnTime(player));
		o.getScore("§7     §8§m-------------  §7").setScore(16);
		o.getScore("§7§8").setScore(15);
		o.getScore("§8┌│ §7Profil").setScore(14);
		o.getScore("§8» §e" + player.getName()).setScore(13);
		o.getScore("§9§3").setScore(12);
		o.getScore("§8┌│ §7Map").setScore(11);
		o.getScore("§8» §e" + JumpLeague.getInstance().getConfig().getString("Map")).setScore(10);
		o.getScore("§8§9").setScore(9);
		o.getScore("§8┌│ §7Spieler").setScore(8);
		o.getScore("§8» §e" + JumpLeague.getInstance().getAlivePlayers().size()).setScore(7);
		o.getScore("§4§f§7").setScore(4);
		o.getScore("§8┌│ §7Leben").setScore(3);
		o.getScore("§8» §e" + JumpLeague.getInstance().getPlayerManager().get(player.getName()).getLives()).setScore(2);
		o.getScore("§4§f").setScore(1);
		o.getScore("§7     §8§m-------------").setScore(0);
		player.setScoreboard(s);
		}



	public void updateDeathMatchPlayer(Player player) {
		org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
		Scoreboard s = sm.getNewScoreboard();
		s.registerNewObjective("board", "dummy");
		Objective o = s.getObjective("board");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("§6JumpLeague §8│ §7" + returnTime(player));
		o.getScore("§7     §8§m-------------  §7").setScore(16);
		o.getScore("§7§8").setScore(15);
		o.getScore("§8┌│ §7Profil").setScore(14);
		o.getScore("§8» §e" + player.getName()).setScore(13);
		o.getScore("§9§3").setScore(12);
		o.getScore("§8┌│ §7Map").setScore(11);
		o.getScore("§8» §e" + JumpLeague.getInstance().getConfig().getString("Map")).setScore(10);
		o.getScore("§8§9").setScore(9);
		o.getScore("§8┌│ §7Spieler").setScore(8);
		o.getScore("§8» §e" + JumpLeague.getInstance().getAlivePlayers().size()).setScore(7);
		o.getScore("§4§f§7").setScore(4);
		o.getScore("§8┌│ §7Leben").setScore(3);
		o.getScore("§8» §e" + JumpLeague.getInstance().getPlayerManager().get(player.getName()).getLives()).setScore(2);
		o.getScore("§4§f").setScore(1);
		o.getScore("§7     §8§m-------------").setScore(0);
		player.setScoreboard(s);
	}

	public void updateDeathMatchLives(Player player) {
		org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
		Scoreboard s = sm.getNewScoreboard();
		s.registerNewObjective("board", "dummy");
		Objective o = s.getObjective("board");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("§6JumpLeague §8│ §7" + returnTime(player));
		o.getScore("§7     §8§m-------------  §7").setScore(16);
		o.getScore("§7§8").setScore(15);
		o.getScore("§8┌│ §7Profil").setScore(14);
		o.getScore("§8» §e" + player.getName()).setScore(13);
		o.getScore("§9§3").setScore(12);
		o.getScore("§8┌│ §7Map").setScore(11);
		o.getScore("§8» §e" + JumpLeague.getInstance().getConfig().getString("Map")).setScore(10);
		o.getScore("§8§9").setScore(9);
		o.getScore("§8┌│ §7Spieler").setScore(8);
		o.getScore("§8» §e" + JumpLeague.getInstance().getAlivePlayers().size()).setScore(7);
		o.getScore("§4§f§7").setScore(4);
		o.getScore("§8┌│ §7Leben").setScore(3);
		o.getScore("§8» §e" + JumpLeague.getInstance().getPlayerManager().get(player.getName()).getLives()).setScore(2);
		o.getScore("§4§f").setScore(1);
		o.getScore("§7     §8§m-------------").setScore(0);
		player.setScoreboard(s);
	}

	public void updateDeathMatchTime(Player player) {
		org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
		Scoreboard s = sm.getNewScoreboard();
		s.registerNewObjective("board", "dummy");
		Objective o = s.getObjective("board");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("§6JumpLeague §8│ §7" + returnTime(player));
		o.getScore("§7     §8§m-------------  §7").setScore(16);
		o.getScore("§7§8").setScore(15);
		o.getScore("§8┌│ §7Profil").setScore(14);
		o.getScore("§8» §e" + player.getName()).setScore(13);
		o.getScore("§9§3").setScore(12);
		o.getScore("§8┌│ §7Map").setScore(11);
		o.getScore("§8» §e" + JumpLeague.getInstance().getConfig().getString("Map")).setScore(10);
		o.getScore("§8§9").setScore(9);
		o.getScore("§8┌│ §7Spieler").setScore(8);
		o.getScore("§8» §e" + JumpLeague.getInstance().getAlivePlayers().size()).setScore(7);
		o.getScore("§4§f§7").setScore(4);
		o.getScore("§8┌│ §7Leben").setScore(3);
		o.getScore("§8» §e" + JumpLeague.getInstance().getPlayerManager().get(player.getName()).getLives()).setScore(2);
		o.getScore("§4§f").setScore(1);
		o.getScore("§7     §8§m-------------").setScore(0);
		player.setScoreboard(s);
	}

	public int time = 6000;
	public int started = 6000;
	public BukkitTask task;

	public String returnTime(Player player) {

		task = Bukkit.getScheduler().runTaskTimer(WaitCountdown.plugin, () -> {
			if (time != 0) {
				org.bukkit.scoreboard.ScoreboardManager sm = Bukkit.getScoreboardManager();
				Scoreboard s = sm.getNewScoreboard();
				s.registerNewObjective("board", "dummy");
				Objective o = s.getObjective("board");
				o.setDisplaySlot(DisplaySlot.SIDEBAR);
				o.getScore("§7     §8§m-------------  §7").setScore(16);
				o.getScore("§7§8").setScore(15);
				o.getScore("§8┌│ §7Profil").setScore(14);
				o.getScore("§8» §e" + player.getName()).setScore(13);
				o.getScore("§9§3").setScore(12);
				o.getScore("§8┌│ §7Map").setScore(11);
				o.getScore("§8» §e" + JumpLeague.getInstance().getConfig().getString("Map")).setScore(10);
				o.getScore("§8§9").setScore(9);
				o.getScore("§8┌│ §7Spieler").setScore(8);
				o.getScore("§8» §e" + JumpLeague.getInstance().getAlivePlayers().size()).setScore(7);
				o.getScore("§4§f§7").setScore(4);
				o.getScore("§8┌│ §7CheckPoint").setScore(3);
				o.getScore("§8» §e" + JumpLeague.getInstance().getPlayerManager().get(player.getName()).getCheckPoint()).setScore(2);
				o.getScore("§4§f").setScore(1);
				o.getScore("§7     §8§m-------------").setScore(0);
				player.setScoreboard(s);
			} else {

			}

			time--;
			task.cancel();
		}, 0L, 20L);

		return null;
	}

}
