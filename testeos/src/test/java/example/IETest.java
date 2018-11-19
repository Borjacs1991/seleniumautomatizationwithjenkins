package example;

import java.io.File;
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
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class IETest {

	private final String google = "https://www.google.es/";

	@Test
	public void sendTestIE() {

		// Selenium
		File file = new File("C:\\\\Driver\\\\IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		WebDriver driver = new InternetExplorerDriver();

		// Selenium actions
		driver.navigate().to(google);
		driver.findElement(By.name("q")).sendKeys("Spring");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

		List<WebElement> results = driver.findElements(By.tagName("h3"));

		for (int i = 0; i < results.size(); i++) {
			System.out.println("Found: " + results.get(i).getText());
		}

		driver.close();
	}

}
