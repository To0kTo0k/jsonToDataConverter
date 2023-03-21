package org.example.pattern;

import org.example.FileExecutor;
import org.example.model.Data;

public class FileStrategy implements Strategy {
    @Override
    public void printData(Data data) {
        FileExecutor fileExecutor = new FileExecutor();
        fileExecutor.writeToFile(data.getIp());
    }
}
