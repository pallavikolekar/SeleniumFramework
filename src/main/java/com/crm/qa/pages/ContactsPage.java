package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="td[contains(text(),'Contacts')]")
	WebElement ContactsLabel;
	
	@FindBy(xpath="//a[@title='Contacts']")
	WebElement ContactsLink;
	
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement NewContactLink;
	
	@FindBy(id="first_name")
	WebElement Fname;
	
	@FindBy(id="surname")
	WebElement Lname;
	
	@FindBy(name="client_lookup")
	WebElement CompanyName;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement SaveButton;
	
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyContactsLabel() {
		return ContactsLabel.isDisplayed();
	}
	
	
	public void VerifyClickOnContactsLink() {
		ContactsLink.click();
	}
	
	
	public void CreateNewContact(String strTitle,String strFname,String strLname, String strCompanyName ) {
		
		//mouseover on Contacts link
		Actions action = new Actions(driver);
		action.moveToElement(ContactsLink).build().perform();
		//click on NewContact Link
		NewContactLink.click();
		
		Select DropDownObj = new Select(driver.findElement(By.name("title")));
		DropDownObj.selectByVisibleText(strTitle);
		Fname.sendKeys(strFname);
		Lname.sendKeys(strLname);
		CompanyName.sendKeys(strCompanyName);
		SaveButton.click();
		
	}
	
	
	
	public void SelectContact(String ContactName) {
		
		
		driver.findElement(By.xpath("//a[@_name='"+ContactName+"']")).click();
	   
		
		
		
		/*WebElement ContactsTable = driver.findElement(By.xpath("//form[@id='vContactsForm']/table[@class='datacard']/tbody"));
		
		List<WebElement> Rows = ContactsTable.findElements(By.tagName("tr"));
		
		System.out.println("Rows Count: "+Rows.size());
		
		System.out.println("My Contact Name: "+ContactName);
		
		for(int i=4;i<Rows.size();i++) {
			
			List<WebElement> AllCols =  Rows.get(i).findElements(By.tagName("td"));
			
			System.out.println("Columns  Count: "+AllCols.size());
			
			for(WebElement colData:AllCols) {
			  if(colData.getText().trim().equals(ContactName))	{
				  System.out.println("I m inside for each");
				  for(int k = 0;k<5;k++) {
						  try {
							  colData.click();					  
						  }catch( StaleElementReferenceException ex) {
							  System.out.println(ex.getMessage());
							  colData.click();
						  }
				  }
				  break;
			  }
			}
		
			
			for(int j=1;j<AllCols.size();j++) {
				
				String Mytext = AllCols.get(j).getText();
				System.out.println("My text Name: "+Mytext);
				if(Mytext.trim().equals(ContactName)) {
					
				    int UpdatedJCnt = j+1;
					
					//WebElement WebName = driver.findElement(By.xpath("//a[@_name='"+ContactName+"']"));
					String data ="//*[@id='vContactsForm']/table/tbody/tr["+i+"]/td["+UpdatedJCnt+"]/a[@_name='"+ContactName+"']";
					System.out.println("MyData: "+data);
				    
				    try {
				    	System.out.println("I m inside try");
				    	WebElement MyColElement = driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr["+i+"]/td["+UpdatedJCnt+"]/a[@_name='"+ContactName+"']"));
				    	MyColElement.click();
				    	break;
				    }catch(StaleElementReferenceException ex) {				    	
				        System.out.println("StaleReference Expertion: "+ex.getMessage());
				    	WebElement MyColElement = driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr["+i+"]/td["+UpdatedJCnt+"]/a[@_name='"+ContactName+"']"));
				    	MyColElement.click();
				    	break;
				    	
				    }
						
				}
		       
				break;
			} //end of col loop
			
			
	    }//end of row loop
		*/
	} //end of method
}	//end of class


