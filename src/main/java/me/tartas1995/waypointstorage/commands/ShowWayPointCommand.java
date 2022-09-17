package me.tartas1995.waypointstorage.commands;

import me.tartas1995.waypointstorage.WayPointStorage;
import me.tartas1995.waypointstorage.entities.WayPoint;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class ShowWayPointCommand implements CommandExecutor {
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
                HashMap<String, WayPoint> map = WayPointStorage.getPlugin().getWayPointHashMap();
                if (map.containsKey(name)) {
                    WayPoint wp = map.get(name);
                    p.sendMessage( name + ": " + wp.toString());
                    return true;
                } else {
                    p.sendMessage("\"" + name + "\" is not a valid WayPoint!");
                    return true;
                }
            }
        }
        return false;
    }
}
