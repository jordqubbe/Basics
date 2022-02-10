package dev.jordgubbe.basics.commands;

import dev.jordgubbe.basics.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BasicsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to do this!");
            return true;
        } else {
            Player player = (Player) sender;
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
                player.sendMessage(ChatColor.RED + "You do not have the permission to run this command!");
            }
        }
        return true;
    }
}
