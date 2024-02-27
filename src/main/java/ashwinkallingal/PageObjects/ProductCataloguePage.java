package ashwinkallingal.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ashwinkallingal.AbstractComponent.AbstractComponents;

public class ProductCataloguePage extends AbstractComponents{
	
WebDriver driver;	
	
	public ProductCataloguePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css=".mb-3")
	List<WebElement> products;
	
	@FindBy (css=".ng-animating")
	WebElement spinner;
	
	
	By productBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");	
	By toasterMessage = By.cssSelector("#toast-container");	
		
    public List<WebElement> getProductList() {		
		waitForElementToAppear(productBy);		
		return products;		
	}
		
    public WebElement getProductByName(String productName) {
		WebElement prod = getProductList().stream().
		filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);		
		return prod;
	}	
	
    public void addProductToCart(String product) {
    	getProductByName(product).findElement(addToCart).click();
		waitForElementToAppear(toasterMessage);
		waitForElementToDisapper(spinner);
	}
    
   
    
    
	
	
	
	
	
	
	
	
	

		
	
	
	
	
	
	
	
	
	

}
