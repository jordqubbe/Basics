package dev.jordgubbe.basics.events;

import dev.jordgubbe.basics.Basics;
import dev.jordgubbe.basics.utils.Colorize;
import lombok.AllArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

@AllArgsConstructor
public class ChatManager implements Listener {

    final private Basics plugin;

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        event.setCancelled(true);

        if (player.hasPermission("basics.admin")) {
            Bukkit.broadcastMessage(Colorize.format("&c" + player.getDisplayName() + plugin.getConfig().getString("chat.admin") + event.getMessage()));
        } else if (player.hasPermission("basics.player")) {
            Bukkit.broadcastMessage(Colorize.format("&a" + player.getDisplayName() + plugin.getConfig().getString("chat.normal") + event.getMessage()));
        }
    }
}
