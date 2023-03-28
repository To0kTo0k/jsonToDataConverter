package org.example;

import org.example.datastructucture.HashmapOutputOperation;
import org.example.parser.JsonParser;

public class OutputChoose {
    /**
     * Program execution and choosing how to output result
     **/
    public void chooseStrategy(String dataStorage) {
        JsonParser jsonParser = new JsonParser();
        jsonParser.getDataFromSite();
        HashmapOutputOperation hashmapOutputOperation = new HashmapOutputOperation();
        hashmapOutputOperation.getStrategyHashMap().get(dataStorage.toUpperCase()).print(jsonParser.getDto());
    }
}
