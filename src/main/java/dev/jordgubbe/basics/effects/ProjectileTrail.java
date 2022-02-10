package dev.jordgubbe.basics.effects;

import dev.jordgubbe.basics.Basics;
import lombok.AllArgsConstructor;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
public class ProjectileTrail implements Listener {

    /**
     *
     * @// TODO: 2/9/22 - Make a GUI to be able to set the trail
     *
     */

    private final Map<Projectile, BukkitTask> tasks = new HashMap<>();
    private final Basics plugin;

    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent e) {
        if (e.getEntity().getShooter() instanceof Player player) {
            tasks.put(e.getEntity(), new BukkitRunnable() {
                @Override
                public void run() {
                    player.spawnParticle(Particle.ASH, e.getLocation(), 10);
                }
            }.runTaskTimerAsynchronously(plugin, 1L, 1L));
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {
        if (e.getEntity().getShooter() instanceof Player) {
            BukkitTask task = tasks.get(e.getEntity());
            if (task != null) {
                task.cancel();
                tasks.remove(e.getEntity());
            }
        }
    }
}
