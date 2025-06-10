package amztddproject;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Filteringsorting {
	  WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        driver.manage().window().maximize();
	    }

	    @Test
	    public void testSearchLaptopDisplaysResults() {
	      
	        driver.get("https://www.amazon.ca");
	        System.out.println("Browser launched and navigated to homepage.");

	       
	        String searchTerm = "laptop";
	        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchTerm);

	        
	        driver.findElement(By.id("nav-search-submit-button")).click();

	   
	        String pageContent = driver.getPageSource().toLowerCase();
	        assertTrue(pageContent.contains(searchTerm.toLowerCase()), "Expected result not found!");

	        
	        assertTrue(pageContent.contains(searchTerm.toLowerCase()), "Expected partial text not found!");

	       
	        WebElement messageElement = driver.findElement(By.cssSelector("div.s-main-slot div.a-section"));
	        String actualMessage = messageElement.getText();
	        assertTrue(actualMessage.toLowerCase().contains(searchTerm.toLowerCase()), "Expected message not found!");
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	            System.out.println("Browser closed.");
	        }
	    }
	}

