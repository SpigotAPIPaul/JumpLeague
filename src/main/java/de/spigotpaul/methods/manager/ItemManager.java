package de.spigotpaul.methods.manager;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager {
	
	public ItemStack getItem(Material material, int amount) {
		ItemStack stack = new ItemStack(material, amount);
		return stack;
	}
	
	public ItemStack getItem(Material material, int id, int amount, String name) {
		ItemStack stack = new ItemStack(material, amount, (short) id);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(name);
		stack.setItemMeta(meta);
		return stack;
	}

}
