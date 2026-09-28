package Selenium;

import org.openqa.selenium.WebDriver;

public class TestJSExecutor {

	static WebDriver driver;
	public static void main(String[] args) {
		
		
		BrowserUtils brUtils = new BrowserUtils();
		driver = brUtils.launchBrowser("chrome");
		brUtils.launchURL("https://www.amazon.in/");
		
		JavaScriptUtils jsUtils = new JavaScriptUtils(driver);
		
		String title = jsUtils.getPageTitle();
		System.out.println(title);
		String pageUrl = jsUtils.getPageUrl();
		System.out.println(pageUrl);
		brUtils.launchURL("https://www.google.com/");
		jsUtils.navigateToBackPage();
		jsUtils.navigateToForwardPage();
		jsUtils.refreshBrowserByJS();
		
	}

}
