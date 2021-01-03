package me.nurio.bukkit.configuration;

import lombok.Getter;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * Bukkit plugin that simplifies configuration files usage.
 */
public class GrechConfigPlugin extends JavaPlugin {

    @Getter private static Plugin plugin;
    private static Logger logger;

    @Override
    public void onEnable() {
        plugin = this;
        logger = getLogger();

        logger.info("GrechConfig plugin enabled successfully!");
    }

}