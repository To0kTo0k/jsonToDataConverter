package org.example.strategy.impl;

import org.example.dto.DataDto;
import org.example.strategy.OutputStrategy;

public class ConsoleOutputStrategy implements OutputStrategy {
    @Override
    public void print(DataDto dto) {
        System.out.println(dto.getIp());
    }
}
