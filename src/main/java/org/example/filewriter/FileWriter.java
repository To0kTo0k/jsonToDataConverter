package org.example.filewriter;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriter {

    private static final String FILEPATH = "src/main/resources/ip-info.txt";

    /**
     * Put some info in file
     **/
    public void writeToFile(String data) {
        byte[] bytes = data.getBytes();
        try (OutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(Paths.get(FILEPATH)))) {
            for (byte everyByte:bytes) {
                outputStream.write(everyByte);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
