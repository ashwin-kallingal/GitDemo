package ashwinkallingal.PageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ashwinkallingal.AbstractComponent.AbstractComponents;

public class OrdersPage extends AbstractComponents{
	
    WebDriver driver;
    
    @FindBy (css="tr td:nth-child(3)")
    List<WebElement> ordersList;
	
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyOrderName(String productName) {
		
		boolean match = ordersList.stream().anyMatch(orders->orders.getText().equalsIgnoreCase(productName));
		return match;
		
	}	
}
