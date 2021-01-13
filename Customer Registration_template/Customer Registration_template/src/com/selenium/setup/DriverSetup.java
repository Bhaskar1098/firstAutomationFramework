//CREATE DRIVER USING THIS CLASS. DO NOT CHANGE THE CLASS AND METHOD NAME

package com.selenium.setup;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
	public static WebDriver driver;
	public static String baseUrl = "http://webapps.tekstac.com/CustomerRegistration/";
	
	public  WebDriver getDriver() {
		/** For Windows OS
		    System.setProperty("webdriver.geckodriver.driver", "geckodriver.exe");
		**/
		
		/** For Linux OS **/
	   /* System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
		
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        FirefoxProfile profile=new FirefoxProfile();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        firefoxOptions.setProfile(profile);
        driver = new FirefoxDriver(firefoxOptions);*/
		System.setProperty("webdriver.chrome.driver", ".\\browser driver\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	    driver.navigate().to(DriverSetup.baseUrl);
	    return driver;
	}
	

}

