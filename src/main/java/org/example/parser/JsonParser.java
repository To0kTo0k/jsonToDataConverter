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
    private static final String CONSOLE = "console";
    private static final String FILE = "file";

    private OutputStrategy outputStrategy;
    private  DataDto dto = new DataDto();

    /**
     * Choosing of output strategy
     **/
    public void chooseStrategy(String outputWay) {
        getJsonFromSite();
        jsonToData();
        try {
            switch (outputWay) {
                case FILE -> outputStrategy = new FileOutputStrategy();
                case CONSOLE -> outputStrategy = new ConsoleOutputStrategy();
                default -> throw new IllegalArgumentException("Incorrect input arg");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        printStrategy(dto);
    }

    /**Info output**/
    public void printStrategy(DataDto dto) {
        outputStrategy.print(dto);
    }

    /**
     * Getting json from site
     **/
    public void getJsonFromSite() {
        try {
            this.dto.setIp(Jsoup.connect(URL).ignoreContentType(true).execute().body());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Convert raw JSON to Data
     **/
    public void jsonToData() {
        try {
            this.dto = new Gson().fromJson(this.dto.getIp(), DataDto.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
