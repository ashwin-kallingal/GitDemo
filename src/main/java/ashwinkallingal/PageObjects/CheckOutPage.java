package ashwinkallingal.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ashwinkallingal.AbstractComponent.AbstractComponents;

	public class CheckOutPage extends AbstractComponents{
		
	    WebDriver driver;	
	    
		@FindBy (css="[placeholder='Select Country']")
		WebElement selectCountry;
		
		@FindBy (xpath="(//button[contains(@class, 'ta-item')])[2]")
		WebElement selectIndia;
		
		@FindBy (css=".btnn")
		WebElement placeOrderBtn;
		
		By countryList = By.cssSelector(".ta-results");
		
		public CheckOutPage(WebDriver driver) {
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		
		public void selectCountry(String country) {
			selectCountry.sendKeys(country);
			waitForElementToAppear(countryList);
			selectIndia.click();
		}
		
		public ConfirmationPage clickPlaceOrder() {
			placeOrderBtn.click();
			ConfirmationPage cf = new ConfirmationPage(driver);
			return cf;
			
		}
		

}
