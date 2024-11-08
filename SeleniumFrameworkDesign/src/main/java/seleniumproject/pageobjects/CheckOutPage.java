package seleniumproject.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumproject.AbstractComponents.AbstractComponenst;

public class CheckOutPage extends AbstractComponenst {
	WebDriver driver;
	String countryName = "india";
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement clickonCountry;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;
	
	By waittillby =By.cssSelector(".ta-results");
	
	public ConfirmationPage SelectCountryPlaceOrder() {
		  Actions a = new Actions(driver);
		  a.sendKeys(clickonCountry,countryName).build().perform();
		  WaitForElementToAppear(waittillby);
		  selectCountry.click();
		  a.moveToElement(placeOrder).click().build().perform();
		  ConfirmationPage confirmationpage = new ConfirmationPage(driver);
		  return confirmationpage;
	}	   
}
