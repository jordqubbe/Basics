package dev.jordgubbe.basics.commands;

import dev.jordgubbe.basics.Basics;
import dev.jordgubbe.basics.utils.Colorize;
import lombok.AllArgsConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
public class GiveItem implements CommandExecutor {

    private final Basics plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(Colorize.format(plugin.getConfig().getString("messages.commands.player_only")));
            return true;
        } else {
            if (player.hasPermission("basics.admin")) {
                if (command.getName().equalsIgnoreCase("material")) {
                    if (args.length >= 2) {
                        try {
                            Material material = Material.valueOf(args[0].toUpperCase());
                            int amount = Integer.parseInt(args[1]);
                            for (int i = 0; i < amount; i++) {
                                player.getInventory().addItem(new ItemStack(material));
                            }
                            player.sendMessage(Colorize.format("&eAdded: &a" + amount + " " + args[0].toUpperCase().replace("_", " ") + "(S)"));
                        } catch (IllegalArgumentException exception) {
                            player.sendMessage(ChatColor.RED + "That is not a valid material!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "/material|item [material type] [amount]");
                    }
                }
            } else {
                player.sendMessage(Colorize.format(plugin.getConfig().getString("messages.commands.no_permission")));
            }
        }
        return true;
    }
}
