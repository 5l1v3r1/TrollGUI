package me.preciado.TrollGUI.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import me.preciado.TrollGUI.Inventories.PlayersInventory;
import me.preciado.TrollGUI.Troll.*;

public class InventoryEvents implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if(e.getInventory() == null) return;
        Player player = (Player) e.getWhoClicked();
        HumanEntity ent = e.getWhoClicked();
        if(e.getInventory().getName().equals("Troll")) {
            e.setCancelled(true);
            String itemName = e.getCurrentItem().getItemMeta().getDisplayName();
            if(itemName.equals(ChatColor.RED + "" + ChatColor.BOLD + "Lightning bolt")) {
                new PlayersInventory(ent, "Bolt");
            }
            if(itemName.equals(ChatColor.RED + "" + ChatColor.BOLD + "TNT")) {
                new PlayersInventory(ent, "TNT");
            }
        }
        if(e.getInventory().getName().equals("Select player")) {
            e.setCancelled(true);
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("Next")) return;
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("Prev")) return;

            String playerName = e.getCurrentItem().getItemMeta().getDisplayName();
            String opt = e.getCurrentItem().getItemMeta().getLore().get(2);
            ent.closeInventory();
            switch(opt) {
                case "Bolt":
                    new Bolt(playerName);
                case "TNT":
                    new TNT(playerName);
                default:
                    break;
            }
        }
    }
}
