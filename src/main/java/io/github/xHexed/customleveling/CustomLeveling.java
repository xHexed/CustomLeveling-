package io.github.xHexed.customleveling;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

/**
 * This is the main class for this plugin. It will allow a
 * server to define how much cp a player needs to level up.
 *
 * @author John Harrison
 */
public class CustomLeveling extends JavaPlugin implements Listener{
    Plugin plugin = this;
    CustomLeveling customLvl = this;

    /**
     * This is called when the plugin is enabled
     */
    @Override
    public void onEnable() {
        plugin.saveDefaultConfig();
        this.getCommand("cl").setExecutor(new Commands(this));
        getServer().getPluginManager().registerEvents(new LevelHandler(plugin), this);
        getLogger().info("CustomLeveling now implemented.");
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            Bukkit.getPluginManager().registerEvents(this, this);
            getLogger().info("Found PlaceholderAPI, using it now.");
        }
    }

    /**
     * This is called when the plugin is disabled
     */
    public void onDisable() {
        getLogger().info("Plugin disabled");
    }
}