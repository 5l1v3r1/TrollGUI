package me.preciado.TrollGUI.Commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;

import java.util.Arrays;

public class CommandTroll implements CommandExecutor {
    private final Inventory inv;

    Player player;
    HumanEntity ent;

    public CommandTroll() {
        inv = Bukkit.createInventory(null, 9, "Troll");
        initItems();
    }

    protected ItemStack createItem(Material material, String name, String ... lore) {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);
        return item;
    }

    private void initItems() {
        inv.addItem(createItem(Material.FIREBALL, ChatColor.RED + "" + ChatColor.BOLD + "Lightning bolt", ChatColor.WHITE + "This option summons a bolt", ChatColor.WHITE + "at the player position."));
        inv.addItem(createItem(Material.TNT, ChatColor.RED + "" + ChatColor.BOLD + "TNT", ChatColor.WHITE + "Spawns a TNT square", ChatColor.WHITE + "at player position"));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player && sender instanceof HumanEntity) {
            player = (Player) sender;
            ent = (HumanEntity) sender;

            if(player.isOp()) {
                ent.openInventory(inv);
            } else {
                player.sendMessage(ChatColor.RED + "[ERROR] You need to be an operator to execute this command.");
            }
        } else {
            Bukkit.getLogger().info("This command can only be executed as a player.");
        }

        return true;
    }
}
