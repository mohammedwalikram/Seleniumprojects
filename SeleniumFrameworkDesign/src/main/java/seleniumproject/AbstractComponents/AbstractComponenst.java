package seleniumproject.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumproject.pageobjects.CartPage;
import seleniumproject.pageobjects.OrederPage;

public class AbstractComponenst {
	WebDriver driver;
	
	public AbstractComponenst(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//cartButton is common so that's why this is here
	@FindBy(xpath="//button[contains(@routerlink,'cart')]")
	WebElement cartHeader;	 
	
	@FindBy(xpath="//button[contains(@routerlink,'myorders')]")
	WebElement OrderHeader;	 	
	
	
	public CartPage goToCartPage() 
	{
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrederPage goToOrderPage() {
		OrderHeader.click();
		OrederPage orderpage = new OrederPage (driver);
		return orderpage;
	}

	public void WaitForElementToAppear(By FindBy) {
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	public void WaitForWebElementToAppear(WebElement FindBy) {
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		 wait.until(ExpectedConditions.visibilityOf(FindBy));
	}
    public void WaitForElementToDisapper() throws InterruptedException
    {
    	Thread.sleep(1000);
    }
	
	
	
	
	
	
	   
}
