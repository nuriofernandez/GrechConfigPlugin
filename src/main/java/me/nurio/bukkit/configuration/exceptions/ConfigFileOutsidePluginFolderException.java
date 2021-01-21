package me.nurio.bukkit.configuration.exceptions;

import lombok.Getter;
import org.bukkit.plugin.Plugin;

import java.io.File;

@Getter
public class ConfigFileOutsidePluginFolderException extends RuntimeException {

    private File configFile;
    private Plugin plugin;

    public ConfigFileOutsidePluginFolderException(File file, Plugin plugin) {
        super(String.format(
            "%s file is outside of the %s plugin folder",
            file.getAbsolutePath(), plugin.getName()
        ));
        this.configFile = file;
        this.plugin = plugin;
    }

}