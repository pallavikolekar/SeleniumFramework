package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.IllegalFormatException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase;

public class testUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICT_WAIT = 20;
	public static String TestData_Sheet_Path ="C:\\Users\\Pallavi\\eclipse-workspace\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa\\testdata\\CrmTestData.xlsx";
	
	public static Workbook book;
	public static Sheet sheet;
	public static JavascriptExecutor js;
	
	public void SwitchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	
	public static Object[][] getTestData(String sheetName) {
		
		FileInputStream file=null;
		
		try {
			file = new FileInputStream(TestData_Sheet_Path);
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();			
		}
		
		try {
			book = new XSSFWorkbook(file);
		}catch( IllegalFormatException  e) {
			e.printStackTrace();			
		}catch(IOException ix) {
			ix.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		
		System.out.println("LastRowNUm: "+sheet.getLastRowNum()+ "ColNo:  "+sheet.getRow(0).getLastCellNum());
		
		Object[][]data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				System.out.println("Data Value: "+data[i][j]);
			}
		}
		
		return data;
		
	}
	
	
	public static void TakeScreenShotOnException() {
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String CurrDirectory = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(srcFile, new File(CurrDirectory +"/Screenshots/"+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
