package dev.jordgubbe.basics.items.listeners;

import dev.jordgubbe.basics.items.ItemDropManager;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class ItemDropListener implements Listener {

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntity() instanceof IronGolem) {
            Player player = event.getEntity().getKiller();
            event.getDrops().add(ItemDropManager.fancyRose);
        }
    }

}
