package amztddproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.configReader;

public class YourAccount {
	  WebDriver driver;
	    WebDriverWait wait;
	    configReader config = new configReader();
		String email = config.getEmail();
		String password = config.getPassword();

	    @BeforeMethod
	    public void setUp() throws InterruptedException {
	    	
			System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			driver=new ChromeDriver();

	    }

	    @Test
	    public void testYourAccountHoverFunctionality() throws InterruptedException {
	    	driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&prevRID=09RRGJSRW5AT8ZSCVP2A&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
	        driver.findElement(By.id("ap_email")).sendKeys("divya.spicerz@gmail.com");
	        driver.findElement(By.id("continue")).click();
	        driver.findElement(By.id("ap_password")).sendKeys("Saravdiv@230990");
	        driver.findElement(By.id("signInSubmit")).click();
	        Actions action=new Actions(driver);
	        action.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList > a > div"))).build().perform();
	        driver.findElement(By.id("nav_prefetch_yourorders")).click();

	       
	        WebElement yourOrders = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Your Orders']")));
	        WebElement yourAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Your Account']")));

	        Assert.assertTrue(yourOrders.isDisplayed(), "'Your Orders' not displayed in sublist.");
	        Assert.assertTrue(yourAccount.isDisplayed(), "'Your Account' not displayed in sublist.");

	        System.out.println("✅ Mouse hover successful and sublist options are visible.");
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
