package org.example.parser;

import com.google.gson.Gson;
import org.example.dto.DataDto;
import org.example.strategy.ConsoleOutputStrategy;
import org.example.strategy.FileOutputStrategy;
import org.example.strategy.OutputStrategy;
import org.jsoup.Jsoup;

import java.io.IOException;

public class JsonParser {
    public static final String URL = "https://api.ipify.org/?format=json";

    private OutputStrategy outputStrategy;

    /**
     * Choosing of output strategy
     **/
    public void chooseStrategy(String flag) {
        DataDto dto = getJsonFromSite();
        dto = jsonToData(dto.getIp());
        if (flag.equals("console")) {
            outputStrategy = new ConsoleOutputStrategy();
        }
        if (flag.equals("file")) {
            outputStrategy = new FileOutputStrategy();
        }
        outputStrategy.print(dto);
    }

    /**
     * Getting json from site
     **/
    public DataDto getJsonFromSite() {
        DataDto dto = new DataDto();
        try {
            dto.setIp(Jsoup.connect(URL).ignoreContentType(true).execute().body());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return dto;
    }

    /**
     * Convert raw JSON to Data
     **/
    public DataDto jsonToData(String json) {
        DataDto dto = new DataDto();
        try {
            dto = new Gson().fromJson(json, DataDto.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dto;
    }
}