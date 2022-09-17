package me.tartas1995.waypointstorage.commands;

import me.tartas1995.waypointstorage.WayPointStorage;
import me.tartas1995.waypointstorage.entities.WayPoint;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateWayPointCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player p = (Player) commandSender;

            if (strings.length == 0) {
                p.sendMessage("You did not provide any arguments when running the command. Please try again");
            } else {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < strings.length; i++) {
                    builder.append(strings[i]);
                    builder.append(" ");
                }
                String name = builder.toString();
                name = name.trim();
                WayPoint wp = new WayPoint();
                Location loc = p.getLocation();
                wp.setX(loc.getBlockX());
                wp.setY(loc.getBlockY());
                wp.setZ(loc.getBlockZ());
                WayPointStorage.getPlugin().getWayPointHashMap().put(name, wp);
                p.sendMessage("\"" + name + "\" has been added");
                return true;
            }
        }
        return false;
    }
}
