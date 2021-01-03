package me.nurio.bukkit.configuration.files;

import lombok.Getter;
import me.nurio.bukkit.configuration.parsers.LocationConfigParser;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * Grech Configuration File instantiable class.
 * This class will manage all config related operations for config files.
 */
public class GrechConfig implements GrechConfigFile, LocationConfigParser {

    @Getter @NotNull private Plugin plugin;
    @Getter @NotNull private File configFile;
    @Getter @NotNull private FileConfiguration config;

    public GrechConfig(@NotNull Plugin plugin, String filename) {
        this.plugin = plugin;

        // Map plugin setting file.
        String configFileName = filename.endsWith(".yml") ? filename : filename + ".yml";
        this.configFile = new File(plugin.getDataFolder(), configFileName);

        // Create default config files or empty ones.
        saveDefaultConfig();

        // Parse YAML and load settings.
        this.config = YamlConfiguration.loadConfiguration(configFile);
    }

    public GrechConfig(String filename, @NotNull Plugin plugin) {
        this(plugin, filename);
    }

    /**
     * Reloads config file from disk.
     */
    public void reload() {
        this.config = YamlConfiguration.loadConfiguration(configFile);
    }

}