package seleniumproject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import seleniumproject.AbstractComponents.AbstractComponenst;

public class ProductCatalogue extends AbstractComponenst {
	WebDriver driver;
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	List<WebElement> spinner;
	
	By ProductBy = By.cssSelector(".mb-3");
    By addtocart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");

    
	public List<WebElement> getProductList() 
	{
		WaitForElementToAppear(ProductBy);
		return products;		
	}
	 
	public WebElement getProductsByName(String productName) 
	{
        WebElement neededProduct= getProductList().stream().filter(product->
        product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        return neededProduct;
	}
   public void addProductToCart(String productName) throws InterruptedException
   {
	   WebElement neededProduct = getProductsByName(productName);
	   neededProduct.findElement(addtocart).click();
	   WaitForElementToAppear(toastMessage);
	   WaitForElementToDisapper();
	  
   }
	

}
