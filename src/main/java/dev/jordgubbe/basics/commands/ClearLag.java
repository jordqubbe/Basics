package dev.jordgubbe.basics.commands;

import dev.jordgubbe.basics.Basics;
import dev.jordgubbe.basics.utils.Colorize;
import lombok.AllArgsConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class ClearLag implements CommandExecutor {

    private final Basics plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Colorize.format(plugin.getConfig().getString("messages.commands.player_only")));
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
                    player.sendMessage(Colorize.format(plugin.getConfig().getString("messages.commands.no_permission")));
                }
            }
            return true;
        }
    }
}
