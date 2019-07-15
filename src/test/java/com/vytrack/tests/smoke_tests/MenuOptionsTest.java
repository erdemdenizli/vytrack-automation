package com.vytrack.tests.smoke_tests;

import com.vytrack.qa.base.Base;
import com.vytrack.qa.pages.HomePage;
import com.vytrack.qa.pages.LoginPage;
import com.vytrack.qa.pages.Pages;
import com.vytrack.qa.pages.activities.CalenderEvents;
import com.vytrack.qa.pages.activities.Calls;
import com.vytrack.qa.pages.customers.Accounts;
import com.vytrack.qa.pages.customers.Contacts;
import com.vytrack.qa.pages.dashboards.Dashboard;
import com.vytrack.qa.pages.fleet.Vehicles;
import com.vytrack.qa.pages.sales.Opportunities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class MenuOptionsTest extends Base {

    private static Logger log = LogManager.getLogger(MenuOptionsTest.class.getName());

    @BeforeMethod
    public void initialize() throws IOException {
        initializeDriver();

        log.info("Driver is initialized successfully");

        log.info("Login page is loaded successfully");
    }

    @Test
    public void menuOptionsDriver() throws IOException, InterruptedException {

        LoginPage page = new LoginPage(driver);

        page.login(prop.getProperty("username_driver"), prop.getProperty("password"));

        log.info(prop.getProperty("username_driver") + " logged in");

        HomePage page2 = new HomePage(driver);

        Thread.sleep(3000);

        Actions a = new Actions(driver);

        WebElement[] list = {page2.fleet(), page2.customers(), page2.customers(), page2.activities()};
        WebElement[] list2 = {page2.vehicles(), page2.accounts(), page2.contacts(), page2.calendarEvents()};
        Pages[] list3 = {new Vehicles(driver), new Accounts(driver), new Contacts(driver), new CalenderEvents(driver)};
        String[] expectedTitle = {"Car - Entities - System - Car - Entities - System", "Accounts - Customers", "Contacts - Customers", "Calendar Events - Activities"};
        String[] expectedName = {"Cars", "Accounts", "Contacts", "Calendar Events"};


        for(int i=0; i<list.length; i++) {

            a.moveToElement(list[i]).build().perform();

            list2[i].click();

            Thread.sleep(3000);

            Assert.assertEquals(driver.getTitle(), expectedTitle[i]);

            log.info("Title shows " + expectedTitle[i]);

            Assert.assertEquals(list3[i].pageName().getText(), expectedName[i]);

            log.info("Page name shows " + expectedName[i]);

        }

    }

    @Test
    public void menuOptionsStoreManager() throws IOException, InterruptedException {

        LoginPage page = new LoginPage(driver);

        page.login(prop.getProperty("username_store_manager"), prop.getProperty("password"));

        log.info(prop.getProperty("username_store_manager") + " logged in");

        HomePage page2 = new HomePage(driver);

        Thread.sleep(3000);

        Actions a = new Actions(driver);

        WebElement[] list = {page2.dashboards(), page2.fleet(), page2.customers(), page2.customers(), page2.sales(),
                page2.activities(), page2.activities()};

        WebElement[] list2 = {page2.dashboard(), page2.vehicles(), page2.accounts(), page2.contacts(),
                page2.opportunities(), page2.calls(),page2.calendarEvents()};

        Pages[] list3 = {new Dashboard(driver), new Vehicles(driver), new Accounts(driver), new Contacts(driver),
                new Opportunities(driver), new Calls(driver), new CalenderEvents(driver)};

        String[] expectedTitle = {"Dashboard - Dashboards", "All - Car - Entities - System - Car - Entities - System",
                "All - Accounts - Customers", "All - Contacts - Customers", "Open Opportunities - Opportunities - Sales",
                "All - Calls - Activities", "All - Calendar Events - Activities"};
        String[] expectedName = {"Dashboard", "All Cars", "All Accounts", "All Contacts", "Open Opportunities",
                "All Calls", "All Calendar Events"};


        for(int i=0; i<list.length; i++) {

            a.moveToElement(list[i]).build().perform();

            list2[i].click();

            Thread.sleep(3000);

            Assert.assertEquals(driver.getTitle(), expectedTitle[i]);

            log.info("Title shows " + expectedTitle[i]);

            Assert.assertEquals(list3[i].pageName().getText(), expectedName[i]);

            log.info("Page name shows " + expectedName[i]);

        }

    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();

        log.info("Driver closed");

    }


}
