package amztddproject;

import java.time.Duration;
import java.util.Set;

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

public class YourAddress
{
	WebDriver driver;
    WebDriverWait wait;
    configReader config;
    String email;
    String password;

    @BeforeMethod
    public void setUp() throws InterruptedException {
    	  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
          driver = new ChromeDriver();
          driver.manage().window().maximize();
          wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&prevRID=09RRGJSRW5AT8ZSCVP2A&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        driver.findElement(By.id("ap_email")).sendKeys("email");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("password");
        driver.findElement(By.id("signInSubmit")).click();
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList > a > div"))).build().perform();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority=1)
    public void testUserOnYourAccountPage() throws InterruptedException {
        
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList > a > div"))).build().perform();
        Thread.sleep(2000);

        WebElement yourAccountOption = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#nav-al-your-account > ul > li:nth-child(4) > a")));
        yourAccountOption.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("gp/css/homepage"), "User should land on Your Account homepage");
    }

    @Test(priority=2, dependsOnMethods = "testUserOnYourAccountPage")
    public void testAddressLinkVisibleAndClickable() {
       
        WebElement addressLink = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Address")));
        addressLink.click();

        WebElement addAddressBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ya-myab-plus-address-icon")));
        Assert.assertTrue(addAddressBtn.isDisplayed(), "Add Address icon should be displayed");
    }

    @Test(priority=3, dependsOnMethods = "testAddressLinkVisibleAndClickable")
    public void testAddAddressOpensNewWindow() throws InterruptedException {
        WebElement addAddressBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("ya-myab-plus-address-icon")));
        addAddressBtn.click();

        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

       
        for (String window : allWindows) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("address"), "Add address page should open in new window");

        driver.close();
        driver.switchTo().window(currentWindow);
    }

    @Test(priority=4)
    public void testCountryAutoSelected() {
        
        driver.get("https://www.amazon.ca/a/addresses/add?ref=ya_address_book_add_button");
        WebElement countryDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address-ui-widgets-countryCode-dropdown-nativeId")));
        String selectedCountry = countryDropdown.getAttribute("value");
        Assert.assertEquals(selectedCountry, "CA", "Country should be auto-selected as Canada");
    }

    @Test(priority=5)
    public void testFullNameFieldNotEmpty() {
        driver.get("https://www.amazon.ca/a/addresses/add?ref=ya_address_book_add_button");
        WebElement fullNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address-ui-widgets-enterAddressFullName")));
        String fullName = fullNameField.getAttribute("value").trim();
        Assert.assertFalse(fullName.isEmpty(), "Full Name field should not be empty");
    }

    @Test(priority=6)
    public void testPhoneNumberLength() {
        driver.get("https://www.amazon.ca/a/addresses/add?ref=ya_address_book_add_button");
        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address-ui-widgets-enterAddressPhoneNumber")));
        String phone = phoneField.getAttribute("value").replaceAll("\\D", "");
        Assert.assertEquals(phone.length(), 10, "Phone number should be 10 digits");
    }

}
