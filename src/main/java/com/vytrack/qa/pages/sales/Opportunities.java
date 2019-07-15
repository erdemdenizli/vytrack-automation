package com.vytrack.qa.pages.sales;

import com.vytrack.qa.pages.Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Opportunities implements Pages {

    WebDriver driver;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    private WebElement pageName;

    public Opportunities(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement pageName() {
        return pageName;
    }

}
