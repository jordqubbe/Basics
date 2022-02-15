package dev.jordgubbe.basics.commands;

import dev.jordgubbe.basics.Basics;
import dev.jordgubbe.basics.lib.Item;
import dev.jordgubbe.basics.utils.Colorize;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.UnhandledException;
import org.bukkit.Color;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@AllArgsConstructor
public class EnchantCommand implements CommandExecutor  {

    private final Basics plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(Colorize.format(plugin.getConfig().getString("messages.commands.player_only")));
            return true;
        } else {
            if (player.hasPermission("basics.admin")) {
                if (command.getName().equalsIgnoreCase("enchant")) {
                    if (args.length >= 2) {
                        ItemStack item = player.getInventory().getItemInMainHand();
                        Enchantment enchantment = EnchantmentWrapper.getByKey(NamespacedKey.minecraft(args[0]));
                        int level = Integer.parseInt(args[1]);

                        try {
                            Item.addEnchant(item, enchantment, level);
                            assert enchantment != null;
                            player.sendMessage(Colorize.format("&eAdded [&b" + enchantment.getKey() + " " + level + "&e] to the current held item!" ));
                        } catch (IllegalArgumentException | NullPointerException e) {
                            player.sendMessage(Colorize.format(plugin.getConfig().getString("messages.stack_trace.null")));
                        }

                    } else {
                        player.sendMessage(Colorize.format("&c/enchant [enchantment] [level]"));
                    }
                }
            } else {
                player.sendMessage(Colorize.format(plugin.getConfig().getString("messages.commands.no_permission")));
            }
        }
        return true;
    }
}
