package seleniumprojectTestNG.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumproject.TestComponents.BaseTest;
import seleniumproject.pageobjects.CartPage;
import seleniumproject.pageobjects.CheckOutPage;
import seleniumproject.pageobjects.ConfirmationPage;
import seleniumproject.pageobjects.LandingPage;
import seleniumproject.pageobjects.OrederPage;
import seleniumproject.pageobjects.ProductCatalogue;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StandAloneTest extends BaseTest {
	  String productName = "ZARA COAT 3";
      @Test (dataProvider="getdata",groups= {"Purchase"})
      public void SubmitOrder(HashMap<String,String> input) throws IOException, InterruptedException
      {
		ProductCatalogue productcatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));	
		List<WebElement> Products = productcatalogue.getProductList();
		productcatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productcatalogue.goToCartPage();
		
        Boolean matchCheck=cartPage.VerifyProductDisplay(input.get("product"));
        Assert.assertTrue(matchCheck);
        CheckOutPage checkoutpage =  cartPage.GoToCheckout();
        ConfirmationPage confirmationpage= checkoutpage.SelectCountryPlaceOrder();
        
        String confirmMessage = confirmationpage.getConfirmationMessage();
	    Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
	}
      
     @Test(dependsOnMethods= {"SubmitOrder"}) 
     public void OrderHistoryTest() {
    	 ProductCatalogue productcatalogue = landingPage.loginApplication("vipigo8970@acroins.com", "mohammedZain@33");
    	 OrederPage orderpage = productcatalogue.goToOrderPage();
    	 Assert.assertTrue(orderpage.VerifyOrderDisplay(productName));
     }
     
     @DataProvider
     public Object[][] getdata() 
     {
    	 HashMap<String,String> map = new HashMap<String,String>();
    	 map.put("email", "vipigo8970@acroins.com");
    	 map.put("password", "mohammedZain@33");
    	 map.put("product", "ZARA COAT 3");
    	 
    	 HashMap<String,String> map1 = new HashMap<String,String>();
    	 map1.put("email", "nahosog702@anypng.com");
    	 map1.put("password", "Mohammedzain@33");
    	 map1.put("product", "ADIDAS ORIGINAL");	 
    	 
    	 return new Object[][] { {map} , {map1}};
    	 
     }
     
     
	
}
