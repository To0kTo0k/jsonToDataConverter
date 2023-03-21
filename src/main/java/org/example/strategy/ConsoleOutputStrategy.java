package org.example.strategy;

import org.example.dto.DataDto;

public class ConsoleOutputStrategy implements OutputStrategy {
    @Override
    public void print(DataDto dto) {
        System.out.println(dto.getIp());
    }
}
