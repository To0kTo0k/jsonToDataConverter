package org.example.pattern;

import org.example.model.Data;

public class ConsoleStrategy implements Strategy {
    @Override
    public void printData(Data data) {
        System.out.println(data.getIp());
    }
}
