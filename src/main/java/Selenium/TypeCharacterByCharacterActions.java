package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TypeCharacterByCharacterActions {

	
	static WebDriver driver;
	
	public static void main(String[] args) {
		ElementUtils eUtils;
		BrowserUtils brUtils;
		
		
		brUtils = new BrowserUtils();
		driver = brUtils.launchBrowser("chrome");
		brUtils.maximizePage();
		brUtils.launchURL("https://www.google.com/");
		eUtils = new ElementUtils(driver);
		By searchField = By.name("q");
		String searchValue = "QA Automation";
		eUtils.doActionsSendKeysWithPause(searchField, searchValue, 1000);
		
	}

}
