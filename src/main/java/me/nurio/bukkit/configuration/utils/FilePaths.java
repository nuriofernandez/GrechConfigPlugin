package me.nurio.bukkit.configuration.utils;

import java.io.File;

public interface FilePaths {

    /**
     * Checks if provided file is inside provided file directory.
     *
     * @param file      File to check.
     * @param directory Directory to check.
     * @return true in case the file is inside the directory.
     */
    static boolean isFileInDirectory(File file, File directory) {
        String fileAbsolutePath = file.getAbsolutePath();
        String pluginFolderPath = directory.getAbsolutePath();
        return fileAbsolutePath.startsWith(pluginFolderPath);
    }

}