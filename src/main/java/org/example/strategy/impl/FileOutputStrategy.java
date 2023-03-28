package org.example.strategy.impl;

import org.example.dto.DataDto;
import org.example.strategy.OutputStrategy;
import org.example.writer.FileWriter;

public class FileOutputStrategy implements OutputStrategy {
    @Override
    public void print(DataDto dto) {
        FileWriter fileWriter = new FileWriter();
        fileWriter.writeToFile(dto.getIp());
    }
}
