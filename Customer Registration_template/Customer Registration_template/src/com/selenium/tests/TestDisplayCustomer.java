package com.selenium.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.selenium.pages.CustomerForm;
import com.selenium.pages.DisplayCustomer;
import com.selenium.setup.DriverSetup;
import com.selenium.setup.ExcelUtils;

public class TestDisplayCustomer extends DriverSetup{   //Do not change the class name

        public static String titletxt;
        public static String customerNametxt;
        public static String agetxt;
        public static String addresstxt;
        public static String numbertxt;
        public static String emailtxt;
	//Implement code here
        static Object[][] excelData = null;
        WebDriver driver;
        CustomerForm cf;
        DisplayCustomer ds;
        @BeforeClass
        public void setUp() {
         driver=getDriver();
        cf=new CustomerForm(driver);
        ds=new DisplayCustomer(driver);
        }
    	
        @Test(dataProvider="customervalid")
        public void testValidCustomerDetail( String testName,String cName,String cAge,String cAddress,String cPhoneno,String cEmail) {
        	
        	cf.setCustumerName(cName);
        	cf.setCustumerAge(cAge);
        	cf.setCustumerAddress(cAddress);
        	cf.setCustumerPhoneNumber(cPhoneno);
        	cf.setCustumerEmail(cEmail);
        	cf.submitForm();
        	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	titletxt=ds.getTitle();
        	System.out.println(titletxt);
        	customerNametxt=ds.getName();
        	System.out.println(customerNametxt);
        	 agetxt=ds.getAge();
        	 System.out.println(agetxt);
        	 addresstxt=ds.getAddress();
        	 System.out.println(addresstxt);
        	 numbertxt=ds.getPhoneNumber();
        	 System.out.println(numbertxt);
        	 emailtxt=ds.getEmail();
        	 System.out.println(emailtxt);
        	}
        @AfterClass
        public void closeBrowser() {
        	driver.quit();
        	
        }
        @DataProvider(name = "customervalid")
        public Object[][] getExcelData() throws IOException {
        	excelData =ExcelUtils.readExcelData(".\\Customer Registration_template\\src\\customer_registration.xlsx", "customer_valid");
         
        	return excelData ;
      
       }
    }
