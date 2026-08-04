package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicAuth {

	
	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtils brUtils = new BrowserUtils();
		driver= brUtils.launchBrowser("chrome");
		
		String userName = "admin";
		String password = "admin";
		
		brUtils.launchURL("https://"+userName+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
		ElementUtils eUtils = new ElementUtils(driver);
		By auth = By.xpath("//p[contains(text(),'Congratulations')]");
		
		String expected = "Congratulations! You must have the proper credentials.";
		
		String text = eUtils.doGetText(auth);
		
		if(text.contains(expected)) {
			System.out.println("Basic Authentication Successful");
		} else {
		    throw new AssertionError("Authentication failed.");
		}
		
		brUtils.quitBrowser();
	}

}
