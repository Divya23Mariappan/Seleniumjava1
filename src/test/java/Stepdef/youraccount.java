package Stepdef;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.configReader;

public class youraccount {
	WebDriver driver;
	@Given("User must be signed in using valid uername, valid password")
	public void user_must_be_signed_in_using_valid_uername_valid_password() throws InterruptedException {
		configReader config = new configReader();
		String email = config.getEmail();
		String password = config.getPassword();
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&prevRID=09RRGJSRW5AT8ZSCVP2A&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.findElement(By.id("ap_email")).sendKeys(email);
		 driver.findElement(By.cssSelector("#continue")).click();
		 driver.findElement(By.id("ap_password")).sendKeys(password);Thread.sleep(1000);
			 
	}

	@Given("should click on {string} to see {string}")
	public void should_click_on_to_see(String string, String string2) throws InterruptedException {
		driver.findElement(By.cssSelector("#signInSubmit")).click(); Thread.sleep(2000);
		boolean a =driver.findElement(By.cssSelector("#nav-link-accountList > a > div")).isDisplayed();
	    Assert.assertEquals(true, a);
	    System.out.println(a);
	    
	}

	@When("User should mouse hover on {string}")
	public void user_should_mouse_hover_on(String string) {
		 Actions action=new Actions(driver);
			action.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList > a > div"))).build().perform();
	}

	@Then("Customer must get options to choose from subslist")
	public void customer_must_get_options_to_choose_from_subslist() {
		boolean a =driver.findElement(By.id("nav-al-container")).isDisplayed();
	    Assert.assertEquals(true, a);
	    System.out.println(a);
	     
	}







}
