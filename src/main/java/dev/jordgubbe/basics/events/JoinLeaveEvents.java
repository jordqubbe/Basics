package dev.jordgubbe.basics.events;

import dev.jordgubbe.basics.Basics;
import dev.jordgubbe.basics.utils.Colorize;
import lombok.AllArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

@AllArgsConstructor
public class JoinLeaveEvents implements Listener {

    private final Basics plugin;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(Colorize.format("&a" + player.getName() + " " + plugin.getConfig().getString("messages.join")));
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(Colorize.format("&a" + player.getName() + " " + plugin.getConfig().getString("messages.leave")));
    }
}
