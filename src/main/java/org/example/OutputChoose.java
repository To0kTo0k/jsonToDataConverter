package org.example;

import org.example.datastructucture.HashmapOutputOperation;
import org.example.parser.JsonParser;

import java.io.IOException;

public class OutputChoose {
    /**
     * Choosing output strategy
     **/
    public void chooseStrategy(String dataStorage) {
        JsonParser jsonParser = new JsonParser();
        jsonParser.getDataFromSite();
        HashmapOutputOperation hashmapOutputOperation = new HashmapOutputOperation();
        hashmapOutputOperation.getStrategyHashMap().get(dataStorage.toUpperCase()).print(jsonParser.getDto());
    }
}
