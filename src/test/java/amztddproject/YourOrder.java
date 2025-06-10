package amztddproject;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class YourOrder {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
    }

    @Test(priority = 1)
    
    public void loginAndNavigateToOrdersPage() 
    {
    	driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&prevRID=09RRGJSRW5AT8ZSCVP2A&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        driver.findElement(By.id("ap_email")).sendKeys("email");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("password");
        driver.findElement(By.id("signInSubmit")).click();
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList > a > div"))).build().perform();
        driver.findElement(By.id("nav_prefetch_yourorders")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/order-history"), "Order history page not loaded");
    }

    @Test(priority = 2, dependsOnMethods = "loginAndNavigateToOrdersPage")
    public void verifyBuyAgainRecommendations() throws InterruptedException {
    	boolean a = driver.findElement(By.linkText("Buy Again")).isDisplayed();
        Thread.sleep(2000);
        Assert.assertTrue(a);

        boolean b = driver.findElement(By.linkText("Not Yet Shipped")).isDisplayed();
        Assert.assertTrue(b);

        boolean c = driver.findElement(By.xpath("//span[text()='Your Orders']")).isDisplayed();
        Assert.assertTrue(c);

        System.out.println("Buy Again visible: " + a);
        System.out.println("Not Yet Shipped visible: " + b);
        System.out.println("Your Orders selected: " + c);
    }
    

    @Test(priority = 3, dependsOnMethods = "loginAndNavigateToOrdersPage")
    public void verifyNotYetShippedOrders() {
    	 WebElement buyAgain = driver.findElement(By.linkText("Buy Again"));
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buyAgain);

         WebElement notYetShippedTab = wait.until(ExpectedConditions.elementToBeClickable(
                 By.linkText("Not Yet Shipped")));
         notYetShippedTab.click();
    }

    @Test(priority = 4, dependsOnMethods = "loginAndNavigateToOrdersPage")
    public void verifyCancelledOrders() {
    	 WebElement cancelledOrders = driver.findElement(By.linkText("Cancelled Orders"));
         cancelledOrders.click();

         boolean isDisplayed = driver.getPageSource().contains("Cancelled Orders")
                 || cancelledOrders.isDisplayed();
         Assert.assertTrue(isDisplayed, "Cancelled Orders are not displayed");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}