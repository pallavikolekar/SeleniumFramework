package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.testUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage LoginPageObj;
	HomePage HomePageObj;
	ContactsPage ContactPageObj;
	testUtil testUtilObj;
	
	public String sheetName="ContactData";
	
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		Initialise();
		testUtilObj = new testUtil();
		LoginPageObj = new LoginPage();
		HomePageObj = LoginPageObj.Login(pr.getProperty("UserName"), pr.getProperty("Password"));
		ContactPageObj = new ContactsPage();
		
	}
	
	@AfterMethod	
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyConctactTest() {
		testUtilObj.SwitchToFrame();
		ContactPageObj.VerifyClickOnContactsLink();
		ContactPageObj.SelectContact("pallavi Shinde");
	}
	
	
	@DataProvider
	public Object[][] getTestCRMData() {
		Object data[][] = testUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority=2,dataProvider="getTestCRMData")
	public void verifyCreateNewContact(String Title,String Fname, String Lname,String CompName) {
		testUtilObj.SwitchToFrame();
		ContactPageObj.VerifyClickOnContactsLink();
		ContactPageObj.CreateNewContact(Title,Fname,Lname,CompName);
	}

}
