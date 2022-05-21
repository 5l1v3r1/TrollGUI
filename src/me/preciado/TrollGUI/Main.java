package me.preciado.TrollGUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import me.preciado.TrollGUI.Commands.CommandTroll;
import me.preciado.TrollGUI.Events.InventoryEvents;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getLogger().info(ChatColor.GREEN + this.getName() + " plugin enabled");
        this.getCommand("troll").setExecutor(new CommandTroll());
        this.getServer().getPluginManager().registerEvents(new InventoryEvents(), this);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(ChatColor.RED + this.getName() + " plugin disabled");
    }
}
