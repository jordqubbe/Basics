package dev.jordgubbe.basics.items.listeners;

import dev.jordgubbe.basics.items.ItemManager;
import org.bukkit.Sound;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Objects;

public class TeleportBow implements Listener {

    @EventHandler
    public void onLeftClick(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.LEFT_CLICK_BLOCK) || event.getAction().equals(Action.LEFT_CLICK_AIR)) {
            if (event.getItem() != null) {
                if (Objects.equals(event.getItem().getItemMeta(), ItemManager.teleportBow.getItemMeta())) {
                    Player player = event.getPlayer();
                    if (player.isSneaking()) {
                        player.launchProjectile(EnderPearl.class);
                        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 0.7f, 1.0f);
                    }
                }
            }
        }
    }
}
