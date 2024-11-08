package seleniumproject.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumproject.AbstractComponents.AbstractComponenst;

public class OrederPage extends AbstractComponenst {
	WebDriver driver;
	
	public OrederPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="tr td:nth-of-type(2)")
	List<WebElement> orderProducts ;
	
	public Boolean VerifyOrderDisplay(String productName) {
		 Boolean matchCheck = orderProducts.stream().anyMatch(orderProduct->
		 orderProduct.getText().equalsIgnoreCase(productName));
		 return matchCheck;
	}
	
	
	
	
	
	   
}
