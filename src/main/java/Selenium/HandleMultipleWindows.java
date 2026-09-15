package Selenium;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HandleMultipleWindows {

	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtils brUtils = new BrowserUtils();		
		
		driver= brUtils.launchBrowser("chrome");
		brUtils.launchURL("https://orangehrm.com/");
		brUtils.maximizePage();
		ElementUtils eUtils = new ElementUtils(driver);
		
		String parentWindow = eUtils.getCurrentWindowHandle();
		
		By facebook = By.xpath("//a[contains(@href,'facebook')]");
		By linkedin = By.xpath("//a[contains(@href,'linkedin')]");
		By x = By.xpath("//a[contains(@href,'x.com')]");
		By youtube = By.xpath("//a[contains(@href,'youtube')]");
		By instagram = By.xpath("//a[contains(@href,'instagram')]");
		
		eUtils.doJavaScriptClick(facebook);
		eUtils.doJavaScriptClick(linkedin);
		eUtils.doJavaScriptClick(x);
		eUtils.doJavaScriptClick(youtube);
		eUtils.doJavaScriptClick(instagram);
		
		Set<String> winIds = eUtils.getAllWindowHandles();
		Iterator<String> ids = winIds.iterator();
		while(ids.hasNext()) {
			String windIds = ids.next();
			
			
			if(!windIds.equals(parentWindow)) {
				eUtils.switchWindow(windIds);
				System.out.println(brUtils.getPageTitle());
				brUtils.closeBrowser();
			}		
		}
		eUtils.switchWindow(parentWindow);
		System.out.println(brUtils.getPageTitle());
		

	}

}
