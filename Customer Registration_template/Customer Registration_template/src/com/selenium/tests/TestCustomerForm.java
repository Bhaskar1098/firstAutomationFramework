package com.selenium.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.pages.CustomerForm;
import com.selenium.setup.DriverSetup;
import com.selenium.setup.ExcelUtils;


public class TestCustomerForm extends DriverSetup{   //Do not change the class name
    
    public static String blankErrtxt;
    static Object[][] excelData = null;
    WebDriver driver;
    CustomerForm cf;
    @BeforeClass
    public void setUp() {
     driver=getDriver();
    cf=new CustomerForm(driver);}
	
    @Test(dataProvider="customerinvaid")
    public void testInvalidCustomerDetail( String testName,String cName,String cAge,String cAddress,String cPhoneno,String cEmail) {
    	
    	cf.setCustumerName(cName);
    	cf.setCustumerAge(cAge);
    	cf.setCustumerAddress(cAddress);
    	cf.setCustumerPhoneNumber(cPhoneno);
    	cf.setCustumerEmail(cEmail);
    	cf.submitForm();
    	blankErrtxt=cf.errorMessage();
    	System.out.println("Error Message: "+blankErrtxt);
    	
    	}
    @AfterClass
    public void closeBrowser() {
    	driver.quit();
    	
    }
    @DataProvider(name = "customerinvaid")
    public Object[][] getExcelData() throws IOException {
    	excelData =ExcelUtils.readExcelData(".\\Customer Registration_template\\src\\customer_registration.xlsx", "customer_invalid");
     
    	return excelData ;
  
   }
}
