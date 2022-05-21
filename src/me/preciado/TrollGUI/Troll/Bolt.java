package me.preciado.TrollGUI.Troll;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.*;


public class Bolt {
    private final Player player;
    public Bolt(String playerName) {
        player = Bukkit.getPlayer(playerName);
        summonBolt();
    }

    private void summonBolt() {
        World world = player.getWorld();
        Location location = player.getLocation();
        world.spawnEntity(location, EntityType.LIGHTNING);
    }
}
