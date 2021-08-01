package de.spigotpaul.methods.countdowns;

import de.spigotpaul.JumpLeague;
import de.spigotpaul.methods.gamestate.GameState;
import de.spigotpaul.methods.mysql.Stats;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

public class WaitCountdown {

    public int waitCountdown = 6000;

    public static Plugin plugin;

    public static void WaitCountdown(Plugin plugin) {
        WaitCountdown.plugin = plugin;
    }

    public int time = 6000;
    public int started = 6000;
    public BukkitTask task;

    public void startWaitCountdown() {

        task = Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            if(time != 0){
                Bukkit.broadcastMessage(String.valueOf(time));
                startWaitCountdown();
            }else{
                Bukkit.broadcastMessage("FERTIG!");
            }

            time--;
            task.cancel();
        },0L,20L);

    }

    }


