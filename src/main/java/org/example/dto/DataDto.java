package org.example.dto;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.example.model.Data;
import org.jsoup.Jsoup;

import java.io.IOException;

public class DataDto {
    private String jsonIp;

    public DataDto(String url) {
        try {
            this.jsonIp = Jsoup.connect(url).ignoreContentType(true).execute().body();
        } catch (IOException e) {
            System.out.println("Incorrect input connection");
        }
    }

    public String getJsonIp() {
        return jsonIp;
    }

    public void setJsonIp(String jsonIp) {
        this.jsonIp = jsonIp;
    }

    /**
     * Convert JSON row to Data object
     **/
    public Data convertJsonToData() {
        Gson gson = new Gson();
        Data data = new Data();
        try {
            data = gson.fromJson(this.jsonIp, Data.class);
        } catch (JsonSyntaxException e) {
            System.out.println("Incorrect Json to Data convertation");
        }
        return data;
    }
}
