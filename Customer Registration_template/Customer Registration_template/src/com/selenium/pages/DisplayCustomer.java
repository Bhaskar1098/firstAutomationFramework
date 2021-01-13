package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DisplayCustomer {    //Do not change the class name
	//Declare required variables
    WebDriver driver;
    @FindBy(css ="html>body>h2")
    public static WebElement title;
    
    public DisplayCustomer(WebDriver driver){
        this.driver = driver;        
    } 
	//Implement code here
    public String getTitle() {
    	
 	  return driver.findElement(By.cssSelector("html>body>h2")).getText();
    }
    public String getName() {
   	  return driver.findElement(By.xpath("//td[text()='Name']/following-sibling::td")).getText();
      }
    public String getAge() {
   	  return driver.findElement(By.xpath("//td[text()='Age']/following-sibling::td")).getText();
      }
    public String getAddress() {
   	  return driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText();
      }
    public String getPhoneNumber() {
   	  return driver.findElement(By.xpath("//td[text()='Phone number']/following-sibling::td")).getText();
      }
    public String getEmail() {
   	  return driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText();
      }
}
