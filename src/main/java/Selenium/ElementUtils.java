package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtils {

	private WebDriver driver;
	private JavascriptExecutor js;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
	}

	public WebElement getElement(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			return element;
		} catch (NoSuchElementException e) {
			throw new ElementNotFoundException("Element not found on the page: " + locator, e);
		}

	}

	/**
	 * IllegalArgumentException
	 */
	private void nullCheck(String value) {
		if (value == null || value.isBlank()) {
			throw new IllegalArgumentException("VALUE IS NULL");
		}
	}

	public void doSendKeys(By locator, String value) {

		

		if (locator == null) {
			throw new IllegalArgumentException("Locator cannot be null.");
		}
		nullCheck(value);
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public void scrollToElement(By locator) {
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", getElement(locator));
	}

	public String getText(By locator) {
		return getElement(locator).getText();
	}
}
