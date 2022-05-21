package me.preciado.TrollGUI.Troll;

import org.bukkit.Bukkit;
import org.bukkit.entity.*;
import org.bukkit.World;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.entity.HumanEntity;
import org.bukkit.Material;
import me.preciado.TrollGUI.Troll.Bolt;

public class TNT {
    private final Player player;
    private final Location location;
    private final World world;
    public TNT(String playerName) {
        player = Bukkit.getPlayer(playerName);
        world = player.getWorld();
        location = player.getLocation();
        createTNTCage();
        for(int i = 0; i < 10; i++) {
            new Bolt(playerName);
        }
    }

    private void replaceBlock(double x, double y, double z) {
        Location pos = new Location(world, 0.0, 0.0, 0.0);
        pos.setX(location.getX() + x);
        pos.setY(location.getY() + y);
        pos.setZ(location.getZ() + z);
        world.getBlockAt(pos).setType(Material.TNT);
    }

    private void createTNTCage() {
        replaceBlock(1.0, 0.0, 0.0);
        replaceBlock(1.0, 1.0, 0.0);

        replaceBlock(0.0, 0.0, 1.0);
        replaceBlock(0.0, 1.0, 1.0);

        replaceBlock(-1.0, 0.0, 0.0);
        replaceBlock(-1.0, 1.0, 0.0);

        replaceBlock(0.0, 0.0, -1.0);
        replaceBlock(0.0, 1.0, -1.0);

        replaceBlock(0.0, 2.0, 0.0);
        replaceBlock(0.0, -1.0, 0.0);
    }
}
