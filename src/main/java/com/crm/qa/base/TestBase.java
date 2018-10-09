package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.WebEventListener;
import com.crm.qa.util.testUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener e_listener;
	public static Properties pr;
	public FileInputStream fp;
 
	public static Logger log;

	public TestBase() {
		
		try{			
			pr = new Properties();
			fp = new FileInputStream("C://Users//Pallavi//eclipse-workspace//FreeCrmTest//src//main//java//com//crm//qa//config//config.properties");
			pr.load(fp);	
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
			
		}
		
	}
	
	
	public static void Initialise() {
		String BrowserName = pr.getProperty("Browser");
		 log = Logger.getLogger("TestBase");
		 log.debug("Browser Name"+BrowserName);
		if(BrowserName.equals("Chrome") ) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Pallavi\\eclipse-workspace\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(BrowserName.equals("Firefox") ) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Pallavi\\eclipse-workspace\\FreeCrmTest\\src\\main\\java\\com\\crm\\qa\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		//Create Object of EvenetListner to register with WebEventListener
		e_listener = new WebEventListener();
		e_driver.register(e_listener);
		driver = e_driver;
		
		log.debug("Driver Instance Created");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(testUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(testUtil.IMPLICT_WAIT, TimeUnit.SECONDS);
		driver.get(pr.getProperty("AplicationUrl"));
		
		log.debug("Application Url: "+pr.getProperty("AplicationUrl"));
		
	}
	
}
