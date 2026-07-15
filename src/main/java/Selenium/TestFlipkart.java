package Selenium;

import java.util.Properties;

public class TestFlipkart {

	public static void main(String[] args) {
		
		BrowserUtils utils = new BrowserUtils();
		ReadProperty property = new ReadProperty();
		Properties prp = property.craeteDriver();
		
		//String browserName = "chrome";
		
		
		utils.launchBrowser(prp.getProperty("browser"));
		
		utils.launchURL(prp.getProperty("url"));
		
		String actualPageTitle = utils.getPageTitle();
		//System.out.println(actualPageTitle);
		
		if(actualPageTitle.contains("Online Shopping")) {
			System.out.println("Landed to the correct page.." +actualPageTitle);
		}else {
			System.out.println("Incorrect page title.. "+actualPageTitle);
		}
		
		String currentPageUrl = utils.getCurrentPageURL();
		
		if(currentPageUrl.contains("flipkart.com")) {
			System.out.println("URL is correct.. "+currentPageUrl);
		}else {
			System.out.println("URL is incorrect.. "+currentPageUrl);
		}
		
		utils.quitBrowser();

	}

}
