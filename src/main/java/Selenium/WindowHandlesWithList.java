package Selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowHandlesWithList {

	
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
		eUtils.doJavaScriptClick(twitter);
		eUtils.doJavaScriptClick(facebook);
		eUtils.doJavaScriptClick(linkedin);
		
		Set<String> windowIds = eUtils.getAllWindowHandles();
		List<String> windowList = new ArrayList<>(windowIds);
		
		System.out.println(windowList.get(0));
		System.out.println(windowList.get(1));
		System.out.println(windowList.get(2));
		System.out.println(windowList.get(3));
		
		for(String ids:windowList) {
			eUtils.switchWindow(ids);
			
			if(!ids.equals(parentWindow)) {
				System.out.println(brUtils.getPageTitle());
				brUtils.closeBrowser();
			}
		}
		eUtils.switchWindow(parentWindow);
		System.out.println("Page title of Parent window: "+brUtils.getPageTitle());
	}

}
