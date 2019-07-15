package cucumber_runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
//uncomment above to run as TestNG
@CucumberOptions(features = "src/test/java/features", glue = "step_definitions", 
				plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", 
				"junit:target/cukes.xml"}, dryRun = false, monochrome = true,
				strict = false)//also tags = "@..." can be added

public class TestRunner extends AbstractTestNGCucumberTests {
	//extended AbstractTestNGCucumberTests to run as TestNG
}
