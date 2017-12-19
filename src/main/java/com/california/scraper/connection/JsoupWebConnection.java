package com.california.scraper.connection;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class JsoupWebConnection {
    public static Connection.Response getDocument(String url) throws IOException {
        System.out.println("Fetching: " + url);

        Connection.Response responce = Jsoup.connect(url)
                .followRedirects(false).execute();
            return responce;
    }
}
