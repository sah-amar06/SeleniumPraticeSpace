package Selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * 
 * @author amarnath sah
 *
 */

public class JavaScriptUtils {

	private final WebDriver driver;
	private final JavascriptExecutor js;

	/**
	 * Creates a JavaScript utility instance using the specified WebDriver.
	 *
	 * @param driver WebDriver instance used to interact with the browser
	 *
	 * @throws IllegalArgumentException if the WebDriver is null
	 *                                  or does not support JavascriptExecutor
	 */
	public JavaScriptUtils(WebDriver driver) {

	    if (driver == null) {
	        throw new IllegalArgumentException("WebDriver cannot be null");
	    }

	    if (!(driver instanceof JavascriptExecutor)) {
	        throw new IllegalArgumentException(
	            "Provided WebDriver does not support JavascriptExecutor"
	        );
	    }

	    this.driver = driver;
	    this.js = (JavascriptExecutor) driver;
	}
	
	
	/**
	 * Returns the title of the current web page using JavaScript.
	 *
	 * return title of the current web page
	 */
	public String getPageTitle() {
		return js.executeScript("return document.title").toString();
	}
	
	
	/**
	 * Returns the URL of the current web page using JavaScript.
	 *
	 * return URL of the current web page
	 */
	public String getPageUrl() {
		return js.executeScript("return document.URL").toString();
	}
	
	
	/**
	 * Refreshes the current web page using JavaScript browser history.
	 *
	 * Uses history.go(0) to reload the current page.
	 */
	public void refreshBrowserByJS() {
		js.executeScript("history.go(0)");
	}
	
	
	/**
	 * Navigates to the previous page in the browser history using JavaScript.
	 *
	 * Uses history.go(-1) to move one step backward in the browser history.
	 */
	public void navigateToBackPage() {
		js.executeScript("history.go(-1)");
	}
	
	
	/**
	 * Navigates to the next page in the browser history using JavaScript.
	 *
	 * Uses history.go(1) to move one step forward in the browser history.
	 */
	public void navigateToForwardPage() {
		js.executeScript("history.go(1)");
	}
	
	
	/**
	 * Generates a JavaScript alert with the specified message.
	 *
	 * @param message message to be displayed in the alert
	 */
	public void generateAlert(String message) {
		js.executeScript("alert('" + message + "')");
	}

	/**
	 * Returns all visible text available on the current web page.
	 *
	 * @return visible text from the current web page
	 */
	public String getPageInnerText() {
		return js.executeScript("return document.documentElement.innerText;").toString();
	}

	/**
	 * Clicks the specified web element using JavaScript.
	 *
	 * @param element web element to be clicked
	 */
	public void clickElementByJS(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}

	
	/**
	 * Sets the value of an element identified by its ID using JavaScript.
	 *
	 * @param id ID of the target HTML element
	 * @param value value to be assigned to the element
	 */
	public void sendKeysUsingWithId(String id, String value) {
		js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
	}
	
	/**
	 * Scrolls the current web page to the bottom.
	 */
	public void scrollPageDown() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	/**
	 * Scrolls the current web page to the specified vertical position.
	 *
	 * @param height vertical scroll position
	 */
	public void scrollPageDown(String height) {
		js.executeScript("window.scrollTo(0, '" + height + "')");
	}

	/**
	 * Scrolls the current web page to the top.
	 */
	public void scrollPageUp() {
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	}

	/**
	 * Scrolls the specified web element into the visible viewport.
	 *
	 * @param element web element to scroll into view
	 */
	public void scrollToElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
