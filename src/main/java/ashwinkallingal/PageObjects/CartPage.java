package ashwinkallingal.PageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ashwinkallingal.AbstractComponent.AbstractComponents;

public class CartPage extends AbstractComponents{
	
    WebDriver driver;	
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="userEmail")
	WebElement username;
	
	@FindBy (css=".cartSection h3")
	List<WebElement> cartSection;
	
	@FindBy (xpath="(//*[@class='btn btn-primary'])[3]")
	WebElement clickCheckOut;	
	
		
	public boolean verifyProductInCart(String productName) {
		 boolean match = cartSection.stream().anyMatch(cartProducts->cartProducts.getText().equalsIgnoreCase(productName));
		 return match;
	}
	
	public CheckOutPage clickCheckOutButton() {
		clickCheckOut.click();
		CheckOutPage cp = new CheckOutPage(driver);
		return cp;		
	}
}
