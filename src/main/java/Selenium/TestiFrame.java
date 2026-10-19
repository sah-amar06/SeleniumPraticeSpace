package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestiFrame {

	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtils brUtils = new BrowserUtils();
		driver = brUtils.launchBrowser("chrome");
		brUtils.launchURL("https://rahulshettyacademy.com/AutomationPractice/");
		brUtils.maximizePage();
		ElementUtils eUtils = new ElementUtils(driver);	
		By radioButton1 = By.name("radioButton");
		eUtils.doSwitchToFrame(0, 10);
		By linkedIn = By.xpath("//span[contains(@class,'linkedin')]");
		eUtils.doClick(linkedIn);
		
		eUtils.doSwitchToDefaultContent();
		eUtils.doClick(radioButton1);

	}

}
