package org.example.parser;

import com.google.gson.Gson;
import org.example.dto.DataDto;
import org.example.strategy.ConsoleOutputStrategy;
import org.example.strategy.FileOutputStrategy;
import org.example.strategy.OutputStrategy;
import org.jsoup.Jsoup;

import java.io.IOException;

public class JsonParser {
    private static final String URL = "https://api.ipify.org/?format=json";

    private static DataDto dto = new DataDto();

    public enum OutputOperation {
        FILE {
            @Override
            public void printStrategy() {
                OutputStrategy outputStrategy = new FileOutputStrategy();
                outputStrategy.print(dto);
            }
        },
        CONSOLE {
            @Override
            public void printStrategy() {
                OutputStrategy outputStrategy = new ConsoleOutputStrategy();
                outputStrategy.print(dto);
            }
        };

        public abstract void printStrategy();

        OutputOperation() {
        }
    }

    /**
     * Choosing output strategy
     **/
    public void chooseStrategy(String outputValue) {
        getJsonFromSite();
        jsonToData();
        OutputOperation.valueOf(outputValue.toUpperCase()).printStrategy();
    }

    /**
     * Getting json from site
     **/
    public void getJsonFromSite() {
        try {
            dto.setIp(Jsoup.connect(URL).ignoreContentType(true).execute().body());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Convert raw JSON to Data
     **/
    public void jsonToData() {
        try {
            dto = new Gson().fromJson(dto.getIp(), DataDto.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
