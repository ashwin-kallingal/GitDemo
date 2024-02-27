package ashwinkallingal.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import ashwinkallingal.PageObjects.CartPage;
import ashwinkallingal.PageObjects.CheckOutPage;
import ashwinkallingal.PageObjects.ConfirmationPage;
import ashwinkallingal.PageObjects.LoginPage;
import ashwinkallingal.PageObjects.ProductCataloguePage;
import ashwinkallingal.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidationTest extends BaseTest{
	
	
	@Test (groups="ErrorHandling")
	public void loginError() throws IOException {
		
		loginPage.login("ashwin222@gmail.com", "Passw0rd&");
		String errorMessage = loginPage.getErrorMessage();
		Assert.assertEquals(errorMessage, "Incorrect email or password.");		
	}
}
