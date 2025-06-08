package testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = {"src/test/resources/features/Amazon.feature",
	"src/test/resources/features/searchingsortingfiltering.feature",
	    		"src/test/resources/features/Your Account.feature",
	    		"src/test/resources/features/YourAddress.feature",
	    		"src/test/resources/features/Your Order.feature",
	    		"src/test/resources/features/Your Payment.feature"},
	    glue = {"Stepdef","utils"},             
	    plugin = {"pretty", "html:target/report.html"},
	    monochrome = true
	)


public class Testrunner {

}
