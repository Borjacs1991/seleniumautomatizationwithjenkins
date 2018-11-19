package example;

import java.io.File;
import java.util.Date;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IETest {

	private final String google = "https://www.google.es/";

	@Test
	public void sendTestIE() {

		// Logger
		Date date = new Date();
		BasicConfigurator.configure();
		Logger OurLogger = LogManager.getLogger("OurLogger");

		FileAppender fileAppender = new FileAppender();
		fileAppender.setFile("ChromeLogfile.txt");
		fileAppender.setLayout(new SimpleLayout());

		OurLogger.addAppender(fileAppender);
		fileAppender.activateOptions();

		// Selenium
		File file = new File("C:\\Driver\\iedriver.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		WebDriver driver = new InternetExplorerDriver();
		driver.get(google);
		driver.navigate().to(google);
		System.out.println("Navigated to " + google);
		// Selenium actions
		/*
		driver.navigate().to(google);
		driver.findElement(By.name("q")).sendKeys("Spring");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);*/
/*
		List<WebElement> results = driver.findElements(By.tagName("h3"));

		for (int i = 0; i < results.size(); i++) {
			System.out.println("Found: " + results.get(i).getText());
			OurLogger.info(date + " Registered: " + i + ". Found:" + results.get(i).getText());
		}*/

	}
	
		public WebDriver driver;
		
		@BeforeClass
		public void setUp() {
			System.out.println("*******************");
			System.out.println("launching IE browser");
			System.setProperty("webdriver.ie.driver", "C:\\Driver\\iedriver.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		
		@Test
		public void testGooglePageTitleInIEBrowser() {
			driver.navigate().to("http://www.google.com");
			String strPageTitle = driver.getTitle();
			System.out.println("Page title: - "+strPageTitle);
			Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
		}

		@AfterClass
		public void tearDown() {
			if(driver!=null) {
				System.out.println("Closing IE browser");
				driver.quit();
			}
		
	}

}
