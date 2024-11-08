package seleniumprojectcucum.stepDefinitions;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import seleniumproject.TestComponents.BaseTest;
import seleniumproject.pageobjects.CartPage;
import seleniumproject.pageobjects.CheckOutPage;
import seleniumproject.pageobjects.ConfirmationPage;
import seleniumproject.pageobjects.LandingPage;
import seleniumproject.pageobjects.ProductCatalogue;

public class StepDefinitionsImplementations extends BaseTest {
    public LandingPage landingPage;
    public ProductCatalogue productcatalogue;
    public ConfirmationPage confirmationpage;

    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page() throws IOException {
        landingPage = launchApplication();
    }

    @Given("^Logged in with useremail (.+) and password (.+)$")
    public void Logged_in_withuseremail_and_password(String email, String password) {
        productcatalogue = landingPage.loginApplication(email, password);
    }

    @When("^I add product (.+) to Cart$")
    public void I_add_product_to_Cart(String product) throws InterruptedException {
        List<WebElement> Products = productcatalogue.getProductList();
        productcatalogue.addProductToCart(product);
    }

    @And("^Checkout (.+) and submit the order$")
    public void Checkout_and_submit_the_order(String product) {
        CartPage cartPage = productcatalogue.goToCartPage();
        Boolean matchCheck = cartPage.VerifyProductDisplay(product);
        Assert.assertTrue(matchCheck);
        CheckOutPage checkoutpage = cartPage.GoToCheckout();
        confirmationpage = checkoutpage.SelectCountryPlaceOrder();
    }

    @Then("{string} message is displayed on confirmationPage")
    public void message_displayed_confirmationpage(String string) {
        String confirmMessage = confirmationpage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
        driver.close();
    }
    
    @Then("{string} error message is displayed")
    public void error_message_is_displayed(String string) {
    	Assert.assertEquals( "Incorrect email or password.", landingPage.getErrorMessage());
    }
}
