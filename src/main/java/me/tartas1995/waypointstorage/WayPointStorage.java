package me.tartas1995.waypointstorage;

import me.tartas1995.waypointstorage.commands.CreateWayPointCommand;
import me.tartas1995.waypointstorage.commands.DeleteWayPointCommand;
import me.tartas1995.waypointstorage.commands.ListWayPointsCommand;
import me.tartas1995.waypointstorage.commands.ShowWayPointCommand;
import me.tartas1995.waypointstorage.entities.WayPoint;
import me.tartas1995.waypointstorage.files.WayPointFile;
import org.bukkit.configuration.MemorySection;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class WayPointStorage extends JavaPlugin {

    private static WayPointStorage plugin;
    private HashMap<String, WayPoint> wayPointHashMap;

    @Override
    public void onEnable() {
        plugin = this;
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        //load/create WayPointFile
        WayPointFile.setup();
        WayPointFile.get().options().copyDefaults(true);
        WayPointFile.save();

        this.wayPointHashMap = new HashMap<>();

        if (WayPointFile.get().isConfigurationSection("waypoints")) {
            Map<String,Object> loadedData = WayPointFile.get().getConfigurationSection("waypoints").getValues(false);
            for (String name: loadedData.keySet()) {
                MemorySection ms = (MemorySection) loadedData.get(name);
                if (ms.isInt("x") && ms.isInt("y") && ms.isInt("z")) {
                    WayPoint wp = new WayPoint();
                    wp.setX(ms.getInt("x"));
                    wp.setY(ms.getInt("y"));
                    wp.setZ(ms.getInt("z"));
                    this.wayPointHashMap.put(name, wp);
                }
            }
        }

        // register commands
        this.getCommand("createWayPoint").setExecutor(new CreateWayPointCommand());
        this.getCommand("deleteWayPoint").setExecutor(new DeleteWayPointCommand());
        this.getCommand("showWayPoint").setExecutor(new ShowWayPointCommand());
        this.getCommand("listWayPoints").setExecutor(new ListWayPointsCommand());
    }

    @Override
    public void onDisable() {
        WayPointFile.get().set("waypoints", this.wayPointHashMap);
        WayPointFile.save();
    }

    public HashMap<String, WayPoint> getWayPointHashMap() {
        return this.wayPointHashMap;
    }

    public static WayPointStorage getPlugin() {
        return plugin;
    }
}
