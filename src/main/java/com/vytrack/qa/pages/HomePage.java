package com.vytrack.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage implements Pages {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@class='oro-subtitle']")
	private WebElement pageName;

	@FindBy(xpath = "//span[@class='title title-level-1'][contains(text(),'Dashboards')]")
	private WebElement dashboards;

	@FindBy(xpath = "//li[@class='dropdown-menu-single-item first']//span[@class='title title-level-2'][contains(text(),'Dashboard')]")
	private WebElement dashboard;

	@FindBy(xpath = "//span[contains(text(),'Manage Dashboards')]")
	private WebElement manageDashboards;

	@FindBy(xpath = "//span[@class='title title-level-1'][contains(text(),'Fleet')]")
	private WebElement fleet;

	@FindBy(xpath = "//span[text()='Vehicles']")
	private WebElement vehicles;

	@FindBy(xpath = "//span[@class='title title-level-1'][contains(text(),'Customers')]")
	private WebElement customers;

	@FindBy(xpath = "//span[contains(text(),'Accounts')]")
	private WebElement accounts;

	@FindBy(xpath = "//span[contains(text(),'Contacts')]")
	private WebElement contacts;

	@FindBy(xpath = "//span[@class='title title-level-1'][contains(text(),'Sales')]")
	private WebElement sales;

	@FindBy(xpath = "//span[@class='title title-level-2'][contains(text(),'Opportunities')]")
	private WebElement opportunities;

	@FindBy(xpath = "//span[@class='title title-level-1'][contains(text(),'Activities')]")
	private WebElement activities;

	@FindBy(xpath = "//span[contains(text(),'Calls')]")
	private WebElement calls;

	@FindBy(xpath = "//span[contains(text(),'Calendar Events')]")
	private WebElement calendarEvents;

	@FindBy(css = "[class='dropdown user-menu-dropdown'] a")
	private WebElement userDropDown;

	@FindBy(xpath = "//a[@class='no-hash']")
	private WebElement logoutButton;

	public WebElement pageName() {
		return pageName;
	}

	public WebElement dashboards() {
		return dashboards;
	}

	public WebElement dashboard() {
		return dashboard;
	}

	public WebElement manageDashboards() {
		return manageDashboards;
	}

	public WebElement fleet() {
		return fleet;
	}

	public WebElement vehicles() {
		return vehicles;
	}

	public WebElement customers() {
		return customers;
	}

	public WebElement accounts() {
		return accounts;
	}

	public WebElement contacts() {
		return contacts;
	}

	public WebElement sales() {
		return sales;
	}

	public WebElement opportunities() {
		return opportunities;
	}

	public WebElement activities() {
		return activities;
	}

	public WebElement calls() {
		return calls;
	}

	public WebElement calendarEvents() {
		return calendarEvents;
	}

	public WebElement userDropDown() {
		return userDropDown;
	}

	public WebElement logoutButton() {
		return logoutButton;
	}

	public void waitForDropdown() {
		WebDriverWait d = new WebDriverWait(driver, 20);
		d.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='dropdown user-menu-dropdown'] a")));
	}

	public void logout() {

		WebDriverWait d = new WebDriverWait(driver, 20);
		d.until(ExpectedConditions.elementToBeClickable(userDropDown));

		userDropDown().click();
		logoutButton().click();
		
	}
}
