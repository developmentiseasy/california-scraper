package com.california.scraper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static com.california.scraper.connection.JsoupWebConnection.getDocument;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScraperApplicationTests {

	@Test
	public void contextLoads() throws IOException {
		System.out.println(getDocument("https://leginfo.legislature.ca.gov/faces/codes_displayexpandedbranch.xhtml?tocCode=BPC&heading2=GENERAL+PROVISIONS"));
	}

}
