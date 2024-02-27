package ashwinkallingal.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ashwinkallingal.AbstractComponent.AbstractComponents;

	public class ConfirmationPage extends AbstractComponents{
		
	    WebDriver driver;	
	    
	    @FindBy (css=".hero-primary")
		WebElement confirmationMessage;
		
	    
	    public ConfirmationPage(WebDriver driver) {
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	    
	    public String getConfirmationMessage() {
	    	return confirmationMessage.getText();
	    }
}
