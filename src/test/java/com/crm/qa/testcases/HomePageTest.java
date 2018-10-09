package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.testUtil;

public class HomePageTest extends TestBase {
	
	LoginPage LoginPageObj;
	HomePage HomePageObj;
	ContactsPage ContactPageObj;
	testUtil testUtilObj;
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup() {
		
		Initialise();
		testUtilObj = new testUtil();
		LoginPageObj = new LoginPage();
		HomePageObj = LoginPageObj.Login(pr.getProperty("UserName"), pr.getProperty("Password"));
		
	}
	
	
	@AfterMethod	
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void VerifyHomePageTitleTest() {
		String HomePageTitle = HomePageObj.VerifyHomePageTitle();
		Assert.assertEquals("CRMPRO", HomePageTitle,"Home Page Title is not matched");
	}
	
	@Test(priority=2)
	public void VerifyUsername() {
		testUtilObj.SwitchToFrame();
		boolean isDisplayed = HomePageObj.VerifyUserNameLabel();
		Assert.assertTrue(isDisplayed, "UserName is Displayed Wrong");
	}
	
	@Test(priority=3)
	public void verifyContactsTest() {
		testUtilObj.SwitchToFrame();
		ContactPageObj = HomePageObj.ClickOnContactsLink();
	}
	
}
