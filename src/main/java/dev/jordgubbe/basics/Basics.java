package dev.jordgubbe.basics;

import dev.jordgubbe.basics.commands.BasicsCommand;
import dev.jordgubbe.basics.commands.ClearLag;
import dev.jordgubbe.basics.commands.GiveItem;
import dev.jordgubbe.basics.commands.Vanish;
import dev.jordgubbe.basics.effects.ProjectileTrail;
import dev.jordgubbe.basics.events.ChatManager;
import dev.jordgubbe.basics.events.JoinLeaveEvents;
import dev.jordgubbe.basics.items.ItemManager;
import dev.jordgubbe.basics.items.RecipeManager;
import dev.jordgubbe.basics.items.listeners.TeleportBow;
import dev.jordgubbe.basics.items.listeners.TripleShotBow;
import dev.jordgubbe.basics.utils.Colorize;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Basics extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(Colorize.format(getConfig().getString("messages.on_enable")));
        registerEvents();
        registerCommands();
        configMethods();
        ItemManager.init();
        RecipeManager.init();
    }

    public void configMethods() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new ChatManager(this), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveEvents(this), this);
        getServer().getPluginManager().registerEvents(new ProjectileTrail(this), this);
        getServer().getPluginManager().registerEvents(new TripleShotBow(), this);
        getServer().getPluginManager().registerEvents(new TeleportBow(), this);
    }

    private void registerCommands() {
        Objects.requireNonNull(getCommand("clearlag")).setExecutor(new ClearLag(this));
        Objects.requireNonNull(getCommand("material")).setExecutor(new GiveItem(this));
        Objects.requireNonNull(getCommand("vanish")).setExecutor(new Vanish(this));
        Objects.requireNonNull(getCommand("basics")).setExecutor(new BasicsCommand(this));
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(Colorize.format(getConfig().getString("messages.on_disable")));
    }
}
