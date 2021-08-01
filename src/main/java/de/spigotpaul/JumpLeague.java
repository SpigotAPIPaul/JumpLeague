package de.spigotpaul;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import de.spigotpaul.methods.gamestate.GameState;
import de.spigotpaul.methods.manager.ActionBarManager;
import de.spigotpaul.methods.manager.LocationManager;
import de.spigotpaul.methods.manager.MessagesManager;
import de.spigotpaul.methods.manager.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.reflect.ClassPath;

import de.spigotpaul.commands.BuildCommand;
import de.spigotpaul.commands.JumpLeagueCommand;
import de.spigotpaul.commands.StartCommand;
import de.spigotpaul.commands.StatsCommand;
import de.spigotpaul.methods.countdowns.DeathMatchCountdown;
import de.spigotpaul.methods.countdowns.InGameCountdown;
import de.spigotpaul.methods.countdowns.LobbyCountdown;
import de.spigotpaul.methods.countdowns.RestartCountdown;
import de.spigotpaul.methods.countdowns.WarteCountdown;
import de.spigotpaul.methods.manager.ChestManager;
import de.spigotpaul.methods.manager.ItemManager;
import de.spigotpaul.methods.manager.PlayerManager;
import de.spigotpaul.methods.mysql.MySQL;
import de.spigotpaul.methods.scoreboard.PacketScoreboard;

public class JumpLeague extends JavaPlugin {
	
	private static JumpLeague instance;
	private String prefix = "§e§o■ §8┃ §6JumpLeague §8● §7";
	private GameState gameState;
	private Integer minPlayers;
	private Integer maxPlayers;
	private MySQL mysql;
	private Boolean mysqlactivated;

	private ExecutorService executorService = Executors.newCachedThreadPool();
	
	private List<String> buildPlayer = Lists.newArrayList();
	private List<String> alivePlayers = Lists.newArrayList();
	
	private HashMap<String, PacketScoreboard> scoreBoard = Maps.newHashMap();
	private HashMap<String, PlayerManager> playerManager = Maps.newHashMap();
	
	private ActionBarManager actionBarManager = new ActionBarManager();
	private ItemManager itemManager = new ItemManager();
	private LocationManager locationManager = new LocationManager();
	private ScoreboardManager scoreboardManager = new ScoreboardManager();
	private MessagesManager messagesManager = new MessagesManager();
	private ChestManager chestManager = new ChestManager();
	
	private LobbyCountdown lobbyCountdown = new LobbyCountdown();
	private InGameCountdown inGameCountdown = new InGameCountdown();
	private DeathMatchCountdown deathMatchCountdown = new DeathMatchCountdown();
	private RestartCountdown restartCountdown = new RestartCountdown();
	private WarteCountdown warteCountdown = new WarteCountdown();
	
	public void onEnable() {
		instance = this;
		
		saveDefaultConfig();
		
		gameState = GameState.LOBBY;
		minPlayers = Integer.valueOf(getConfig().getString("minPlayers"));
		maxPlayers = Integer.valueOf(getConfig().getString("maxPlayers"));
		mysqlactivated = getConfig().getBoolean("MySQL");
		chestManager.registerLoot();
		
		registerCommands();
		registerListener();
		
		for(World worlds : Bukkit.getWorlds()){
			Bukkit.unloadWorld(worlds, false);
			worlds.setAutoSave(false);
			worlds.setTime(1000);
			worlds.setGameRuleValue("doDaylightCycle", "false");
			
			for(Entity entity : worlds.getEntities()) {
				if(!(entity instanceof Player)) {
					entity.remove();
				}
			}
			for(Entity entity : worlds.getLivingEntities()) {
				if(!(entity instanceof Player)) {
					entity.remove();
				}
			}
		}
		
		executorService.submit(() ->{
			lobbyCountdown.startCountdown();
		});
		
		if(mysqlactivated){
			connectMySQL();
		}
	}
	
	@SuppressWarnings("rawtypes")
	private void registerListener() {
		PluginManager pluginManager = getServer().getPluginManager();
		UnmodifiableIterator localUnmodifiableIterator;
		try {
			for (localUnmodifiableIterator = ClassPath.from(getClassLoader())
					.getTopLevelClasses("de.spigotpaul.listeners").iterator(); localUnmodifiableIterator.hasNext();) {
				ClassPath.ClassInfo classInfo = (ClassPath.ClassInfo) localUnmodifiableIterator.next();
				Class clazz = Class.forName(classInfo.getName());
				if (Listener.class.isAssignableFrom(clazz)) {
					pluginManager.registerEvents((Listener) clazz.newInstance(), this);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void registerCommands() {
		getCommand("jumpleague").setExecutor(new JumpLeagueCommand());
		getCommand("start").setExecutor(new StartCommand());
		getCommand("stats").setExecutor(new StatsCommand());
		getCommand("build").setExecutor(new BuildCommand());
	}
	
	public static JumpLeague getInstance() {
		return instance;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public GameState getGameState() {
		return gameState;
	}
	
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public ActionBarManager getActionBarManager() {
		return actionBarManager;
	}
	
	public ChestManager getChestManager() {
		return chestManager;
	}
	
	public List<String> getBuildPlayer() {
		return buildPlayer;
	}
	
	public ItemManager getItemManager() {
		return itemManager;
	}
	
	public LocationManager getLocationManager() {
		return locationManager;
	}
	
	public ScoreboardManager getScoreboardManager() {
		return scoreboardManager;
	}
	
	public MessagesManager getMessagesManager() {
		return messagesManager;
	}
	
	public HashMap<String, PlayerManager> getPlayerManager() {
		return playerManager;
	}
	
	public ExecutorService getExecutorService() {
		return executorService;
	}
	
	public InGameCountdown getInGameCountdown() {
		return inGameCountdown;
	}
	
	public RestartCountdown getRestartCountdown() {
		return restartCountdown;
	}
	
	public LobbyCountdown getLobbyCountdown() {
		return lobbyCountdown;
	}
	
	public Integer getMaxPlayers() {
		return maxPlayers;
	}
	
	public WarteCountdown getWarteCountdown() {
		return warteCountdown;
	}
	
	public DeathMatchCountdown getDeathMatchCountdown() {
		return deathMatchCountdown;
	}
	
	public HashMap<String, PacketScoreboard> getScoreBoard() {
		return scoreBoard;
	}
	
	public Integer getMinPlayers() {
		return minPlayers;
	}
	
	public List<String> getAlivePlayers() {
		return alivePlayers;
	}
	
	public MySQL getMysql() {
		return mysql;
	}
	
	public Boolean getMysqlactivated() {
		return mysqlactivated;
	}
	
	private void connectMySQL() {
		mysql = new MySQL(getConfig().getString("Host"), getConfig().getString("Datenbank"), getConfig().getString("Benutzer"), getConfig().getString("Passwort"));
		mysql.update("CREATE TABLE IF NOT EXISTS JumpLeague(UUID varchar(64), KILLS int, DEATHS int, BETTEN int, GSPIELE int, VSPIELE int, GESPIELE int);");
	}
	
}
