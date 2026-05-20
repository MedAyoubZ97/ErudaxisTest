package com.erudaxisplanificationtests.automation.utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.cucumber.java.Before;

public class Setup {
	
	private static WebDriver driver;
	@Before
	public void setWebDriver() {
		String browser = System.getProperty("browser");
		if(browser == null) {
			browser = "chrome";
		}
		switch (browser) {
		
		case "chrome" : 
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless=new"); 
			chromeOptions.addArguments("--disable-gpu");         
			chromeOptions.addArguments("--window-size=1920,1080"); 
			chromeOptions.addArguments("--no-sandbox");           
			chromeOptions.addArguments("--disable-dev-shm-usage");
			driver = new ChromeDriver(chromeOptions);
			driver.manage().window().maximize();
			break;
			
		case "firefox":
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setCapability("plateform", Platform.WIN10);
			firefoxOptions.setProfile(firefoxProfile);
			driver = new FirefoxDriver(firefoxOptions);
			driver.manage().window().maximize();
			break;
		default:
			throw new IllegalArgumentException("browser \""+browser+"\"is not supported");
		}
		
		
	}
	public static WebDriver getDriver() {
		return driver;
	}
	
}
