package org.example.parser;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.example.dto.DataDto;
import org.example.strategy.ConsoleOutputStrategy;
import org.example.strategy.FileOutputStrategy;
import org.example.strategy.OutputStrategy;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Scanner;

public class JsonParser {
    public static final String URL = "https://api.ipify.org/?format=json";

    private OutputStrategy outputStrategy;

    /**
     * Getting json from site
     **/
    public DataDto getJsonFromSite() {
        DataDto dto = new DataDto();
        try {
            dto.setIp(Jsoup.connect(URL).ignoreContentType(true).execute().body());
        } catch (IOException e) {
            System.out.println("Incorrect input connection");
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
        } catch (JsonSyntaxException e) {
            System.out.println("Incorrect Json to Data convertation");
        }
        return dto;
    }

    /**
     * Choosing of output strategy
     **/
    public void chooseStrategy() {
        System.out.println("Введите true - для вывода в консоль, false - для вывода в файл");
        Scanner scanner = new Scanner(System.in);
        String flag = scanner.next();
        if (flag.equals("true")) {
            outputStrategy = new ConsoleOutputStrategy();
        }
        if (flag.equals("false")) {
            outputStrategy = new FileOutputStrategy();
        }
    }

    /**
     * Output data
     **/
    public void print(DataDto dto) {
        outputStrategy.print(dto);
    }
}
