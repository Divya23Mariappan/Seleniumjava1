package Stepdef;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Yourorder {
	WebDriver driver;
	@Given("User must be on Hello <username> Account & Lists Page url {string}")
	public void user_must_be_on_hello_username_account_lists_page_url(String string) throws InterruptedException  {
		configReader config = new configReader();
		String email = config.getEmail();
		String password = config.getPassword();
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&prevRID=09RRGJSRW5AT8ZSCVP2A&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.findElement(By.id("ap_email")).sendKeys(email);
		 driver.findElement(By.cssSelector("#continue")).click();
		 driver.findElement(By.id("ap_password")).sendKeys(password);Thread.sleep(1000); 
		 driver.findElement(By.cssSelector("#signInSubmit")).click(); Thread.sleep(2000);
		 
	}
	@When("User mouse hover on Hello<username> Account & Lists")
	public void user_mouse_hover_on_hello_username_account_lists() {
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList > a > div"))).build().perform();
	}

	@When("clicks on your orders")
	public void clicks_on_your_orders() {
		driver.findElement(By.id("nav_prefetch_yourorders")).click();
	}

	@Then("Should navigate to order history page where one can view order placed in past. Like Past 3 months, this year or any archived order")
	public void should_navigate_to_order_history_page_where_one_can_view_order_placed_in_past_like_past_months_this_year_or_any_archived_order(Integer int1) {
		boolean a =driver.findElement(By.cssSelector("#a-page > section > div.your-orders-content-container__content.js-yo-main-content")).isDisplayed();
	    Assert.assertEquals(true, a);
	    System.out.println(a);
	}
	
	@Then("User must get option of Buy Again, Not Yet Shipped, Cancelled orders")
	public void user_must_get_option_of_buy_again_not_yet_shipped_cancelled_orders() throws InterruptedException {
		boolean a =driver.findElement(By.linkText("Buy Again")).isDisplayed(); Thread.sleep(2000);
		 Assert.assertEquals(true, a);
		 boolean b =driver.findElement(By.linkText("Not Yet Shipped")).isDisplayed(); 
		 Assert.assertEquals(true, b);
		 boolean c =driver.findElement(By.linkText("Cancelled Orders")).isDisplayed(); 
		 Assert.assertEquals(true, c);
		 System.out.println(a);
		 System.out.println(b);
		 System.out.println(c);
}
	@Given("User must be on {string} Page url {string}")
	public void user_must_be_on_page_url(String string, String string2) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&prevRID=09RRGJSRW5AT8ZSCVP2A&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.findElement(By.id("ap_email")).sendKeys("divya.spicerz@gmail.com");
		 driver.findElement(By.cssSelector("#continue")).click();
		 driver.findElement(By.id("ap_password")).sendKeys("Saravdiv@230990");Thread.sleep(1000); 
		 driver.findElement(By.cssSelector("#signInSubmit")).click(); Thread.sleep(2000);
		 Actions action=new Actions(driver);
			action.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList > a > div"))).build().perform();
			driver.findElement(By.id("nav_prefetch_yourorders")).click();	
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement yourOrders = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav_prefetch_yourorders")));
			yourOrders.click();
	}
	@When("User is on {string} Page url {string}")
	public void user_is_on_page_url(String string, String string2) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
				driver.get("https://www.amazon.ca/gp/css/order-history?ref_=nav_AccountFlyout_orders");
				
	}

	@When("User should click on {string}")
	public void user_should_click_on(String string) {
		driver.findElement(By.cssSelector("#nav_prefetch_yourorders > span")).click();
	}


	@Then("User must get recommendation according to purchase history")
	public void user_must_get_recommendation_according_to_purchase_history() {
		boolean a =driver.findElement(By.id("CardInstanceIwRuX6_tPw7y8zLW9coFEg")).isDisplayed();
	    Assert.assertEquals(true, a);
	    System.out.println(a); 
	}
	@When("User should clicks on {string}")
	public void user_should_clicks_on(String string) throws InterruptedException {
		WebElement buyAgain = driver.findElement(By.xpath("//a[contains(text(),'Buy Again')]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", buyAgain);
	}

	@Then("User recommendation according to purchase history should be displayed")
	public void user_recommendation_according_to_purchase_history_should_be_displayed() {
		boolean a =driver.findElement(By.cssSelector("#CardInstancetgH3iJNKT99oFdEO-amR5w > div > span")).isDisplayed();
	    Assert.assertEquals(true, a);
	    System.out.println(a);  
	
	}
	@Then("any cancelled order in the past {int} months should be displayed")
	public void any_cancelled_order_in_the_past_months_should_be_displayed(Integer int1) {
		
		   driver.findElement(By.xpath("//a[contains(text(),'Cancelled Orders')]")).click();
		   
		   boolean isDisplayed = driver.getPageSource().contains("Cancelled Orders")
			        || driver.findElements(By.xpath("//*[contains(text(),'Cancelled')]")).size() > 0;
			    Assert.assertTrue("Cancelled Orders are not displayed", isDisplayed);
		}
	@Then("It must display pending orders, else display appropriate")
	public void it_must_display_pending_orders_else_display_appropriate() {
		     
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement notYetShippedTab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Not Yet Shipped') or contains(text(), 'Not yet shipped')]")));
		notYetShippedTab.click();
		       }
	


	
	
	
	}

	
	
	
	
	
	





