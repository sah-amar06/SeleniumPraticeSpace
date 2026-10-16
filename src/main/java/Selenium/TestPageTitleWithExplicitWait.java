package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestPageTitleWithExplicitWait {

	
	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtils brUtils = new BrowserUtils();
		driver = brUtils.launchBrowser("chrome");
		brUtils.launchURL("https://www.amazon.in/");
		brUtils.maximizePage();
		ElementUtils eUtils = new ElementUtils(driver);
		String url= eUtils.waitForTitleContains("Amazon", 10);
		System.out.println(url);
		////div[@id='navFooter']//div[contains(@class,'navFooterLinkCol')]/ul/li/a[text()='Sell on Amazon']
		/// //div[@id='navFooter']//div[1]/div[5]/ul/li[1]/a
		By sell = By.xpath("//*[@id=\"navFooter\"]/div[1]/div/div[5]/ul/li[1]/a");
		eUtils.doJavaScriptClick(sell);
		String title = eUtils.waitForTitleContains("Selling", 10);
		System.out.println(title);
		
		
	}

}
