package Selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowHandles {

	
	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtils brUtils = new BrowserUtils();
		driver = brUtils.launchBrowser("chrome");
		brUtils.launchURL("https://orangehrm.com/");
		ElementUtils eUtils = new ElementUtils(driver);
		
		By closeBtn = By.xpath("(//button[@aria-label='Close banner'])[1]/*[local-name()='svg']");
		eUtils.doClickWithWait(closeBtn, 10);
		
		By facebook = By.xpath("//a[contains(@href,'facebook')]");
		eUtils.doJavaScriptClick(facebook);
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		
		String parentWindow = it.next();
		System.out.println("Parent window id: " +parentWindow);
		String childWindow = it.next();
		System.out.println("Child window id: " +childWindow);
		
		driver.switchTo().window(childWindow);
		System.out.println("Title of the child window: " +driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindow);
		System.out.println("Title of parent window: " +driver.getTitle());
		
	}
	
	

}
