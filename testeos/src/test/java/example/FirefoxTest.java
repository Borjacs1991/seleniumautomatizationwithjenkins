package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FirefoxTest {
	
	private final String google = "https://www.google.es/";
	
	@Test
	public void senFirefoxTest() {
	 System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver.exe");
	 WebDriver driver = new FirefoxDriver();
	 driver.get(google);
	 
	 try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	 driver.quit();
	}
	
}
