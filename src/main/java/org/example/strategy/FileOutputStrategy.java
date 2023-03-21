package org.example.strategy;

import org.example.FileExecutor;
import org.example.dto.DataDto;

public class FileOutputStrategy implements OutputStrategy {
    @Override
    public void print(DataDto dto) {
        FileExecutor fileExecutor = new FileExecutor();
        fileExecutor.writeToFile(dto.getIp());
    }
}
