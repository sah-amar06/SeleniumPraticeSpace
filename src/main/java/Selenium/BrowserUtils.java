package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtils {
	
	private WebDriver driver;

	
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
	
	/**
	 * Validates the given URL before browser navigation.
	 *
	 * @param url URL to be validated
	 * @throws BrowserException if the URL is null, blank, or invalid
	 */
	private void validateURL(String url) {

	    if (url == null) {
	        throw new BrowserException("URL cannot be null.");
	    }

	    if (url.isBlank()) {
	        throw new BrowserException("URL cannot be blank.");
	    }

	    if (!(url.startsWith("http://") || url.startsWith("https://"))) {
	        throw new BrowserException("Invalid URL: " + url);
	    }
	}
	
	public void launchURL(String url) {
		validateURL(url);
		try {
	        driver.get(url);
	    } catch (WebDriverException e) {
	        throw new BrowserException("Unable to launch URL: " + url);
	    }
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentPageURL() {
		return driver.getCurrentUrl();
	}
	public void maximizePage() {
		driver.manage().window().maximize();
	}
	
	public void minimizePage() {
		driver.manage().window().minimize();
	}
	public void quitBrowser() {
		driver.quit();
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	/**
	 * Navigates to the specified URL.
	 *
	 * @param url URL to navigate to
	 * @throws IllegalArgumentException if the URL is null or blank
	 */
	public void navigateTo(String url) {
		validateURL(url);		
			try {
		        driver.navigate().to(url);
		    } catch (WebDriverException e) {
		        throw new BrowserException("Unable to navigate to URL: " + url);
		    }
		}
	
	
	/**
	 * Navigates to the previous page in the browser history.
	 */
	public void goBack() {
		driver.navigate().back();
	}
	
	
	/**
	 * Navigates to the next page in the browser history.
	 */
	public void goForward() {
		driver.navigate().forward();
	}
	
	
	/**
	 * Refreshes the current web page.
	 */
	public void refresh() {
		driver.navigate().refresh();
	}

}
