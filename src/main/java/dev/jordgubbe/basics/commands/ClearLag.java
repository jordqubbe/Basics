package dev.jordgubbe.basics.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;

public class ClearLag implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to do this!");
            return true;
        } else {
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("clearlag")) {
                if (player.hasPermission("basics.admin")) {
                    for (Entity entity : player.getWorld().getEntities()) {
                        if (!(entity instanceof Player || entity instanceof Mob)) {
                            player.sendMessage(ChatColor.YELLOW + "Deleted lag-causing items on the ground.");
                            entity.remove();
                            return true;
                        }
                    }
                    player.sendMessage(ChatColor.RED + "No lag-causing items to delete.");
                    return true;
                } else {
                    player.sendMessage(ChatColor.RED + "You do not have permission to do this!");
                }
            }
            return true;
        }
    }
}
