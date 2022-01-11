package dev.jordgubbe.basics;

import dev.jordgubbe.basics.commands.ClearLag;
import dev.jordgubbe.basics.commands.GiveItem;
import dev.jordgubbe.basics.events.ChatManager;
import dev.jordgubbe.basics.events.JoinLeaveEvents;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Basics extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Basics] Plug-in enabled.");
        registerEvents();
        registerCommands();
    }


    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new ChatManager(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveEvents(), this);
    }

    private void registerCommands() {
        getCommand("clearlag").setExecutor(new ClearLag());
        getCommand("material").setExecutor(new GiveItem());
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Basics] Plug-in disabled.");
    }
}
