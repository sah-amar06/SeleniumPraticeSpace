package Selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowHandleWhenAlreadyOpenedWindow {

	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtils brUtils = new BrowserUtils();
		driver = brUtils.launchBrowser("chrome");
		brUtils.launchURL("https://orangehrm.com/");
		ElementUtils eUtils = new ElementUtils(driver);
		String parentWindow = eUtils.getCurrentWindowHandle();
		brUtils.maximizePage();
		By twitter = By.xpath("//a[contains(@href,'x.com')]");
		By facebook = By.xpath("//a[contains(@href,'facebook')]");
		By linkedin = By.xpath("//a[contains(@href,'linkedin')]");
		By signUp = By.xpath("//span[text()='Continue with phone']");
		eUtils.doJavaScriptClick(twitter);
		
		Set<String> existingWindows =eUtils.getAllWindowHandles();
		Iterator<String> ids= existingWindows.iterator();
		
		while(ids.hasNext()) {
			String id = ids.next();
			if(!id.equals(parentWindow)) {
				eUtils.switchWindow(id);
				System.out.println(brUtils.getPageTitle());
				eUtils.doClick(signUp);			
			}
		}
		eUtils.switchWindow(parentWindow);
		System.out.println(brUtils.getPageTitle());
		eUtils.doJavaScriptClick(linkedin);
		eUtils.doJavaScriptClick(facebook);
		Set<String> currentWindows = eUtils.getAllWindowHandles();
		currentWindows.removeAll(existingWindows);
//		String newWindow = currentWindows.iterator().next();
//		eUtils.switchWindow(newWindow);
//		System.out.println(brUtils.getPageTitle());
		
		Iterator<String> it = currentWindows.iterator();
		
		while(it.hasNext()) {
			String newIds = it.next();
			if(!newIds.equals(parentWindow)) {
				eUtils.switchWindow(newIds);
				System.out.println(brUtils.getPageTitle());
			}
		}
		eUtils.switchWindow(parentWindow);
		System.out.println(brUtils.getPageTitle());
	}

}
