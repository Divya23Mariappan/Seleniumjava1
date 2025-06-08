package Stepdef;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.configReader;

public class Stepdefinition {
	WebDriver driver;
	configReader config = new configReader();
	String email = config.getEmail();
	String password = config.getPassword();
	@Given("User must be on Create account page {string}")
	public void user_must_be_on_create_account_page(String string) {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/ap/register?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");

	}
	
	@When("User clicks on {string}")
	public void user_clicks_on(String string) {
	 driver.findElement(By.linkText("Sign in")).click(); 
	}

	@Then("User should be navigated to sign in window")
	public void user_should_be_navigated_to_sign_in_window() {
			boolean a =driver.findElement(By.cssSelector("#authportal-main-section > div:nth-child(2) > div.a-section.a-spacing-base > div.a-section > form > div > div > div > h1")).isDisplayed();
		    Assert.assertEquals(true, a);
		    System.out.println(a);
	}
	@Given("User must be on Sign in or create account page {string}")
	public void user_must_be_on_sign_in_or_create_account_page(String string) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&prevRID=09RRGJSRW5AT8ZSCVP2A&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
	}

	@When("User enters invalid email ID as Divy and click Continue")
	public void user_enters_invalid_email_id_as_divy_and_click_continue() {
	    driver.findElement(By.id("ap_email")).sendKeys("Divy");
	    driver.findElement(By.cssSelector("#continue")).click();
	}

	@Then("User should get an appropriate error message")
	public void user_should_get_an_appropriate_error_message() {
		boolean a =driver.findElement(By.xpath("//*[@id=\"auth-email-invalid-claim-alert\"]/div/div/text()")).isDisplayed();
	    Assert.assertEquals(true, a);
	    System.out.println(a);
	}
	@When("User enters valid email ID as divya.spicerz@gmail.com and click Continue")
	public void user_enters_valid_email_id_as_divya_spicerz_gmail_com_and_click_continue() {
		 driver.findElement(By.id("ap_email")).sendKeys(email);
		    driver.findElement(By.cssSelector("#continue")).click();
	}

	@Then("User should should get navigated to sign in window for password")
	public void user_should_should_get_navigated_to_sign_in_window_for_password() {
		boolean a =driver.findElement(By.id("ap_password")).isDisplayed();
	    Assert.assertEquals(true, a);
	    System.out.println(a);
	}
	    
	
	@When("User enters valid email ID as divya.spicerz@gmail.com and click Continue And in password field enter inavlid password And click {string}")
	public void user_enters_valid_email_id_as_divya_spicerz_gmail_com_and_click_continue_and_in_password_field_enter_inavlid_password_and_click(String string) {
		 driver.findElement(By.id("ap_email")).sendKeys(email);
		 driver.findElement(By.cssSelector("#continue")).click();
		 driver.findElement(By.id("ap_password")).sendKeys("div");
		 driver.findElement(By.cssSelector("#signInSubmit")).click();
		 

		 }
	@When("User enters valid email ID as divya.spicerz@gmail.com and click Continue And in password field do not enter anything And click {string}")
	public void user_enters_valid_email_id_as_divya_spicerz_gmail_com_and_click_continue_and_in_password_field_do_not_enter_anything_and_click(String string) {
		 driver.findElement(By.id("ap_email")).sendKeys(email);
		 driver.findElement(By.cssSelector("#continue")).click();
		 driver.findElement(By.cssSelector("#signInSubmit")).click(); 
		 
		 
	}

	@When("User enters valid email ID as {string} and click {string} And enter Valid password {string}  And click {string}  And User must select the {string} checkbox")
	public void user_enters_valid_email_id_as_and_click_and_enter_valid_password_and_click_and_user_must_select_the_checkbox(String string, String string2, String string3, String string4, String string5) {
		driver.findElement(By.id("ap_email")).sendKeys(email);
		 driver.findElement(By.cssSelector("#continue")).click();
		 driver.findElement(By.id("ap_password")).sendKeys(password);
		 driver.findElement(By.cssSelector("#signInSubmit")).click();
		 driver.findElement(By.cssSelector("#authportal-main-section > div:nth-child(2) > div > div.a-section > div > div > form > div > div.a-section.a-spacing-top-extra-large > div > div > label > div > label > input[type=checkbox]")).click();
		 
	}


	}

	



		 

