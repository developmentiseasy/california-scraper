package com.california.scraper.scrapers;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.california.scraper.connection.JsoupWebConnection.getDocument;

public class MainPageScraper {
    public void runScrap() throws IOException {
        Document mainPageDocument = getDocument("https://leginfo.legislature.ca.gov/faces/codes.xhtml").parse();
        Elements linksOfCategory = mainPageDocument.select(".displaycodeleftmargin > div > div > a");

        List<String> linksOfCategoryList = linksOfCategory.stream()
                .map(element -> element.attr("abs:href"))
                .collect(Collectors.toList());

        for (String categoryUrl : linksOfCategoryList) {
            Document categoryDocument = getDocument(categoryUrl).parse();

            List<String> linksOfStatutes = categoryDocument.select(".codes_toc_list a").stream()
                    .map(element -> element.attr("abs:href"))
                    .collect(Collectors.toList());
            System.out.println("Scrap to statute");
            for (String statuteUrl : linksOfStatutes) {
                System.out.println(statuteUrl);
                Connection.Response statuteDocument = getDocument(statuteUrl);
                if (statuteDocument.statusCode() == 200) {
                    System.out.println("200");
                } else {
                    statuteDocument = getDocument(statuteDocument.header("location"));
                    System.out.println("Now 200");
                }
            }
        }

    }
}
