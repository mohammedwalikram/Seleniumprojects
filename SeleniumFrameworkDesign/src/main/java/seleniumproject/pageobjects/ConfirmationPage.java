package seleniumproject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import seleniumproject.AbstractComponents.AbstractComponenst;

public class ConfirmationPage  extends AbstractComponenst {
   
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmMsg;	
	
    public String getConfirmationMessage() {
    	   return confirmMsg.getText();
    }
}
