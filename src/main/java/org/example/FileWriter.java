package org.example;

import java.io.IOException;
import java.nio.file.*;

public class FileWriter {

    private static final Path FILEPATH = Paths.get("src/main/resources/ip-info.txt");

    /**
     * Put some info in file
     **/
    public void writeToFile(String data) {
        try {
            if (Files.notExists(FILEPATH)) {
                Files.createFile(FILEPATH);
            }
            Files.writeString(FILEPATH, data);
        } catch (IOException e) {
            System.out.println("Incorrect write to file");
        }
    }
}
