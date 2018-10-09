package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	
	@FindBy(xpath="//td[contains(text(), 'User: pallavi Shinde')]")
	WebElement LoggedUserName;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement TasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement NewContactLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyHomePageTitle() {
		return driver.getTitle();
	}
	
	
	public ContactsPage ClickOnContactsLink() {	
		ContactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage ClickOnDealsLink() {
		DealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage ClickOnTasksLink() {
		TasksLink.click();
		return new TasksPage();
		
	}
	
	public boolean VerifyUserNameLabel() {
		return LoggedUserName.isDisplayed();
	}
	
	public void ClickOnNewContactLink() {
		Actions action = new Actions(driver);
		action.moveToElement(ContactsLink).build().perform();
		NewContactLink.click();
	}

	
}
