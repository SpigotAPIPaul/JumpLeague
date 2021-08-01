package de.spigotpaul.listeners;

import de.spigotpaul.JumpLeague;
import de.spigotpaul.methods.manager.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import de.spigotpaul.methods.mysql.Stats;

public class PlayerDeathListener implements Listener {
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		event.getDrops().clear();
		event.setDroppedExp(0);
		event.setDeathMessage(null);
		
		if(event.getEntity() instanceof Player) {
			if(event.getEntity().getKiller() != null) {
				if(event.getEntity().getKiller() instanceof Player) {
					Player entity = event.getEntity();
					Player killer = event.getEntity().getKiller();
					
					JumpLeague.getInstance().getMessagesManager().sendMessageToAll("§e§o■ §8┃ §6JumpLeague §8● (§e" + entity.getName() + "§8) §7wurde von §8(§e" + killer.getName() + "§8) §7getötet§8!");
					
					PlayerManager entityManager = JumpLeague.getInstance().getPlayerManager().get(entity.getName());
					PlayerManager killerManager = JumpLeague.getInstance().getPlayerManager().get(killer.getName());
					
					if(entityManager.getLives() > 1) {
						entityManager.setArmorContent(entity.getInventory().getArmorContents());	
						entityManager.setPlayerContent(entity.getInventory().getContents());
						entityManager.removeLife();
						
						killerManager.addKill();
						
						if(JumpLeague.getInstance().getMysqlactivated()) {
							JumpLeague.getInstance().getExecutorService().submit(() ->{
								Stats.addKills(killer.getUniqueId().toString(), 1);
							});
						}
						
						JumpLeague.getInstance().getScoreboardManager().updateDeathMatchLives(entity);
					} else {
						entityManager.addDeath();
						entityManager.removeLife();
						
						killerManager.addKill();
						
						if(JumpLeague.getInstance().getMysqlactivated()) {
							JumpLeague.getInstance().getExecutorService().submit(() ->{
								Stats.addKills(killer.getUniqueId().toString(), 1);
								Stats.addDeaths(entity.getUniqueId().toString(), 1);
								Stats.addVerloreneSpiele(entity.getUniqueId().toString(), 1);
							});
						}
						
						JumpLeague.getInstance().getMessagesManager().sendMessageToAll("§e§o■ §8┃ §6JumpLeague §8● (§e" + entity.getName() + "§8) §cist ausgeschieden§8!");
						JumpLeague.getInstance().getAlivePlayers().remove(entity.getName());
						JumpLeague.getInstance().getScoreboardManager().updateDeathMatchLives(entity);
						
						for(Player all : Bukkit.getOnlinePlayers()) {
							JumpLeague.getInstance().getScoreboardManager().updateInGamePlayer(all);
						}
					}
					
					entity.spigot().respawn();
				}
			} else {
				Player entity = event.getEntity();
				
				JumpLeague.getInstance().getMessagesManager().sendMessageToAll("§e§o■ §8┃ §6JumpLeague §8● §7" + entity.getName() + " §7ist verstorben§8!");
				
				PlayerManager entityManager = JumpLeague.getInstance().getPlayerManager().get(entity.getName());
				
				if(entityManager.getLives() > 1) {
					entityManager.setArmorContent(entity.getInventory().getArmorContents());	
					entityManager.setPlayerContent(entity.getInventory().getContents());
					entityManager.removeLife();

					JumpLeague.getInstance().getScoreboardManager().updateDeathMatchLives(entity);
				} else {
					entityManager.addDeath();
					entityManager.removeLife();
					
					if(JumpLeague.getInstance().getMysqlactivated()) {
						JumpLeague.getInstance().getExecutorService().submit(() ->{
							Stats.addDeaths(entity.getUniqueId().toString(), 1);
							Stats.addVerloreneSpiele(entity.getUniqueId().toString(), 1);
						});
					}
					
					JumpLeague.getInstance().getMessagesManager().sendMessageToAll("§e§o■ §8┃ §6JumpLeague §8● (§e" + entity.getName() + "§8) §cist ausgeschieden§8!");
					JumpLeague.getInstance().getAlivePlayers().remove(entity.getName());
					JumpLeague.getInstance().getScoreboardManager().updateDeathMatchLives(entity);
					
					for(Player all : Bukkit.getOnlinePlayers()) {
						JumpLeague.getInstance().getScoreboardManager().updateInGamePlayer(all);
					}
				}

				entity.spigot().respawn();
			}
		}
	}

}
