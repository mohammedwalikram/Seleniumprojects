package seleniumprojectTestNG.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import seleniumproject.TestComponents.BaseTest;
import seleniumproject.pageobjects.CartPage;
import seleniumproject.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

     @Test(groups = {"ErrorHandling"})
      public void ErrorMsg() throws IOException, InterruptedException
      {
    	String productName = "ZARA COAT 3";
	    landingPage.loginApplication("vipigo8970@acroins.com", "mohammedZain@123");
		Assert.assertEquals( "Incorrect email or password.", landingPage.getErrorMessage());
	  }
      
      @Test
      public void ProductErrorValidation() throws IOException, InterruptedException
      {
		
        String productName = "ZARA COAT 3";
		ProductCatalogue productcatalogue = landingPage.loginApplication("nahosog702@anypng.com", "Mohammedzain@33");
		List<WebElement> Products = productcatalogue.getProductList();
		productcatalogue.addProductToCart(productName);
		CartPage cartPage = productcatalogue.goToCartPage();
        Boolean matchCheck=cartPage.VerifyProductDisplay("ZARA COAT 33");
        Assert.assertFalse(matchCheck);
      }
}