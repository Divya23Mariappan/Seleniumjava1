package Stepdef;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.configReader;

public class Yourpayment {
	WebDriver driver;
	
	@Given("User must be in the Amazon home page")
	
	public void user_must_be_in_the_amazon_home_page() throws InterruptedException {
		configReader config = new configReader();
		String email = config.getEmail();
		String password = config.getPassword();
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&prevRID=09RRGJSRW5AT8ZSCVP2A&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.findElement(By.id("ap_email")).sendKeys(email);
		 driver.findElement(By.cssSelector("#continue")).click();
		 driver.findElement(By.id("ap_password")).sendKeys(password);
		 driver.findElement(By.cssSelector("#signInSubmit")).click(); Thread.sleep(2000);
		 new WebDriverWait(driver, Duration.ofSeconds(10))
			.until(ExpectedConditions.urlContains("amazon.ca"));
	}

	@Given("mouse hover on hello sign in")
	public void mouse_hover_on_hello_sign_in() throws InterruptedException {
		 Actions actions = new Actions(driver);
		    WebElement hoverElement = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList-nav-line-1")));
		    actions.moveToElement(hoverElement).perform();Thread.sleep(2000);
		    new WebDriverWait(driver, Duration.ofSeconds(5))
		        .until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList-nav-line-1")));
	
	}

	@Given("click your account")
	public void click_your_account() throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-al-your-account")));
		    WebElement accountOption = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Your Account")));
		    accountOption.click();
		
	}

	@When("in the Your account page user should click your payments")
	public void in_the_your_account_page_user_should_click_your_payments() throws TimeoutException {
		driver.findElement(By.xpath("//*[@id=\"a-page\"]/div[1]/div/ul[2]/li[3]/span/span/a/div/div/div/div[2]/div/span")).click();
	}

	@Then("cx must be able to add payment method by clicking on add payment method")
	public void cx_must_be_able_to_add_payment_method_by_clicking_on_add_payment_method() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("yourpayments/wallet"));
		Assert.assertTrue(driver.getCurrentUrl().contains("yourpayments/wallet"));
		WebElement addPaymentBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Add a payment method') or contains(text(),'Add a credit or debit card')]")));
		Assert.assertTrue(addPaymentBtn.isDisplayed());
}

@Then("cx must be able to add his new card details in the add payment method")
public void cx_must_be_able_to_add_his_new_card_details_in_the_add_payment_method() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    WebElement addPaymentLink = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Add a payment")));
    addPaymentLink.click();

    WebElement creditCardOption = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("//*[@id=\"pp-r092Zq-27\"]/span/input")));
    creditCardOption.click();

    WebElement cardNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("/html/body/div[3]/div/div[2]/div/div/div[2]/div/div[3]/div/div/div/div/div[6]/div[1]/div[3]/div/div[2]")));
    cardNumberField.sendKeys("5123456789012346");

    WebElement expiryField = driver.findElement(By.name("expirationDate")); 
    expiryField.sendKeys("05/34");

    WebElement cvvField = driver.findElement(By.name("cvv")); 
    cvvField.sendKeys("100");

    WebElement nameField = driver.findElement(By.name("nameOnCard")); 
    nameField.sendKeys("Mastercard");

    
    WebElement addContinueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Add and continue")));
    addContinueBtn.click();


}



}
