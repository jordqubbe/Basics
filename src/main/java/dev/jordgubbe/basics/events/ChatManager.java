package dev.jordgubbe.basics.events;

import dev.jordgubbe.basics.utils.Colorize;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatManager implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        event.setCancelled(true);
        Bukkit.broadcastMessage(Colorize.format("&a" + player.getName() + " &r&6\u00BB &r" + event.getMessage()));
    }
}
