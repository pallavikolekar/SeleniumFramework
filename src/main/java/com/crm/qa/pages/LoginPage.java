package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory OR OBject Repository
	
	@FindBy(name="username") 
	WebElement Username;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(css="#loginForm > div > div > input")
	WebElement Submitbtn;
	
	@FindBy(xpath="//*[@id='navbar-collapse']/ul/li[2]/a/font")
	WebElement Signup;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement CrmLogo;
		
	//Initialise the Page Objects
	public LoginPage() {		
		PageFactory.initElements(driver, this );		
	}
	
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean ValidateLoginCrmLogo() {
		return CrmLogo.isDisplayed();
	}
	
	public HomePage Login(String username, String pass) {
		
		Username.sendKeys(username);
		Password.sendKeys(pass);
		Submitbtn.submit();
		return new HomePage();
		
	}
	

}
