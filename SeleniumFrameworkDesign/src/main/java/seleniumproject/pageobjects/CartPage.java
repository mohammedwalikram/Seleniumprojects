package seleniumproject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumproject.AbstractComponents.AbstractComponenst;

public class CartPage extends AbstractComponenst {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts ;
	
	@FindBy(css=".subtotal button")
	WebElement checkoutButton ;
	
	public Boolean VerifyProductDisplay(String productName) {
		 Boolean matchCheck = cartProducts.stream().anyMatch(cartProduct->
		 cartProduct.getText().equalsIgnoreCase(productName));
		 return matchCheck;
	}
	
	public CheckOutPage GoToCheckout() {
		checkoutButton.click();
	    CheckOutPage checkoutpage = new CheckOutPage(driver);
		return checkoutpage;
	}

	
	
	
	
	
	   
}
