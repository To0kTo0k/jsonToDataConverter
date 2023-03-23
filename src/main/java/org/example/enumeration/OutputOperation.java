package org.example.enumeration;

import org.example.dto.DataDto;
import org.example.strategy.impl.ConsoleOutputStrategy;
import org.example.strategy.impl.FileOutputStrategy;
import org.example.strategy.OutputStrategy;

public enum OutputOperation {
    FILE {
        @Override
        public void printStrategy(DataDto dto) {
            OutputStrategy outputStrategy = new FileOutputStrategy();
            outputStrategy.print(dto);
        }
    },
    CONSOLE {
        @Override
        public void printStrategy(DataDto dto) {
            OutputStrategy outputStrategy = new ConsoleOutputStrategy();
            outputStrategy.print(dto);
        }
    };

    public abstract void printStrategy(DataDto dto);

    OutputOperation() {
    }
}
