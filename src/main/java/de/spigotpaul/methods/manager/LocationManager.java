package de.spigotpaul.methods.manager;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.spigotpaul.JumpLeague;

public class LocationManager {
	
	private File file = new File("plugins//JumpLeague//Location.yml");
	private FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public void setInGameLocation(Player player, String loc, Integer i) {
		cfg.set("JumpLeague." + loc + "." + i + ".World", player.getWorld().getName());
		cfg.set("JumpLeague." + loc + "." + i + ".X", player.getLocation().getX());
		cfg.set("JumpLeague." + loc + "." + i + ".Y", player.getLocation().getY());
		cfg.set("JumpLeague." + loc + "." + i + ".Z", player.getLocation().getZ());
		cfg.set("JumpLeague." + loc + "." + i + ".Yaw", player.getLocation().getYaw());
		cfg.set("JumpLeague." + loc + "." + i + ".Pitch", player.getLocation().getPitch());

		player.sendMessage(JumpLeague.getInstance().getPrefix() + "�7Die Location wurde gesetzt.");
		
		saveCfg();
	}
	
	public void setLocation(Player player, String loc) {
		cfg.set("JumpLeague." + loc + ".World", player.getWorld().getName());
		cfg.set("JumpLeague." + loc + ".X", player.getLocation().getX());
		cfg.set("JumpLeague." + loc + ".Y", player.getLocation().getY());
		cfg.set("JumpLeague." + loc + ".Z", player.getLocation().getZ());
		cfg.set("JumpLeague." + loc + ".Yaw", player.getLocation().getYaw());
		cfg.set("JumpLeague." + loc + ".Pitch", player.getLocation().getPitch());
		
		player.sendMessage(JumpLeague.getInstance().getPrefix() + "�7Die Location wurde gesetzt.");
		
		saveCfg();
	}
	
	public Location getInGameLocation(Player player, String loc, Integer i) {
		if(cfg.getString("JumpLeague." + loc + "." + i + ".World") != null) {
			World world = Bukkit.getWorld(cfg.getString("JumpLeague." + loc + "." + i + ".World"));
			double x = cfg.getDouble("JumpLeague." + loc + "." + i + ".X");
			double y = cfg.getDouble("JumpLeague." + loc + "." + i + ".Y");
			double z = cfg.getDouble("JumpLeague." + loc + "." + i + ".Z");
			
			Location location = new Location(world, x, y, z);
			location.setYaw(cfg.getInt("JumpLeague." + loc + "." + i + ".Yaw"));
			location.setPitch(cfg.getInt("JumpLeague." + loc + "." + i + ".Pitch"));
			
			return location;
		} else {
			return player.getLocation();
		}
	}
	
	public Location getLocation(Player player, String loc) {
		if(cfg.getString("JumpLeague." + loc + ".World") != null) {
			World world = Bukkit.getWorld(cfg.getString("JumpLeague." + loc + ".World"));
			double x = cfg.getDouble("JumpLeague." + loc + ".X");
			double y = cfg.getDouble("JumpLeague." + loc + ".Y");
			double z = cfg.getDouble("JumpLeague." + loc + ".Z");
			
			Location location = new Location(world, x, y, z);
			location.setYaw(cfg.getInt("JumpLeague." + loc + ".Yaw"));
			location.setPitch(cfg.getInt("JumpLeague." + loc + ".Pitch"));
			
			return location;
		} else {
			return player.getLocation();
		}
	}
	
	private void saveCfg() {
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
