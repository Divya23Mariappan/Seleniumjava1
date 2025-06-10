package amztddproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.configReader;

public class AmzTestng {

	  WebDriver driver;
	    configReader config = new configReader();
	    String email = config.getEmail();
	    String password = config.getPassword();
	    

	    @BeforeMethod
	    public void setUp() {
	    	System.setProperty("webdriver.chrome.driver","chromedriver.exe");
			driver=new ChromeDriver();
			
	    }

	    @Test(priority = 1)
	    public void testAlreadyexistingsigninAccountNavigation() {
	    	driver.get("https://www.amazon.ca/ap/register?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
	     
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Sign in"))).click();
	        boolean a =driver.findElement(By.cssSelector("#authportal-main-section > div:nth-child(2) > div.a-section.a-spacing-base > div.a-section > form > div > div > div > h1")).isDisplayed();
		    Assert.assertEquals(true, a);
		    System.out.println(a);

	    }

	    @Test(priority = 2)
	    public void testInvalidEmail() {
	    	driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&prevRID=09RRGJSRW5AT8ZSCVP2A&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email"))).sendKeys("Divy");
	        driver.findElement(By.id("continue")).click();

	      
	        boolean errorDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("auth-email-invalid-claim-alert"))).isDisplayed();
	        Assert.assertTrue(errorDisplayed, "Invalid email error message is not displayed");
	    }

	    @Test(priority = 3)
	    public void testValidEmail() {
	        driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&prevRID=09RRGJSRW5AT8ZSCVP2A&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email"))).sendKeys("divya.spicerz@gmail.com");
	        driver.findElement(By.id("continue")).click();

	     
	        boolean passwordFieldVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password"))).isDisplayed();
	        Assert.assertTrue(passwordFieldVisible, "Password field is not visible after entering valid email");
	    }

	    @Test(priority = 4)
	    public void testInvalidPassword() {
	        driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&prevRID=W08N0837HTSEVWC4A8PY&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email"))).sendKeys("divya.spicerz@gmail.com");
	        driver.findElement(By.id("continue")).click();

	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password"))).sendKeys("wrongPassword");
	        driver.findElement(By.id("signInSubmit")).click();

	       
	        boolean errorDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.a-alert-content"))).isDisplayed();
	        Assert.assertTrue(errorDisplayed, "Error message is not displayed for invalid password");
	    }

	    @Test(priority = 5)
	    public void testValidLoginWithCheckbox() {
	        driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&prevRID=W08N0837HTSEVWC4A8PY&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email"))).sendKeys("divya.spicerz@gmail.com");
	        driver.findElement(By.id("continue")).click();

	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password"))).sendKeys("Saravdiv@230990");
	        driver.findElement(By.id("signInSubmit")).click();

	      
	        wait.until(ExpectedConditions.elementToBeClickable(By.name("rememberMe"))).click();

	       
	        boolean accountMenuVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList"))).isDisplayed();
	        Assert.assertTrue(accountMenuVisible, "User is not logged in successfully");
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
	
	

