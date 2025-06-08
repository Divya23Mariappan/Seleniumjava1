package Stepdef;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertTrue;

public class searchingsortingfiltering {

	    public static WebDriver driver;
	
	@Given("User should be in homepage")
	public void user_should_be_in_homepage() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.ca");
		 System.out.println("Browser launched.");
	}

	@When("User enters {string} in the search box")
	public void user_enters_in_the_search_box(String string) {
		 driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
	}

	@When("clicks on the search button")
	public void clicks_on_the_search_button() {
	   driver.findElement(By.id("nav-search-submit-button")).click();
	}

	@Then("Products matching {string} should be displayed in the results")
	public void products_matching_should_be_displayed_in_the_results(String string) {
		String pageContent = driver.getPageSource().toLowerCase();
        assertTrue("Expected result not found!", pageContent.contains("laptop".toLowerCase()));
		
	}

	@Then("Products containing {string} in name, description, or item number should be displayed")
	public void products_containing_in_name_description_or_item_number_should_be_displayed(String string) {
		String pageContent = driver.getPageSource().toLowerCase();
        assertTrue("Expected partial text not found!", pageContent.contains("laptop".toLowerCase()));
	}

	@Then("A message {string} should be displayed")
	public void a_message_should_be_displayed(String string) {
		WebElement messageElement = driver.findElement(By.cssSelector("div.s-main-slot div.a-section")); // example selector for no results message area, update if needed
        String actualMessage = messageElement.getText();
        assertTrue("Expected message not found!", actualMessage.toLowerCase().contains("searchTerm".toLowerCase()));
	}



}
