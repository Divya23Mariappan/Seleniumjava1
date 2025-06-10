package amztddproject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class Yourpayment {

	WebDriver driver;
    WebDriverWait wait;

    String email = "divya.spicerz@gmail.com";  
    String password = "Saravdiv@230990";        

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&prevRID=09RRGJSRW5AT8ZSCVP2A&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        driver.findElement(By.id("ap_email")).sendKeys("divya.spicerz@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("Saravdiv@230990");
        driver.findElement(By.id("signInSubmit")).click();

        wait.until(ExpectedConditions.urlContains("amazon.ca"));
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon.ca"),
            "Login failed or did not redirect to Amazon home page.");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void testMouseHoverOnHelloSignIn() {
        Actions actions = new Actions(driver);
        WebElement hoverElement = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList-nav-line-1")));
        actions.moveToElement(hoverElement).perform();

        WebElement yourAccountLink = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Your Account']")));
        Assert.assertTrue(yourAccountLink.isDisplayed(), "'Your Account' should be visible after hover.");
    }

    @Test(priority = 2, dependsOnMethods = "testMouseHoverOnHelloSignIn")
    public void testClickYourAccount() {
        WebElement yourAccount = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[text()='Your Account']")));
        yourAccount.click();

        wait.until(ExpectedConditions.titleContains("Your Account"));
        Assert.assertTrue(driver.getTitle().contains("Your Account"), "Did not navigate to 'Your Account' page.");
    }

    @Test(priority = 3, dependsOnMethods = "testClickYourAccount")
    public void testClickYourPayments() {
        WebElement yourPaymentsLink = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//*[@id=\"a-page\"]/div[1]/div/ul[2]/li[3]/span/span/a/div/div/div/div[2]/div/span")));
        yourPaymentsLink.click();

        wait.until(ExpectedConditions.urlContains("yourpayments/wallet"));
        Assert.assertTrue(driver.getCurrentUrl().contains("yourpayments/wallet"),
            "Should navigate to Your Payments wallet page");
    }

    @Test(priority = 4, dependsOnMethods = "testClickYourPayments")
  
    	public void testAddPaymentMethodVisible() {
    	    driver.findElement(By.xpath("//*[@id=\"pp-k9xxSx-14-announce\"]")).click();
    	}
        


    @Test(priority = 5, dependsOnMethods = "testAddPaymentMethodVisible")
    public void testAddNewCardDetails() {
        WebElement cardNumberField = driver.findElement(By.name("addCreditCardNumber"));
        cardNumberField.sendKeys("5123456789012346");

        WebElement expiryField = driver.findElement(By.name("expirationDate"));
        expiryField.sendKeys("05/34");

        WebElement cvvField = driver.findElement(By.name("cvv"));
        cvvField.sendKeys("100");

        WebElement nameField = driver.findElement(By.name("nameOnCard"));
        nameField.sendKeys("Mastercard");

        WebElement addContinueBtn = wait.until(ExpectedConditions.elementToBeClickable(
            By.partialLinkText("Add and continue")));
        addContinueBtn.click();

        wait.until(ExpectedConditions.urlContains("yourpayments"));
        Assert.assertTrue(driver.getCurrentUrl().contains("yourpayments"),
            "After adding card, user should remain on payments page or see confirmation");
    }
}