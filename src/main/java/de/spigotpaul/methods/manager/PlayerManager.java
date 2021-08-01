package de.spigotpaul.methods.manager;

import java.util.List;

import de.spigotpaul.JumpLeague;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.google.common.collect.Lists;

public class PlayerManager {
	
	private Integer kills, deaths, checkPoint, lives;
	private Location lastCheckPoint;
	private List<Location> lastCheckPoints;
	private ItemStack[] playerContent, armorContent;
	
	public PlayerManager() {
		this.kills = 0;
		this.deaths = 0;
		this.checkPoint = 1;
		this.lives = 3;
		this.lastCheckPoint = null;
		this.lastCheckPoints = Lists.newArrayList();
		
		this.playerContent = null;
		this.armorContent = null;
	}
	
	public void setLobbyState(Player player) {
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);
		player.setHealth(20);
		player.setFoodLevel(20);
		player.setGameMode(GameMode.ADVENTURE);
		player.setLevel(0);
		player.setExp(0);
		player.teleport(JumpLeague.getInstance().getLocationManager().getLocation(player, "lobby"));
		
		JumpLeague.getInstance().getPlayerManager().put(player.getName(), new PlayerManager());
		JumpLeague.getInstance().getScoreboardManager().setLobbyScoreboard(player);
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			JumpLeague.getInstance().getScoreboardManager().updateLobbyPlayer(all);
		}
	}
	
	public void setInGameState(Player player) {
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);
		player.setHealth(20);
		player.setFoodLevel(20);
		player.setGameMode(GameMode.SPECTATOR);
		player.setLevel(0);
		player.setExp(0);
		player.teleport(JumpLeague.getInstance().getLocationManager().getLocation(player, "spec"));
		
	}
	
	public Integer getKills() {
		return kills;
	}
	
	public void addKill() {
		this.kills += 1;
	}
	
	public Integer getDeaths() {
		return deaths;
	}
	
	public void addDeath() {
		this.deaths += 1;
	}
	
	public Integer getCheckPoint() {
		return checkPoint;
	}
	
	public void addCheckPoint() {
		this.checkPoint += 1;
	}
	
	public Location getLastCheckPoint() {
		return lastCheckPoint;
	}
	
	public Integer getLives() {
		return lives;
	}
	
	public void removeLife() {
		lives -= 1;
	}
	
	public void setLastCheckPoint(Location lastCheckPoint) {
		this.lastCheckPoint = lastCheckPoint;
	}
	
	public List<Location> getLastCheckPoints() {
		return lastCheckPoints;
	}
	
	public void addLastCheckPoint(Location lastCheckPoint) {
		this.lastCheckPoints.add(lastCheckPoint);
	}
	
	public ItemStack[] getPlayerContent() {
		return playerContent;
	}
	
	public ItemStack[] getArmorContent() {
		return armorContent;
	}
	
	public void setPlayerContent(ItemStack[] playerContent) {
		this.playerContent = playerContent;
	}
	
	public void setArmorContent(ItemStack[] armorContent) {
		this.armorContent = armorContent;
	}

}
