package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtils {
	
	WebDriver driver;
	
	/**
	 * The method may return different browser implementations 
	 * such as ChromeDriver, FirefoxDriver, EdgeDriver, or RemoteWebDriver.
	 * Returning the WebDriver interface allows callers to remain 
	 * independent of the concrete browser implementation. 
	 * This follows the "Program to an Interface" principle and makes the framework extensible.
	 * @param browserName
	 * @return
	 */
	public WebDriver launchBrowser(String browserName) {
		
		System.out.println("Please enter the browser name: " +browserName);
		
		switch (browserName.trim().toLowerCase()) {
		case "chrome": 
			driver = new ChromeDriver();
			break;
		case "edge": 
			driver = new EdgeDriver();
			break;
		case "safari": 
			driver = new SafariDriver();
			break;
		case "firefox": 
			driver = new FirefoxDriver();
			break;
			
		default:
			System.out.println("Please enter the correct browser name: " +browserName);
			throw new BrowserException("INVALID BROWSER..");
		}
		return driver;
	}
	
	public void launchURL(String url) {
		if(url==null) {
			throw new BrowserException("INVALID URL.." +url);
		}
		
		if(url.isBlank() || url.isEmpty()) {
			throw new BrowserException("BLANK/EMPTY url.." +url);
		}
		
		if (!(url.startsWith("http://") || url.startsWith("https://"))) {
		    throw new BrowserException("Invalid URL: " + url);
		}
		
		driver.get(url);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentPageURL() {
		return driver.getCurrentUrl();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
	public void closeBrowser() {
		driver.close();
	}

}
