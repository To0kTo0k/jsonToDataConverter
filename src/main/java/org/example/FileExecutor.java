package org.example;

import java.io.IOException;
import java.nio.file.*;

public class FileExecutor {

    private static final String FILENAME = "src/main/resources/ip-info.txt";

    public FileExecutor() {
    }

    /**
     * Put some info in file
     **/
    public void writeToFile(String data) {
        Path path = Paths.get(FILENAME);
        createFile();
        try {
            Files.writeString(path, data);
        } catch (IOException e) {
            System.out.println("Incorrect write to file");
        }
    }

    /**
     * Create file if not exists. If file exists - clean it
     */
    private void createFile() {
        Path path = Paths.get(FILENAME);
        try {
            if (Files.notExists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            System.out.println("Incorrect file creation");
        }
        try {
            Files.writeString(path, "");
        } catch (IOException e) {
            System.out.println("Incorrect file cleaning");
        }
    }
}
