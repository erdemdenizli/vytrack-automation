package com.vytrack.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;

public class LoginPage {

	WebDriver driver;

	@FindBy(id = "prependedInput")
	private WebElement username;

	@FindBy(id = "prependedInput2")
	private WebElement password;

	@FindBy(id = "_submit")
	private WebElement submit;
	
	@FindBy(xpath = "//div[contains(text(),'Invalid user name or password.')]")
	private WebElement alertMessage;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement username() {
		return username;
	}

	public WebElement password() {
		return password;
	}

	public WebElement submit() {
		return submit;
	}
	
	public WebElement alertMessage() {
		return alertMessage;
	}

	public void login(String username, String password) throws IOException {
		
		username().sendKeys(username);
		password().sendKeys(password);
		submit().click();
	}
	
	public void waitForDropdown() {
		WebDriverWait d = new WebDriverWait(driver, 20);
		d.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='dropdown user-menu-dropdown'] a")));
	}

}
