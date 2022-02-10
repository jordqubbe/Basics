package dev.jordgubbe.basics.items.listeners;

import dev.jordgubbe.basics.items.ItemManager;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

public class TripleShotBow implements Listener {

    @EventHandler
    public void onBowShoot(EntityShootBowEvent event) {
        if (event.getProjectile() instanceof Arrow && event.getEntity() instanceof Player player) {
            if (event.getBow() != null && event.getBow().equals(ItemManager.tripleShotBow)) {
                Arrow mainArrow = (Arrow) event.getProjectile();

                Arrow secondArrow = event.getEntity().getWorld().spawn(event.getEntity().getEyeLocation(), Arrow.class);
                secondArrow.setDamage(mainArrow.getDamage() / 2);
                secondArrow.setShooter(player);
                secondArrow.setVelocity(mainArrow.getVelocity().rotateAroundY(Math.toRadians(-15)));

                Arrow thirdArrow = event.getEntity().getWorld().spawn(event.getEntity().getEyeLocation(), Arrow.class);
                thirdArrow.setDamage(mainArrow.getDamage() / 2);
                thirdArrow.setShooter(player);
                thirdArrow.setVelocity(mainArrow.getVelocity().rotateAroundY(Math.toRadians(15)));
            }
        }
    }

    @EventHandler
    public void arrowLandEvent(ProjectileHitEvent event) {
        Projectile arrow = event.getEntity();
        if (arrow instanceof Arrow) {
            arrow.remove();
        }
    }
}
