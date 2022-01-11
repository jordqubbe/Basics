package dev.jordgubbe.basics.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GiveItem implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to do this!");
            return true;
        } else {
            Player player = (Player) sender;
            if (player.hasPermission("basics.admin")) {
                if (command.getName().equalsIgnoreCase("material")) {
                    if (args.length >= 2) {
                        try {
                            Material material = Material.valueOf(args[0].toUpperCase());
                            int amount = Integer.parseInt(args[1]);
                            for (int i = 0; i < amount; i++) {
                                player.getInventory().addItem(new ItemStack(material));
                            }
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                                    "&eAdded: &a" + amount + " " + args[0].toUpperCase().replace("_", " ") + "(S)"));
                        } catch (IllegalArgumentException exception) {
                            player.sendMessage(ChatColor.RED + "That is not a valid material!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "/material|item <material type> <amount>");
                    }
                }
            } else {
                player.sendMessage(ChatColor.RED + "You do not have the permission to run this command!");
            }
        }
        return true;
    }
}
