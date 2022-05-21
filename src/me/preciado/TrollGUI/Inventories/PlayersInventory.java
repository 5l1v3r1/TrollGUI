package me.preciado.TrollGUI.Inventories;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class PlayersInventory {
    private final Inventory inv;
    private final Player player;
    private final HumanEntity ent;
    private final String option;
    public PlayersInventory(HumanEntity entity, String opt) {
        inv = Bukkit.createInventory(null, 54, "Select player");
        player = (Player) entity;
        ent = entity;
        option = opt;
        initItems();
        ent.openInventory(inv);
    }

    private void initItems() {
        for(Player lPlayer : Bukkit.getOnlinePlayers()) {
            inv.addItem(createItem(Material.FISHING_ROD, lPlayer.getDisplayName(), ChatColor.RED + "Is a player", ChatColor.BOLD + "Selected option:", option));
        }
    }

    protected ItemStack createItem(Material material, String name, String ... lore) {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);
        return item;
    }
}
