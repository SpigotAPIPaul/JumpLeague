package de.spigotpaul.methods.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import de.spigotpaul.JumpLeague;
import de.spigotpaul.methods.gamestate.GameState;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class ChestManager {
	
	public HashMap<Location, Inventory> deathInventory = Maps.newHashMap();
	
	private HashMap<Location, Inventory> chestInventory = Maps.newHashMap();
	private List<ItemStack> loot = Lists.newArrayList();
	
	public void openChest(Player player, Location location) {
		if(JumpLeague.getInstance().getGameState().equals(GameState.INGAME)) {
			if(!chestInventory.containsKey(location)) {
				Inventory inv = Bukkit.createInventory(null, 3*9, "§e§o■ §8┃ §6JumpLeague §8● §7Truhe");
				
				for(int i = 0; i < rndInt(4, 9); i++) {
					inv.setItem(rndInt(0, inv.getSize()-1), loot.get(rndInt(0, loot.size()-1)));
				}
				
				player.openInventory(inv);
				
				chestInventory.put(location, inv);
			} else {
				player.openInventory(chestInventory.get(location));
			}
		}
	}
	
	public void registerLoot() {
		loot.clear();
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.WOOD_SWORD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_HELMET, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.APPLE, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_HELMET, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.GOLD_CHESTPLATE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_CHESTPLATE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BAKED_POTATO, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.GOLDEN_APPLE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BOW, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.STONE_SWORD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.FISHING_ROD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.WEB, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.ARROW, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.DIAMOND_CHESTPLATE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BAKED_POTATO, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.MELON, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.APPLE, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.COOKED_CHICKEN, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.COOKED_BEEF, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.GOLD_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.WOOD_SWORD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BOW, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_HELMET, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.STONE_SWORD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.APPLE, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_HELMET, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.GOLD_CHESTPLATE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_CHESTPLATE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BAKED_POTATO, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.STONE_SWORD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BAKED_POTATO, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.ARROW, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.MELON, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.APPLE, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.STONE_SWORD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.COOKED_CHICKEN, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.COOKED_BEEF, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.GOLD_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.WOOD_SWORD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.FISHING_ROD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_HELMET, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.WEB, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BOW, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.APPLE, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_HELMET, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.GOLD_CHESTPLATE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.STONE_AXE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_CHESTPLATE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BAKED_POTATO, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_SWORD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.ARROW, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BAKED_POTATO, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.STONE_SWORD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.MELON, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.APPLE, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.DIAMOND_CHESTPLATE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.COOKED_CHICKEN, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.COOKED_BEEF, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.GOLD_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.WOOD_SWORD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BOW, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_HELMET, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.APPLE, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_HELMET, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.GOLD_CHESTPLATE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_CHESTPLATE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BAKED_POTATO, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.GOLDEN_APPLE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.STONE_SWORD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.WEB, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.ARROW, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BAKED_POTATO, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.MELON, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.APPLE, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.COOKED_CHICKEN, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.COOKED_BEEF, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.GOLD_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BOW, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_HELMET, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.APPLE, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_HELMET, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.GOLD_CHESTPLATE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.STONE_SWORD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.STONE_AXE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.FISHING_ROD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_CHESTPLATE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BAKED_POTATO, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.GOLDEN_APPLE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.STICK, rndInt(1, 3)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BAKED_POTATO, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.MELON, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.APPLE, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.COOKED_CHICKEN, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.COOKED_BEEF, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.GOLD_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BOW, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.WEB, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.WOOD_SWORD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.STONE_SWORD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.DIAMOND_CHESTPLATE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_HELMET, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.APPLE, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_HELMET, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.GOLD_CHESTPLATE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_CHESTPLATE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BAKED_POTATO, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_SWORD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.ARROW, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BAKED_POTATO, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.MELON, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.STONE_SWORD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.APPLE, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.FISHING_ROD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.COOKED_CHICKEN, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BOW, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.COOKED_BEEF, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.GOLD_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_HELMET, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.APPLE, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_HELMET, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.GOLD_CHESTPLATE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.STONE_SWORD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_CHESTPLATE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.WEB, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.ARROW, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BAKED_POTATO, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.STONE_SWORD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BAKED_POTATO, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.MELON, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BOW, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.APPLE, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.COOKED_CHICKEN, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.COOKED_BEEF, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.GOLD_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.WOOD_SWORD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.DIAMOND_CHESTPLATE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_HELMET, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.ARROW, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.FISHING_ROD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.APPLE, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_HELMET, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.STONE_SWORD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.GOLD_CHESTPLATE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_CHESTPLATE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BAKED_POTATO, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.GOLDEN_APPLE, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.WEB, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BOW, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.BAKED_POTATO, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.MELON, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.STONE_SWORD, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.APPLE, rndInt(1, 4)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.IRON_BOOTS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.COOKED_CHICKEN, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.CHAINMAIL_LEGGINGS, 1));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.COOKED_BEEF, rndInt(1, 5)));
		loot.add(JumpLeague.getInstance().getItemManager().getItem(Material.GOLD_BOOTS, 1));
	}

	private Integer rndInt(int min, int max){
		Random r = new Random();
		int i = r.nextInt((max-min) + 1) +min;
		return i;
	}
	
}
