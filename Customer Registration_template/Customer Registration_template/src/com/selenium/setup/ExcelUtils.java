package com.selenium.setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {     //Do not change the class name
	//Implement code here
	static int rowNum,colNum;
	public static Object[][] readExcelData(String fileName, String sheetName) throws IOException{
		FileInputStream fis = new FileInputStream(fileName); // Read data file
		XSSFWorkbook wb = new XSSFWorkbook(fis); // Create workbook corresponding to the input file
		Sheet sheet = wb.getSheet(sheetName); // Get the sheet from the workbook
		Row row0 = sheet.getRow(0); 
		
		  rowNum = sheet.getPhysicalNumberOfRows(); //Count number of rows
	 colNum = row0.getLastCellNum();
		
		String[][] data = new String[rowNum - 1][colNum]; //2X3 matrix or 2D array of Strings
		//data will have 2 rows
		//each row will have 3 columns
		//each column will have a string
		
		//System.out.println("num rows :: " + rowNum);
		
		for(int i = 1; i <= rowNum - 1; i++) {
			Row row = sheet.getRow(i);
			for(int j = 0; j < colNum; j++) {
				if(row == null)
					{data[0][j] = " ";}
				else {
					Cell cell = row.getCell(j);
					if(cell == null) {
						data[0][j] = " ";}
					else {data[0][j] = cell.getStringCellValue();}
				}
			}
		}
		wb.close();
						
		return data;
	}
}
