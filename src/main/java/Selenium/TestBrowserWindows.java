package Selenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBrowserWindows {

	
	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtils brUtils = new BrowserUtils();
		driver= brUtils.launchBrowser("chrome");
		brUtils.launchURL("https://orangehrm.com/");
		brUtils.maximizePage();
		ElementUtils eutils = new ElementUtils(driver);
		String parentWindow = eutils.getCurrentWindowHandle();
		By closeBtn = By.xpath("//button[@id='CybotCookiebotBannerCloseButtonE2E']//*[local-name()='svg']");
//		if(eutils.isElementEnabled(closeBtn)) {
//			eutils.doClick(closeBtn);
//		}
		
		eutils.doWaitForTheElementVisible(closeBtn, 10).click();
		By facebook = By.xpath("//a[contains(@href,'facebook')]");
		
		eutils.doJavaScriptClick(facebook);
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
		if(wait.until(ExpectedConditions.numberOfWindowsToBe(2))) {
			Set<String> winIds =eutils.getAllWindowHandles();
			
			for(String windows:winIds) {
				if(!windows.equals(parentWindow)) {
					eutils.switchWindow(windows);
					eutils.waitForUrlContains("facebook", 5);
					System.out.println("Child window title: " +brUtils.getPageTitle());
					System.out.println("Child window url: " +brUtils.getCurrentPageURL());
					break;
				}
			}
			eutils.switchWindow(parentWindow);
			System.out.println("Parent window title: " +brUtils.getPageTitle());
		}
		brUtils.quitBrowser();
	}

}
