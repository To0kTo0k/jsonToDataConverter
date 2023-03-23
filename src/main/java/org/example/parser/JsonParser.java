package org.example.parser;

import com.google.gson.Gson;
import lombok.Getter;
import org.example.dto.DataDto;

import org.jsoup.Jsoup;

import java.io.IOException;

@Getter
public class JsonParser {
    private static final String URL = "https://api.ipify.org/?format=json";

    private DataDto dto;

    /**
     * Getting and converting json from site
     **/
    public void getDataFromSite() {
        try {
            String json = Jsoup.connect(URL).ignoreContentType(true).execute().body();
            this.dto = new Gson().fromJson(json, DataDto.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}



