package Stepdef;

import java.time.Duration;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.configReader;


public class Youraddress {
	WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
	@Given("User should mouse hover on {string} to get options to choose from subslist")
	public void user_should_mouse_hover_on_to_get_options_to_choose_from_subslist(String string) throws InterruptedException {
		configReader config = new configReader();
		String email = config.getEmail();
		String password = config.getPassword();
		driver.get("https://www.amazon.ca/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.ca%2F%3F_encoding%3DUTF8%26ref_%3Dnav_custrec_newcust&prevRID=09RRGJSRW5AT8ZSCVP2A&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=caflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=caflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		driver.findElement(By.id("ap_email")).sendKeys(email);
		 driver.findElement(By.cssSelector("#continue")).click();
		 driver.findElement(By.id("ap_password")).sendKeys(password);Thread.sleep(1000); 
		 driver.findElement(By.cssSelector("#signInSubmit")).click(); Thread.sleep(2000);
		 Actions action=new Actions(driver);Thread.sleep(2000);
		action.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList > a > div"))).build().perform();
	}

	@Given("User must select {string} from the options from the dropdwon list")
	public void user_must_select_from_the_options_from_the_dropdwon_list(String string) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#nav-al-your-account > ul > li:nth-child(4) > a")));
	    optionElement.click();
	
	}

	@When("User gets navigated to Your account page, User should click on {string} option")
	public void user_gets_navigated_to_your_account_page_user_should_click_on_option(String string) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  Assert.assertTrue(driver.getCurrentUrl().contains("gp/css/homepage"));
 for (String window : driver.getWindowHandles()) {
		        driver.switchTo().window(window);
		    }
		    WebElement link = wait.until(ExpectedConditions.elementToBeClickable(
		        By.partialLinkText("Address"))); 
		    link.click();
 }

	@Then("User should be able to see {string} option")
	public void user_should_be_able_to_see_option(String string) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    WebElement addAddressBtn = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.id("ya-myab-plus-address-icon"))
		    );
 Assert.assertTrue(addAddressBtn.isDisplayed());
		    System.out.println("Verified: " + string + " option is visible.");
	}

@When("User should click able on {string} option")

public void user_should_click_able_on_option(String string) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("ya-myab-plus-address-icon")));
    element.click();
    String currentWindow = driver.getWindowHandle();
    Set<String> allWindows = driver.getWindowHandles();
    for (String window : allWindows) {
        if (!window.equals(currentWindow)) {
            driver.switchTo().window(window);
            break;
        }}
   
}

@Then("User gets navigated to address window")
public void user_gets_navigated_to_address_window() {
	 try {
	        String currentUrl = driver.getCurrentUrl();
	        System.out.println("Current URL: " + currentUrl);
	        Assert.assertTrue("Expected to be on address page, but was on: " + currentUrl,
	                          currentUrl.contains("address")); // replace with actual partial URL
	    } catch (NoSuchWindowException e) {
	        System.out.println("Window already closed: " + e.getMessage());
	        Assert.fail("Window already closed, cannot validate address window.");
	    }
}

@Given("Country\\/Region must be auto-selected as {string}")
public void country_region_must_be_auto_selected_as(String string) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement countryDropdown = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.id("address-ui-widgets-countryCode-dropdown-nativeId")));
    String selectedCountry = countryDropdown.getAttribute("value");  
    if (!selectedCountry.equalsIgnoreCase(string)) {
        throw new AssertionError("Expected country to be: " + string + " but was: " + selectedCountry);
    }
}

@Given("Full Name field must be filled")
public void full_name_field_must_be_filled() {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement fullNameField = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.id("address-ui-widgets-enterAddressFullName")));
	   String fullName = fullNameField.getAttribute("value");
	    if (fullName == null || fullName.trim().isEmpty()) {
	    throw new AssertionError("Full Name field is empty.");
	    }
}

@Given("Phone Number must be a valid {int}-digit Canadian number")
public void phone_number_must_be_a_valid_digit_canadian_number(Integer int1) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement phoneField = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.id("address-ui-widgets-enterAddressPhoneNumber"))
    );

    String phoneNumber = phoneField.getAttribute("value");

    if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
        throw new AssertionError("Phone number field is empty.");
    }

    // Remove all non-digit characters for length check
    String digitsOnly = phoneNumber.replaceAll("\\D", "");

    if (digitsOnly.length() != int1) {
        throw new AssertionError("Phone number must be " + int1 + " digits but was " + digitsOnly.length());
    }
}

@Given("Address Line {int} must be filled")
public void address_line_must_be_filled(Integer int1) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    String fieldId;
    if (int1 == 1) {fieldId = "address-ui-widgets-enterAddressLine1";
    } else if (int1 == 2) {fieldId = "address-ui-widgets-enterAddressLine2";
    } 
    else {
        throw new IllegalArgumentException("Only Address Line 1 or 2 is supported.");
    }
 WebElement addressField = wait.until(
 ExpectedConditions.visibilityOfElementLocated(By.id(fieldId)));
 String address = addressField.getAttribute("value");
if (address == null || address.trim().isEmpty()) {
throw new AssertionError("Address Line " + int1 + " is empty.");
    }

}

@Given("City must be filled with a valid Canadian city")
public void city_must_be_filled_with_a_valid_canadian_city() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement cityField = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.id("address-ui-widgets-enterAddressCity"))
    );

    String city = cityField.getAttribute("value");

    if (city == null || city.trim().isEmpty()) {
        throw new AssertionError("City field is empty.");
    }
}

@Given("Province must be selected from the dropdown")
public void province_must_be_selected_from_the_dropdown() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement provinceDropdown = wait.until(
        ExpectedConditions.visibilityOfElementLocated(
            By.id("address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId")));
String selectedProvince = provinceDropdown.getAttribute("value");
if (selectedProvince == null || selectedProvince.trim().isEmpty()) {
        throw new AssertionError("Province is not selected.");
    }

    System.out.println("Province selected: " + selectedProvince);
}

@Given("Postal Code must be a valid Canadian postal code")
public void postal_code_must_be_a_valid_canadian_postal_code() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement postalCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.id("address-ui-widgets-enterAddressPostalCode")));
String postalCode = postalCodeField.getAttribute("value");
    if (postalCode == null || postalCode.trim().isEmpty()) {
        throw new AssertionError("Postal Code is empty.");
    }
    if (!postalCode.matches("[A-Za-z]\\d[A-Za-z][ -]?\\d[A-Za-z]\\d")) {
        throw new AssertionError("Postal Code is invalid: " + postalCode);
    }
System.out.println("Postal Code is valid: " + postalCode);
}

@When("User submits the address form")
public void user_submits_the_address_form() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("address-ui-widgets-form-submit-button")));
    submitButton.click();
}

@Then("Address should be successfully saved")
public void address_should_be_successfully_saved() {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.urlContains("address-book"));
    boolean isOnAddressBook = driver.getCurrentUrl().contains("address-book");
    Assert.assertTrue("Address was not saved successfully.", isOnAddressBook);
System.out.println("Address successfully saved.");
}






}