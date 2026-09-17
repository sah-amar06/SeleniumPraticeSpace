package Selenium;

import org.openqa.selenium.WebDriver;

public class OpenNewTab {

	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtils brUtils = new BrowserUtils();
		driver = brUtils.launchBrowser("chrome");
		brUtils.launchURL("https://orangehrm.com/");
		ElementUtils eUtils = new ElementUtils(driver);
		System.out.println(brUtils.getPageTitle());
		brUtils.maximizePage();
		eUtils.openNewTab();
		brUtils.launchURL("https://sauce-demo.myshopify.com/account/register");
		System.out.println(brUtils.getPageTitle());

	}

}
