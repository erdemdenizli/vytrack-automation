package com.vytrack.qa.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	public static SoftAssert softAssert = new SoftAssert();
	
	public void initializeDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/erdemdenizli/Documents/JavaPrograms/vytrackautomation/src/main/java/com/vytrack/qa/config/config.properties");
		
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		//String browserName = ConfigClass.BROWSER;
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.iedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("wait")), TimeUnit.SECONDS); 
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("wait")), TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("base_url"));
		
	}
	
	public void closeDriver() {
		if(driver!=null) driver.quit();
		driver = null;
	}
	
	public void getScreenshot(String result) throws IOException {
		
		File src = ((TakesScreenshot) driver ).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/Users/erdemdenizli/Documents/JavaPrograms/vytrackautomation/src/main/java/com/vytrack/qa/screenshots/"+result+"screenshot.png"));
		
	}
	

}
