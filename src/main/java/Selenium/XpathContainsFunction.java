package Selenium;

import org.openqa.selenium.WebDriver;

public class XpathContainsFunction {

	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtils brUtil = new BrowserUtils();		
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchURL("https://www.amazon.in/");
		ElementUtils eUtil = new ElementUtils(driver);
		
		
	}

}
