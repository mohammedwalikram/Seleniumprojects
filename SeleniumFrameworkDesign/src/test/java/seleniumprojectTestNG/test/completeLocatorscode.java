package seleniumprojectTestNG.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumproject.pageobjects.LandingPage;

public class completeLocatorscode {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
	        String productName = "ZARA COAT 3";
			WebDriverManager.chromedriver().setup();
			WebDriver driver =new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://rahulshettyacademy.com/client/"); 
			driver.findElement(By.id("userEmail")).sendKeys("vipigo8970@acroins.com");
			driver.findElement(By.id("userPassword")).sendKeys("mohammedZain@33");
			driver.findElement(By.id("login")).click();
		     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			 
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		    List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	        WebElement needProduct=products.stream().filter(product->
	        product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	        needProduct.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	        driver.findElement(By.xpath("//button[contains(@routerlink,'cart')]")).click();
	        
	       List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
	       Boolean matchCheck = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
	       Assert.assertTrue(matchCheck);
	       driver.findElement(By.cssSelector(".subtotal button")).click();
	       
	       Actions a = new Actions(driver);
		   a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "india").build().perform();
		   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		   
		   driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		   a.moveToElement(driver.findElement(By.cssSelector(".action__submit"))).click().build().perform();
		   
		  String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		  Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		  driver.close();
		}
		
}
