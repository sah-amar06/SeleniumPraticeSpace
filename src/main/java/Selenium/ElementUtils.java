package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtils {

	private WebDriver driver;
	private JavascriptExecutor js;

	
	/**
	 * Initializes the ElementUtils class with the WebDriver instance.
	 *
	 * This constructor initializes the WebDriver and JavaScriptExecutor
	 * instances required to perform web element interactions and JavaScript
	 * operations throughout the framework.
	 *
	 * @param driver WebDriver instance used to interact with the browser
	 * @throws IllegalArgumentException if the WebDriver instance is null
	 */
	public ElementUtils(WebDriver driver) {
		
		if(driver == null){
		    throw new IllegalArgumentException("WebDriver instance cannot be null.");
		}
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
	}


	/**
	 * Locates and returns the web element identified by the given locator.
	 *
	 * This method serves as the centralized element retrieval method for
	 * the framework. It validates the locator, locates the web element,
	 * and throws a custom ElementNotFoundException if the element cannot
	 * be found. Centralizing element lookup ensures consistent exception
	 * handling and simplifies future enhancements such as explicit waits,
	 * logging, retry mechanisms, or element highlighting.
	 *
	 * @param locator Selenium locator used to identify the target element
	 * @return WebElement corresponding to the specified locator
	 *
	 * @throws IllegalArgumentException if the locator is null
	 * @throws ElementNotFoundException if the element cannot be located
	 */
	public WebElement getElement(By locator) {
		
		validateLocator(locator);
		try {
			WebElement element = driver.findElement(locator);
			return element;
		} catch (NoSuchElementException e) {
			throw new ElementNotFoundException("Element not found on the page: " + locator, e);
		}

	}

	/**
	 * Validates the input text before performing any element interaction.
	 *
	 * This method ensures that the provided input value is neither
	 * null nor blank. It follows the fail-fast principle by
	 * rejecting invalid input before interacting with the WebDriver.
	 *
	 * @param value the text to be validated
	 * @throws IllegalArgumentException if the input value is {@code null}
	 *                                  or blank
	 */
	private void validateInput(String value) {
	    if (value == null || value.isBlank()) {
	        throw new IllegalArgumentException("Input value cannot be null or blank.");
	    }
	}
	
	/**
	 * Validates the locator before attempting to locate a web element.
	 *
	 * This method verifies that the supplied locator is not
	 * null. It prevents invalid WebDriver calls and helps
	 * fail fast with a meaningful exception.
	 *
	 * @param locator the Selenium locator used to identify a web element
	 * @throws IllegalArgumentException if the locator is {@code null}
	 */
	private void validateLocator(By locator) {
		if (locator == null) {
			throw new IllegalArgumentException("Locator cannot be null.");
		}
	}

	
	/**
	 * Enters the specified text into the target web element.
	 *
	 * This method validates the locator and input value before locating
	 * the element and performing the sendKeys() operation.
	 *
	 * @param locator Selenium locator used to identify the target element
	 * @param value Text to be entered into the element
	 *
	 * @throws IllegalArgumentException if the locator is null or the input
	 *                                  value is null or blank
	 * @throws ElementNotFoundException if the element cannot be located
	 */
	public void doSendKeys(By locator, String value) {

		validateLocator(locator);
		validateInput(value);
		getElement(locator).sendKeys(value);
	}

	
	/**
	 * Clicks on the specified web element.
	 *
	 * This method locates the element using the provided locator and
	 * performs a click operation.
	 *
	 * @param locator Selenium locator used to identify the target element
	 *
	 * @throws IllegalArgumentException if the locator is null
	 * @throws ElementNotFoundException if the element cannot be located
	 */
	public void doClick(By locator) {
		validateLocator(locator);
		WebElement element = getElement(locator);
		element.click();
	}

	
	/**
	 * Scrolls the page until the specified element is brought into the viewport.
	 *
	 * This method uses JavaScript scrollIntoView() to bring the target
	 * element to the center of the visible page.
	 *
	 * @param locator Selenium locator used to identify the target element
	 *
	 * @throws IllegalArgumentException if the locator is null
	 * @throws ElementNotFoundException if the element cannot be located
	 */
	public void scrollToElement(By locator) {
		validateLocator(locator);

		WebElement element = getElement(locator);
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	}

	
	/**
	 * Retrieves the visible text of the specified web element.
	 *
	 * This method locates the target element and returns the text
	 * displayed to the user.
	 *
	 * @param locator Selenium locator used to identify the target element
	 * @return Visible text of the web element
	 *
	 * @throws IllegalArgumentException if the locator is null
	 * @throws ElementNotFoundException if the element cannot be located
	 */
	public String getText(By locator) {
		return getElement(locator).getText();
	}

	
	/**
	 * Types the given text into a web element one character at a time with a configurable delay.
	 *
	 * This method simulates human typing by sending each character individually
	 * instead of sending the entire string in a single {@code sendKeys()} call.
	 * It is useful for testing applications that trigger events on every keystroke,
	 * such as auto-suggestion search boxes, dynamic dropdowns, debounced input fields,
	 * or bot detection mechanisms.
	 *
	 * Before typing, the method validates the locator and input value to ensure
	 * they are not null or blank. It locates the target element only once and
	 * reuses the same WebElement instance throughout the typing process for better
	 * performance.
	 *
	 * @param locator the locator used to identify the target web element
	 * @param value the text to be entered into the element
	 * @param delay delay in milliseconds between each character
	 *
	 * @throws IllegalArgumentException if the locator is null, the input value is
	 *                                  null/blank, or the delay is negative
	 * @throws ElementNotFoundException if the element cannot be located
	 * @throws RuntimeException if the current thread is interrupted while typing
	 */
	public void typeCharacterByCharacter(By locator, String value, long delay) {

		// Validate method inputs before interacting with WebDriver.
		validateLocator(locator);
		validateInput(value);
		
		if(delay < 0) {
		    throw new IllegalArgumentException("Delay cannot be negative.");
		}
		
		// Locate the element only once to avoid repeated DOM lookups.
		WebElement element = getElement(locator);

		// Simulate human typing by sending one character at a time.
		for (char chars : value.toCharArray()) {
			element.sendKeys(String.valueOf(chars));
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// Restore the interrupted status before propagating the exception.
				Thread.currentThread().interrupt();
				throw new RuntimeException("Thread interrupted while typing: ", e);
			}
		}
	}
}
