package dev.jordgubbe.basics.commands;

import dev.jordgubbe.basics.Basics;
import dev.jordgubbe.basics.lib.Item;
import dev.jordgubbe.basics.utils.Colorize;
import lombok.AllArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.ArrayList;

@AllArgsConstructor
public class LoreCommand implements CommandExecutor {

    /**
     * Just a testing command, not something I'm actually going to implement
     */

    private final Basics plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(Colorize.format(plugin.getConfig().getString("messages.commands.player_only")));
            return true;
        } else {
            if (player.hasPermission("basics.admin")) {
                if (command.getName().equalsIgnoreCase("lore")) {
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add("testing");
                    Item.setLore(player.getInventory().getItemInMainHand(), lore);
                    player.sendMessage("Lore updated");
                }
            } else {
                player.sendMessage(Colorize.format(plugin.getConfig().getString("messages.commands.no_permission")));
            }
        }
        return true;
    }
}
