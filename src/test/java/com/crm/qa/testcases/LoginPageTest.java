package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
//username - hematest1/test1234
public class LoginPageTest extends TestBase {
	
	LoginPage LoginPageObj;
	HomePage HomePageObj;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {		
		
		Initialise();
		LoginPageObj = new LoginPage();		
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
		log.debug("I am in LoginPageTitleTest" );
		String Title = LoginPageObj.ValidateLoginPageTitle();
		Assert.assertEquals("#1 Free CRM software in the cloud for sales and service", Title);
		log.debug("Assertion for Title is Passed");
	}
	
	
	@Test(priority=2)
	public void CrmLogoImageTest() {
		log.debug("CRMLogo Image Test");
		Boolean IsLogoVisible =  LoginPageObj.ValidateLoginCrmLogo();
		Assert.assertTrue(IsLogoVisible, "Logo Is Present");
		log.debug("Assertion for CRMLogo is passed");
	}
	
	
	@Test(priority=3)
	public void LoginTest() {
		HomePageObj = LoginPageObj.Login(pr.getProperty("UserName"), pr.getProperty("Password"));		
	}

}
