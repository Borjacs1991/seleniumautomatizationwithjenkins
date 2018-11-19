package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FirefoxTest {
	
	//private final String google = "https://www.google.es/";
	
	@Test
	public void sendFirefoxTestDriver() {
	 System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver.exe");
	 WebDriver driver = new FirefoxDriver();
	 driver.get("http://www.toolsqa.com");
	 //driver.get(google);
	}
}
