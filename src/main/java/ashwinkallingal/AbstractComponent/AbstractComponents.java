package ashwinkallingal.AbstractComponent;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ashwinkallingal.PageObjects.CartPage;
import ashwinkallingal.PageObjects.OrdersPage;

public class AbstractComponents {
	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy (xpath="//button[contains(@routerlink, 'cart')]")
	WebElement cart;	
	
	@FindBy (xpath="//button[contains(@routerlink, 'myorders')]")
	WebElement orders;	
	
	public void waitForElementToAppear(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated((findBy)));
	}
	
        public void waitForWebElementToAppear(WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
     public void waitForElementToDisapper(WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
     
     public CartPage goToCartPage() {
    	 cart.click();
    	 CartPage cp = new CartPage(driver);
  		 return cp;
    	 
     }
     
     public OrdersPage goToOrderPage() {
    	 orders.click();
    	 OrdersPage op = new OrdersPage(driver);
  		 return op;
    	 
     }
}