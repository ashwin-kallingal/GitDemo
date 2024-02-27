package ashwinkallingal.StepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import ashwinkallingal.PageObjects.CartPage;
import ashwinkallingal.PageObjects.CheckOutPage;
import ashwinkallingal.PageObjects.ConfirmationPage;
import ashwinkallingal.PageObjects.LoginPage;
import ashwinkallingal.PageObjects.ProductCataloguePage;
import ashwinkallingal.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest{
	public LoginPage loginPage;
	public ProductCataloguePage catalog;
	public CartPage cart;
	public CheckOutPage check;
	public ConfirmationPage confirm;

	@Given ("I landed on Ecommerce page")
	public void i_landed_on_Ecommerce_page() throws IOException {
		loginPage = launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void login_with_UserName_And_Password(String email, String password) {
		catalog = loginPage.login(email, password);	
	}	
	
	@When("^I add product (.+) to Cart$")
	public void i_added_product_to_cart(String productName) {
		List<WebElement> prodList = catalog.getProductList();
		WebElement proName = catalog.getProductByName(productName);
		catalog.addProductToCart(productName);
		cart = catalog.goToCartPage();		
		boolean match = cart.verifyProductInCart(productName); 
		Assert.assertTrue(match);
		check = cart.clickCheckOutButton();
		check.selectCountry("ind");
		confirm = check.clickPlaceOrder();
	}

	@Then("I verify the {string} message is displayed in Confirmation page.")
	public void i_verify_the_message_is_displayed_in_confirmation_page(String string) {

		String confirmMessage = confirm.getConfirmationMessage();
		Assert.assertEquals(confirmMessage, string);
		driver.close();
	}
		
	@Then("I verify the {string} message is displayed in Login page.")
	public void i_verify_the_message_is_displayed_in_login_page(String string) {		
		String errorMessage = loginPage.getErrorMessage();
		Assert.assertEquals(errorMessage, string);
		driver.close();
	}
	
	
}