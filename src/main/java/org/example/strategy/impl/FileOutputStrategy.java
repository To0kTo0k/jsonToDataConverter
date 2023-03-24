package org.example.strategy.impl;

import org.example.filewriter.FileWriter;
import org.example.dto.DataDto;
import org.example.strategy.OutputStrategy;

public class FileOutputStrategy implements OutputStrategy {
    @Override
    public void print(DataDto dto) {
        FileWriter fileExecutor = new FileWriter();
        fileExecutor.writeToFile(dto.getIp());
    }
}
