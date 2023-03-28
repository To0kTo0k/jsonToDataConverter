package org.example.datastructucture;

import lombok.Getter;
import org.example.strategy.OutputStrategy;
import org.example.strategy.impl.ConsoleOutputStrategy;
import org.example.strategy.impl.FileOutputStrategy;

import java.util.HashMap;

@Getter
public class HashmapOutputOperation {
    HashMap<String, OutputStrategy> strategyHashMap = new HashMap<>();

    public HashmapOutputOperation() {
        strategyHashMap.put("FILE", new FileOutputStrategy());
        strategyHashMap.put("CONSOLE", new ConsoleOutputStrategy());
    }
}
