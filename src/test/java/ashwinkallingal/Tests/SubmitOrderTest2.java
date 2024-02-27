package ashwinkallingal.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ashwinkallingal.PageObjects.CartPage;
import ashwinkallingal.PageObjects.CheckOutPage;
import ashwinkallingal.PageObjects.ConfirmationPage;
import ashwinkallingal.PageObjects.LoginPage;
import ashwinkallingal.PageObjects.OrdersPage;
import ashwinkallingal.PageObjects.ProductCataloguePage;
import ashwinkallingal.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest2 extends BaseTest{
	
	@Test
	public void ProductErrorValidation() throws IOException {
		
		String productName = "ZARA COAT 3";
		String country = "ind";
		
		//launchApplication();		
		ProductCataloguePage catalog = loginPage.login("ashwin333@gmail.com", "Passw0rd&");		
		List<WebElement> prodList = catalog.getProductList();
		WebElement proName = catalog.getProductByName(productName);
		catalog.addProductToCart(productName);
		CartPage cart = catalog.goToCartPage();		
		boolean match = cart.verifyProductInCart("ZARA COAT 3"); 
		Assert.assertTrue(match);		
	}	
}
