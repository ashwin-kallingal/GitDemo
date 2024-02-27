package ashwinkallingal.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class StandAloneTest {
	
	public static void main(String[] args) {
		String productName = "ZARA COAT 3";
		
		WebDriverManager.chromedriver().setup();	
		WebDriver driver = new ChromeDriver();
			
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		
	}
}
