package org.example;

import org.example.enumeration.OutputOperation;
import org.example.parser.JsonParser;

public class OutputChoose {
    /**
     * Choosing output strategy
     **/
    public void chooseStrategy(String dataStorage) {
        JsonParser jsonParser = new JsonParser();
        jsonParser.getDataFromSite();
        OutputOperation.valueOf(dataStorage.toUpperCase()).getOperation().print(jsonParser.getDto());
    }
}
