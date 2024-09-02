package basicweb;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestClass {
	
	private WebDriver driver;

	@BeforeTest
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		//Use Chrome Driver
		driver = new ChromeDriver();
		//Maximize the Window
		driver.manage().window().maximize();
		// Timeout check
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

				
	}
	
	@Test
	public void testAmazonPage() {
		//Open the Amazon URL
		driver.get("https://www.amazon.in");
		String Title = driver.getTitle();
		System.out.println(Title);
		assertEquals("Amazon.in", Title);
		
		// Print the message
		System.out.println("Browser Opened and validated the Title-Added");
		
		
	}
	
	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	
		

}


