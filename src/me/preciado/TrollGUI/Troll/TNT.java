package me.preciado.TrollGUI.Troll;

import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.World;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.HumanEntity;
import org.bukkit.Material;

public class TNT {
    private final Player player;
    private final Location location;
    private final World world;
    public TNT(String playerName) {
        player = Bukkit.getPlayer(playerName);
        world = player.getWorld();
        location = player.getLocation();
        createTNTCage();
    }

    private void replaceBlock(double x, double y, double z) {
        Location pos;
        pos = location;
        pos.add(x, y, z);
        world.getBlockAt(pos).setType(Material.TNT);
    }

    private void createTNTCage() {
        replaceBlock(1.0, 0.0, 0.0);
    }
}
