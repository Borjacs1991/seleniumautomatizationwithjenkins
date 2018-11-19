package example;

import java.util.Date;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FirefoxTest {

	private final String google = "https://www.google.es/";

	@Test
	public void sendFirefoxTestDriver() {
		
		// Logger
		Date date = new Date();
		BasicConfigurator.configure();
		Logger OurLogger = LogManager.getLogger("OurLogger");

		FileAppender fileAppender = new FileAppender();
		fileAppender.setFile("ChromeLogfile.txt");
		fileAppender.setLayout(new SimpleLayout());

		OurLogger.addAppender(fileAppender);
		fileAppender.activateOptions();
		
		System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get(google);
		driver.navigate().to(google);
		System.out.println("Navigated to " + google);
		System.out.println("Firefox");
		// Selenium actions
		final String query = "q";
		final String queryText = "Spring";
		driver.findElement(By.name(query)).sendKeys(queryText);
		driver.findElement(By.name(query)).sendKeys(Keys.ENTER);

		System.out.println("Queries in input name " + query + " with value " + queryText);

		List<WebElement> results = driver.findElements(By.tagName("h3"));

		for (int i = 0; i < results.size(); i++) {
			System.out.println("Found: " + results.get(i).getText());
			OurLogger.info(date + " Registered: " + i + ". Found:" + results.get(i).getText());
		}
		
		driver.close();
	}
}
