package me.nurio.bukkit.configuration.files;

import lombok.Getter;
import me.nurio.bukkit.configuration.exceptions.ConfigFileOutsidePluginFolderException;
import me.nurio.bukkit.configuration.parsers.LocationConfigParser;
import me.nurio.bukkit.configuration.utils.FilePaths;
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

    public GrechConfig(@NotNull Plugin plugin, File file) {
        this.plugin = plugin;

        // Map plugin setting file.
        this.configFile = file;

        // Assert that the provided config file is inside plugin data folder.
        if (!FilePaths.isFileInDirectory(file, plugin.getDataFolder())) {
            throw new ConfigFileOutsidePluginFolderException(file, plugin);
        }

        // Create default config files or empty ones.
        saveDefaultConfig();

        // Parse YAML and load settings.
        this.config = YamlConfiguration.loadConfiguration(configFile);
    }

    public GrechConfig(@NotNull Plugin plugin, String filename) {
        this(plugin, new File(plugin.getDataFolder(), filename.endsWith(".yml") ? filename : filename + ".yml"));
    }

    public GrechConfig(String filename, @NotNull Plugin plugin) {
        this(plugin, filename);
    }

    public GrechConfig(File file, @NotNull Plugin plugin) {
        this(plugin, file);
    }

    /**
     * Reloads config file from disk.
     */
    public void reload() {
        this.config = YamlConfiguration.loadConfiguration(configFile);
    }

}