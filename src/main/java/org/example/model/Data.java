package org.example.model;

import org.example.pattern.ConsoleStrategy;
import org.example.pattern.FileStrategy;

public class Data {
    private String ip;

    public Data() {
    }

    public Data(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void printData(boolean flag) {
        if (flag) {
            new ConsoleStrategy().printData(this);
        } else {
            new FileStrategy().printData(this);
        }
    }
}
