package dev.jordgubbe.basics.commands;

import dev.jordgubbe.basics.utils.Colorize;
import lombok.AllArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.UUID;

@AllArgsConstructor
public class Vanish implements CommandExecutor {

    private final ArrayList<UUID> vanished = new ArrayList<>();
    private final Plugin plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Colorize.format(plugin.getConfig().getString("messages.commands.player_only")));
            return true;
        } else {
            Player player = (Player) sender;
            if (player.hasPermission("basics.admin")) {
                if (command.getName().equalsIgnoreCase("vanish")) {
                    if (vanished.contains(player.getUniqueId())) {
                        for (Player vanish : Bukkit.getOnlinePlayers()) {
                            vanish.showPlayer(plugin, player);
                            player.sendMessage(Colorize.format("&aNow visible to others!"));
                            vanished.remove(player.getUniqueId());
                        }
                    } else {
                        for (Player vanish : Bukkit.getOnlinePlayers()) {
                            vanish.showPlayer(plugin, player);
                            player.sendMessage(Colorize.format("&cNow invisible to others!"));
                            vanished.add(player.getUniqueId());
                        }
                    }
                }
            } else {
                player.sendMessage(Colorize.format(plugin.getConfig().getString("messages.commands.no_permission")));
            }
        }
        return true;
    }
}
