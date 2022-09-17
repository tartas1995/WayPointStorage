package me.tartas1995.waypointstorage.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class WayPointFile {
    private static File file;
    private static FileConfiguration customFile;

    public static void setup() {
        // find (and create if needed) file and load it as yaml
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("WayPointStorage").getDataFolder(), "waypoints.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get() {
        return customFile;
    }

    public static void save() {
        try {
            customFile.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void reload() {
        customFile = YamlConfiguration.loadConfiguration(file);
    }
}
