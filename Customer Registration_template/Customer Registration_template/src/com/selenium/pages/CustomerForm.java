package com.selenium.pages;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerForm {   //Do not change the class name

    WebDriver driver;
    //Declare required variables
    
    public CustomerForm(WebDriver driver){
        this.driver = driver;        
    } 
	//Implement code here
    
   public void setCustumerName(String cName) {
	   driver.findElement(By.name("cname")).sendKeys(cName);
   }
   public void setCustumerAge(String cAge) {
	   driver.findElement(By.name("age")).sendKeys(cAge);
   }
   public void setCustumerAddress(String cAddress) {
	   driver.findElement(By.name("address")).sendKeys(cAddress);
   }
   public void setCustumerPhoneNumber(String cPhone) {
	   driver.findElement(By.name("phonenumber")).sendKeys(cPhone);
   }
   public void setCustumerEmail(String cEmail) {
	   driver.findElement(By.name("email")).sendKeys(cEmail);
	   
   }
   public void submitForm() {
	   driver.findElement(By.id("submit")).click();
	   
   }
   public String errorMessage() {
	  return driver.findElement(By.id("message")).getText();
	   
   }
   
}
