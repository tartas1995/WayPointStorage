package me.tartas1995.waypointstorage.commands;

import me.tartas1995.waypointstorage.WayPointStorage;
import me.tartas1995.waypointstorage.entities.WayPoint;
import me.tartas1995.waypointstorage.files.WayPointFile;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ListWayPointsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;
            HashMap<String, WayPoint> waypoints = WayPointStorage.getPlugin().getWayPointHashMap();
            StringBuilder builder = new StringBuilder();
            Set<String> wayPointNames = waypoints.keySet();
            if (wayPointNames.size() == 0) {
                p.sendMessage("No WayPoints found!");
                return true;
            }
            boolean first = true;
            for (String name: wayPointNames) {
                if (!first) {
                    builder.append(", ");
                } else {
                    first = false;
                }
                builder.append(name);
            }
            String name = builder.toString();
            p.sendMessage(name);
            return true;
        }
        return false;
    }
}
