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

public class SubmitOrderTest extends BaseTest{
	
	
	@Test(dataProvider= "getData1", groups="Purchase")
	public void submitOrder(String email, String password, String productName) throws IOException {		
		String country = "ind";		
		//launchApplication();		
		ProductCataloguePage catalog = loginPage.login(email, password);		
		List<WebElement> prodList = catalog.getProductList();
		WebElement proName = catalog.getProductByName(productName);
		catalog.addProductToCart(productName);
		CartPage cart = catalog.goToCartPage();		
		boolean match = cart.verifyProductInCart(productName); 
		Assert.assertTrue(match);
		CheckOutPage check = cart.clickCheckOutButton();
		check.selectCountry(country);
		ConfirmationPage confirm = check.clickPlaceOrder();		
		String confirmMessage = confirm.getConfirmationMessage();
		Assert.assertEquals(confirmMessage, "THANKYOU FOR THE ORDER.");
	}
	
	
	/*@Test(dataProvider= "getData3", groups="Purchase")
	public void submitOrder1(HashMap<String, String> input) throws IOException {
		
		String country = "ind";		
		//launchApplication();		
		ProductCataloguePage catalog = loginPage.login(input.get("email"), input.get("password"));		
		List<WebElement> prodList = catalog.getProductList();
		WebElement proName = catalog.getProductByName(input.get("product"));
		catalog.addProductToCart(input.get("product"));
		CartPage cart = catalog.goToCartPage();		
		boolean match = cart.verifyProductInCart(input.get("product")); 
		Assert.assertTrue(match);
		CheckOutPage check = cart.clickCheckOutButton();
		check.selectCountry(country);
		ConfirmationPage confirm = check.clickPlaceOrder();		
		String confirmMessage = confirm.getConfirmationMessage();
		Assert.assertEquals(confirmMessage, "THANKYOU FOR THE ORDER.");
	}*/	
	
	/*@Test
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
	}*/
	
	
	/*@Test (dependsOnMethods = {"submitOrder"})
	public void verifyOrder() throws IOException {
		
    	ProductCataloguePage catalog = loginPage.login("ashwin111@gmail.com", "Passw0rd&");	
    	OrdersPage orders = catalog.goToOrderPage();		
    	boolean match = orders.verifyOrderName("ZARA COAT 3"); 
		Assert.assertTrue(match);    		
	}*/	
	
	@DataProvider
	public Object[][] getData1() {
		
		return new Object[][] {/*{"ashwin111@gmail.com", "Passw0rd&", "ZARA COAT 3"},*/ {"ashwin333@gmail.com", "Passw0rd&", "ADIDAS ORIGINAL"}};
		
	}	
	
	/*@DataProvider
	public Object[][] getData2() {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "ashwin111@gmail.com");
		map.put("password", "Passw0rd&");
		map.put("product", "ZARA COAT 3");
		
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "ashwin333@gmail.com");
		map1.put("password", "Passw0rd&");
		map1.put("product", "ADIDAS ORIGINAL");		
		
		return new Object[][] {{map}, {map1}};		
	}
	
	
	@DataProvider
	public Object[][] getData3() throws IOException {
		
		List<HashMap<String, String>> data=getJsonDataToHashMap("//src//test//java//ashwinkallingal.data//PurchaseOrder.json");		
		return new Object[][] {{data.get(0)}, {data.get(1)}};
		
	}	*/
}
