package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChildWindowHandle {

	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtils brUtils = new BrowserUtils();
		driver = brUtils.launchBrowser("chrome");
		brUtils.launchURL("https://orangehrm.com/");
		ElementUtils eUtils = new ElementUtils(driver);
		
		By closeBtn = By.xpath("(//button[@aria-label='Close banner'])[1]/*[local-name()='svg']");
		eUtils.doClickWithWait(closeBtn, 10);
		
		By facebook = By.xpath("//a[contains(@href,'facebook')]");
		eUtils.switchToChildWindow(facebook);
	}

}
