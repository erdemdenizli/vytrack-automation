package com.vytrack.tests.components.login_navigation;

import com.vytrack.qa.base.Base;
import com.vytrack.qa.pages.HomePage;
import com.vytrack.qa.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login_Test extends Base {
	
	private static Logger log = LogManager.getLogger(Login_Test.class.getName());
	
	@BeforeMethod
	public void initialize() throws IOException {
		initializeDriver();
		
		log.info("Driver is initialized successfully");
		
		log.info("Login page is loaded successfully");
	}

	@Test
	public void loginTestPositive() throws IOException, InterruptedException {

		LoginPage page = new LoginPage(driver);

		String[] username = {prop.getProperty("username_store_manager"), prop.getProperty("username_sales_manager"), prop.getProperty("username_driver")};

		String name = "";

		for(int i=0; i<username.length; i++) {
			page.login(username[i], prop.getProperty("password"));

			page.waitForDropdown();

			Assert.assertEquals(driver.getTitle(), "Dashboard");

			log.info("Logged in successfully");

			HomePage page2 = new HomePage(driver);

			Thread.sleep(3000);

			if(i==0) {
				name = page2.userDropDown().getText();
			}

			Assert.assertTrue(i==0?!page2.userDropDown().getText().isEmpty():!name.equals(page2.userDropDown().getText()));
			log.info(page2.userDropDown().getText() + " is displayed");

			page2.logout();

			log.info("Logged out successfully");

			Assert.assertEquals(driver.getTitle(), "Login");
		}
	}

	@Test
	public void loginTestNegative() throws IOException, InterruptedException {

		LoginPage page = new LoginPage(driver);

		page.login(prop.getProperty("username_invalid"), prop.getProperty("password_invalid"));

		Assert.assertEquals(page.alertMessage().getText(), "Invalid user name or password.");

		log.info("Could not login and alert message is displayed");

		Assert.assertEquals(driver.getTitle(), "Login");

		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("base_url"));

		log.info("Page title is login and URL has not changed");
	}
	
	@AfterMethod
	public void closeDriver() {
		
		driver.quit();
		
		log.info("Driver closed successfully");
	}

}
