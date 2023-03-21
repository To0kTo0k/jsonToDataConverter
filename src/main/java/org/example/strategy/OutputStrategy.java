package org.example.strategy;


import org.example.dto.DataDto;

public interface OutputStrategy {
    void print(DataDto dto);
}
