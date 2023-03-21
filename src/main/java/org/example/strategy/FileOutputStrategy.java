package org.example.strategy;

import org.example.FileWriter;
import org.example.dto.DataDto;

public class FileOutputStrategy implements OutputStrategy {
    @Override
    public void print(DataDto dto) {
        FileWriter fileExecutor = new FileWriter();
        fileExecutor.writeToFile(dto.getIp());
    }
}
