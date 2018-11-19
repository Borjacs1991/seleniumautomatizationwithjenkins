package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.session.FirefoxFilter;
import org.testng.annotations.Test;

public class FirefoxTest {

	// private final String google = "https://www.google.es/";

	@Test
	public void sendFirefoxTestDriver() {
		System.setProperty("webdriver.gecko.driver", "C:\\Driver\\geckodriver.exe");
		WebDriver driver = (WebDriver) new FirefoxFilter();
		driver.get("http://www.toolsqa.com");
		// driver.get(google);
	}
}
