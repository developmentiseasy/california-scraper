package com.california.scraper;

import com.california.scraper.scrapers.MainPageScraper;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication

public class ScraperApplication implements CommandLineRunner {

	public static void main(String[] args) {

		new SpringApplicationBuilder(ScraperApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.run(args);
	}

	@Override
	public void run(String... strings) throws Exception {
		MainPageScraper mainPageScraper = new MainPageScraper();
		mainPageScraper.runScrap();
	}
}
