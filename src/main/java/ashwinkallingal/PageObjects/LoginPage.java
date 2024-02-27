package ashwinkallingal.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ashwinkallingal.AbstractComponent.AbstractComponents;

public class LoginPage extends AbstractComponents{
	
	WebDriver driver;	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="userEmail")
	WebElement username;
	
	@FindBy (id="userPassword")
	WebElement password;
	
	@FindBy (id="login")
	WebElement lgnButton;	
	
	@FindBy (css="[class*='flyInOut']")
	WebElement loginErrorMessage;
	
	
	public ProductCataloguePage login(String userName, String passWord) {
		username.sendKeys(userName);
		password.sendKeys(passWord);
		lgnButton.click();
		ProductCataloguePage pc = new ProductCataloguePage(driver);
		return pc;		
	}
	
	public String getErrorMessage() {
		waitForWebElementToAppear(loginErrorMessage);
		return loginErrorMessage.getText();
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
}
