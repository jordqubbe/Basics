package dev.jordgubbe.basics.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatManager implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        event.setCancelled(true);
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
                "&a" + player.getName() + " &r&6\u00BB &r" + event.getMessage()));
    }
}
