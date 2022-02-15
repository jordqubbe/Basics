package dev.jordgubbe.basics.commands;

import dev.jordgubbe.basics.Basics;
import dev.jordgubbe.basics.items.ItemManager;
import dev.jordgubbe.basics.utils.Colorize;
import lombok.AllArgsConstructor;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class BasicsCommand implements CommandExecutor {

    private final Basics plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(Colorize.format(plugin.getConfig().getString("messages.commands.player_only")));
            return true;
        } else {
            if (player.hasPermission("basics.admin")) {
                if (command.getName().equalsIgnoreCase("basics")) {
                    if (args.length > 0) {
                        if (args[0].equalsIgnoreCase("item")) {
                            if (args[1].equalsIgnoreCase("teleport")) {
                                player.getInventory().addItem(ItemManager.teleportBow);
                            } else if (args[1].equalsIgnoreCase("triple")) {
                                player.getInventory().addItem(ItemManager.tripleShotBow);
                            }
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "/basics item [item]");
                    }
                }
            } else {
                player.sendMessage(Colorize.format(plugin.getConfig().getString("messages.commands.no_permission")));
            }
        }
        return true;
    }
}
