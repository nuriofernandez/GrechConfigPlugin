package me.nurio.bukkit.configuration.files;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Grech config plugin file handler.
 */
public interface GrechConfigFile {

    /**
     * Obtains the plugin where this config comes from.
     *
     * @return Bukkit plugin that created this config file.
     */
    @NotNull Plugin getPlugin();

    /**
     * Obtains Bukkit FileConfiguration ready to use instance.
     *
     * @return Bukkit FileConfiguration instance for this config file.
     */
    @NotNull FileConfiguration getConfig();

    /**
     * Obtains this config instance disk file.
     *
     * @return This config instance disk file.
     */
    @NotNull File getConfigFile();

    /**
     * Sets a value to provided path using Bukkit FileConfiguration API.
     *
     * @param path  YAML path to store the object.
     * @param value Object value to store at provided path.
     */
    default void set(String path, Object value) {
        getConfig().set(path, value);
    }

    /**
     * Saves this configuration to disk file.
     */
    default void save() {
        try {
            getConfig().save(getConfigFile());
        } catch (IOException ex) {
            System.err.println("Could not save config to " + getConfigFile().getName());
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Copy default config data from resources if not exists.
     * It will create an empty file in case no default resources found.
     */
    default void saveDefaultConfig() {
        if (fileExists()) return; // Prevent replacement of already saved config files.

        // Copy default plugin resources to data folder.
        if (existsDefaultConfig()) {
            getPlugin().saveResource(getConfigFile().getName(), false);
            return;
        }

        // Create an empty file to store setting in.
        try {
            getConfigFile().getParentFile().mkdirs();
            getConfigFile().createNewFile();
        } catch (IOException e) {
            System.err.println("Error creating plugin config file!");
            System.err.println(e.getMessage());
            throw new RuntimeException(e); // Rethrow the exception to avoid continuing.
        }
    }

    /**
     * Checks if the plugin has default config resources for this file name.
     *
     * @return true in case the plugin has default config resources.
     */
    default boolean existsDefaultConfig() {
        InputStream in = getPlugin().getResource(getConfigFile().getName());
        return in != null;
    }

    /**
     * Checks if the plugin data folder contains this file on disk.
     *
     * @return true in case it already exists.
     */
    default boolean fileExists() {
        return getConfigFile().exists();
    }

}