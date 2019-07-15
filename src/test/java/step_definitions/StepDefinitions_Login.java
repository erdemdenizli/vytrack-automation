package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.testng.Assert;
import com.vytrack.qa.base.Base;
import com.vytrack.qa.pages.LoginPage;

@RunWith(Cucumber.class)
public class StepDefinitions_Login extends Base {
	
	@Given("^initialize the driver with \"([^\"]*)\"$")
	public void initialize_the_driver_with(String arg1) throws Throwable {
		initializeDriver();
	}

	@Given("^user is on \"([^\"]*)\"$")
	public void user_is_on(String arg1) throws Throwable {
		driver.get(arg1);
	}

	@When("^user enters valid (.+) and (.+)$")
	public void user_enters_as_username_and_as_password(String arg1, String arg2) throws Throwable {
		LoginPage page = new LoginPage(driver);
		page.login(arg1 ,arg2);
		page.waitForDropdown();
	}
	
	@When("^user enters invalid (.+) and (.+)$")
	public void user_enters_invalid_user_and_UserUser(String arg1, String arg2) throws Throwable {
		LoginPage page = new LoginPage(driver);
		page.login(arg1 ,arg2);
	}

	@Then("^verify that user is logged in and \"([^\"]*)\" is displayed$")
	public void verify_that_user_is_logged_in_and_is_displayed(String arg1) throws Throwable {
		Assert.assertEquals(driver.getTitle(), arg1);
	}
	
	@Then("^verify that user is not logged in and page title is \"([^\"]*)\"$")
	public void verify_that_user_is_not_logged_in_and_page_title_is(String arg1) throws Throwable {
		softAssert.assertEquals(driver.getTitle(), arg1);
	}
	
	@Then("^\"([^\"]*)\" message pops up$")
	public void alert_message_pops_up(String arg1) throws Throwable {
		LoginPage page = new LoginPage(driver);
		Assert.assertEquals(page.alertMessage().getText(), arg1);
	}
	
	@Then("^close the driver$")
	public void close_the_driver() throws Throwable {
	    driver.quit();
	}


}