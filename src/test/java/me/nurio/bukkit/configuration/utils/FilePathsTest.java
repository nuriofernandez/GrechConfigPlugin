package me.nurio.bukkit.configuration.utils;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FilePathsTest {

    @Test
    public void fileInDirectory() {
        File file = new File(FilePaths.class.getClassLoader().getResource(".").getFile());
        File directory = file.getParentFile().getParentFile();

        assertTrue(FilePaths.isFileInDirectory(file, directory));
    }

    @Test
    public void directoryIsInFile() {
        File file = new File(FilePaths.class.getClassLoader().getResource(".").getFile());
        File directory = file.getParentFile().getParentFile();

        assertFalse(FilePaths.isFileInDirectory(directory, file));
    }

    @Test
    public void directoryIsInDirectory() {
        File file = new File(FilePaths.class.getClassLoader().getResource(".").getFile());
        File directory = file.getParentFile().getParentFile();

        assertTrue(FilePaths.isFileInDirectory(directory, directory));
    }

}