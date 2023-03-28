package org.example.enumeration;

import lombok.Getter;
import org.example.strategy.OutputStrategy;
import org.example.strategy.impl.ConsoleOutputStrategy;
import org.example.strategy.impl.FileOutputStrategy;

@Getter
public enum OutputOperation {
    FILE(new FileOutputStrategy()),
    CONSOLE(new ConsoleOutputStrategy());

    private final OutputStrategy strategy;

    OutputOperation(OutputStrategy outputStrategy) {
        this.strategy = outputStrategy;
    }
}
