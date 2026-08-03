package Selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

public class ElementUtils {

	private WebDriver driver;
	private JavascriptExecutor js;

	/**
	 * Initializes the ElementUtils class with the WebDriver instance.
	 *
	 * This constructor initializes the WebDriver and JavaScriptExecutor instances
	 * required to perform web element interactions and JavaScript operations
	 * throughout the framework.
	 *
	 * @param driver WebDriver instance used to interact with the browser
	 * @throws IllegalArgumentException if the WebDriver instance is null
	 */
	public ElementUtils(WebDriver driver) {

		if (driver == null) {
			throw new IllegalArgumentException("WebDriver instance cannot be null.");
		}
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
	}
	
	
	/**
	 * Validates the input text before performing any element interaction.
	 *
	 * This method ensures that the provided input value is neither null nor blank.
	 * It follows the fail-fast principle by rejecting invalid input before
	 * interacting with the WebDriver.
	 *
	 * @param value the text to be validated
	 * @throws IllegalArgumentException if the input value is {@code null} or blank
	 */
	private void validateInput(String value) {
		if (value == null || value.isBlank()) {
			throw new IllegalArgumentException("Input value cannot be null or blank.");
		}
	}

	/**
	 * Validates the locator before attempting to locate a web element.
	 *
	 * This method verifies that the supplied locator is not null. It prevents
	 * invalid WebDriver calls and helps fail fast with a meaningful exception.
	 *
	 * @param locator the Selenium locator used to identify a web element
	 * @throws IllegalArgumentException if the locator is {@code null}
	 */
	private void validateLocator(By locator) {
		if (locator == null) {
			throw new IllegalArgumentException("Locator cannot be null.");
		}
		
		String locatorValue = locator.toString();

		if (locatorValue.endsWith(": ")) {
		    throw new IllegalArgumentException("Locator value cannot be empty.");
		}
	}

	/**
	 * Locates and returns the web element identified by the given locator.
	 *
	 * This method serves as the centralized element retrieval method for the
	 * framework. It validates the locator, locates the web element, and throws a
	 * custom ElementNotFoundException if the element cannot be found. Centralizing
	 * element lookup ensures consistent exception handling and simplifies future
	 * enhancements such as explicit waits, logging, retry mechanisms, or element
	 * highlighting.
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
			throw new ElementNotFoundException("Element not found on the page: " + locator);
		}

	}
	
	/**
	 * Returns all web elements matching the specified locator.
	 *
	 * @param locator Selenium locator used to identify the elements
	 * @return List of matching WebElements (empty if no elements are found)
	 *
	 * @throws IllegalArgumentException if the locator is null
	 */
	public  List<WebElement> getElements(By locator) {
		validateLocator(locator);
		
		return driver.findElements(locator);
	}

	/**
	 * Checks whether the specified element is present and displayed.
	 *
	 * @param locator Selenium locator of the target element
	 * @return true if the element is displayed; false otherwise
	 *
	 * @throws IllegalArgumentException if the locator is null
	 */
	public boolean isElementPresent(By locator) {
		validateLocator(locator);
	    return !getElements(locator).isEmpty();
	}
	
	/**
	 * Returns the number of elements matching the specified locator.
	 *
	 * @param locator Selenium locator used to identify the elements
	 * @return Number of matching elements
	 *
	 * @throws IllegalArgumentException if the locator is null
	 */
	public int getElementsCount(By locator) {
		validateLocator(locator);
	    return getElements(locator).size();
	}
	
	/**
	 * Enters the specified text into the target web element.
	 *
	 * This method validates the locator and input value before locating the element
	 * and performing the sendKeys() operation.
	 *
	 * @param locator Selenium locator used to identify the target element
	 * @param value   Text to be entered into the element
	 *
	 * @throws IllegalArgumentException if the locator is null or the input value is
	 *                                  null or blank
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
	 * This method locates the element using the provided locator and performs a
	 * click operation.
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
	 * This method uses JavaScript scrollIntoView() to bring the target element to
	 * the center of the visible page.
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
	 * Clicks the specified element using JavaScript.
	 *
	 * This method is useful when a normal Selenium click()
	 * fails due to intercepted or hidden element issues.
	 *
	 * @param locator Selenium locator of the target element
	 *
	 * @throws IllegalArgumentException if the locator is null
	 * @throws ElementNotFoundException if the element cannot be located
	 */
	public void doJavaScriptClick(By locator) {
	    try {
	        js.executeScript("arguments[0].click();", getElement(locator));
	    } catch (Exception e) {
	        throw new ElementException("Unable to perform JavaScript click on: " + locator);
	    }
	}

	/**
	 * Retrieves the visible text of the specified web element.
	 *
	 * This method locates the target element and returns the text displayed to the
	 * user.
	 *
	 * @param locator Selenium locator used to identify the target element
	 * @return Visible text of the web element
	 *
	 * @throws IllegalArgumentException if the locator is null
	 * @throws ElementNotFoundException if the element cannot be located
	 */
	public String doGetText(By locator) {
		validateLocator(locator);
		return getElement(locator).getText();
	}

	/**
	 * Types the given text into a web element one character at a time with a
	 * configurable delay.
	 *
	 * This method simulates human typing by sending each character individually
	 * instead of sending the entire string in a single {@code sendKeys()} call. It
	 * is useful for testing applications that trigger events on every keystroke,
	 * such as auto-suggestion search boxes, dynamic dropdowns, debounced input
	 * fields, or bot detection mechanisms.
	 *
	 * Before typing, the method validates the locator and input value to ensure
	 * they are not null or blank. It locates the target element only once and
	 * reuses the same WebElement instance throughout the typing process for better
	 * performance.
	 *
	 * @param locator the locator used to identify the target web element
	 * @param value   the text to be entered into the element
	 * @param delay   delay in milliseconds between each character
	 *
	 * @throws IllegalArgumentException if the locator is null, the input value is
	 *                                  null/blank, or the delay is negative
	 * @throws ElementNotFoundException if the element cannot be located
	 * @throws RuntimeException         if the current thread is interrupted while
	 *                                  typing
	 */
	public void typeCharacterByCharacter(By locator, String value, long delay) {

		// Validate method inputs before interacting with WebDriver.
		validateLocator(locator);
		validateInput(value);

		if (delay < 0) {
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

	/**
	 * Returns the value of the specified attribute from a web element.
	 *
	 * Validates the locator and attribute name before retrieving the attribute
	 * value from the target element.
	 *
	 * @param locator       Selenium locator used to identify the element
	 * @param attributeName Name of the attribute to retrieve
	 * @return Attribute value, or null if the attribute is not present
	 *
	 * @throws IllegalArgumentException if the locator or attribute name is invalid
	 * @throws ElementNotFoundException if the element cannot be located
	 */
	public String doGetAttribute(By locator, String attributeName) {
		validateLocator(locator);
		validateInput(attributeName);
		return getElement(locator).getAttribute(attributeName);
	}
	
	
	/**
	 * Returns the visible text of all elements matching the given locator.
	 *
	 * Blank or empty text values are ignored.
	 *
	 * @param locator Selenium locator used to identify the elements
	 * @return List of visible element texts
	 * @throws IllegalArgumentException if the locator is null
	 */
	public List<String> getElementsTextList(By locator) {		
		List<WebElement> elements = getElements(locator);
		List<String> textList = new ArrayList<>(); 
		
		for(WebElement element:elements) {
			String text = element.getText().trim();			
			if(!text.isBlank()) {
				textList.add(text);
			}
		}
		return textList;
	}
	
	/**
	 * Returns the specified attribute values of all matching elements.
	 *
	 * Null or blank attribute values are ignored.
	 *
	 * @param locator Selenium locator used to identify the elements
	 * @param attributeName Name of the attribute (e.g., "href", "src", "alt", "value")
	 * @return List of attribute values
	 *
	 * @throws IllegalArgumentException if the locator or attribute name is null or blank
	 */
	public List<String> getElementAttributeList(By locator, String attributeName) {
		List<WebElement> imageList = getElements(locator);
		List<String> attributeValues = new ArrayList<>();
		for(WebElement e:imageList) {
			String values = e.getAttribute(attributeName);
			
			if(values!=null && !values.isBlank()) {
				attributeValues.add(values);
			}
		}
		return attributeValues;		
	}
	
	/**
	 * Creates and returns a Select object for the specified dropdown element.
	 *
	 * This method centralizes the creation of the Select object, eliminating
	 * duplicate code across dropdown utility methods. It validates the locator
	 * before locating the element and initializing the Select instance.
	 *
	 * @param locator Selenium locator used to identify the dropdown element
	 * @return Select object associated with the specified dropdown
	 *
	 * @throws IllegalArgumentException if the locator is null
	 * @throws ElementNotFoundException if the dropdown element cannot be located
	 */
	private Select getSelect(By locator) {
	    validateLocator(locator);
	    try {
	        return new Select(getElement(locator));
	    } catch (UnexpectedTagNameException e) {
	        throw new ElementException("Element is not a dropdown: " + locator);
	    }
	}
	
	
	/**
	 * Selects an option from the dropdown by index.
	 *
	 * @param locator Selenium locator of the dropdown
	 * @param index Index of the option to select
	 *
	 * @throws IllegalArgumentException if locator is null or index is negative
	 */
	public void doSelectByIndex(By locator, int index) {
		if (index < 0) {
	        throw new IllegalArgumentException("Index cannot be negative.");
	    }
		getSelect(locator).selectByIndex(index);
	}
	
	/**
	 * Selects an option from the dropdown by visible text.
	 *
	 * @param locator Selenium locator of the dropdown
	 * @param value Visible text of the option
	 *
	 * @throws IllegalArgumentException if locator is null or value is null/blank
	 */
	public void doSelectByVisibleText(By locator, String text) {
		validateInput(text);
		getSelect(locator).selectByVisibleText(text);
	}
	
	/**
	 * Selects an option from the dropdown by value attribute.
	 *
	 * @param locator Selenium locator of the dropdown
	 * @param value Value attribute of the option
	 *
	 * @throws IllegalArgumentException if locator is null or value is null/blank
	 */
	public void doSelectByValue(By locator, String value) {
		validateInput(value);
		getSelect(locator).selectByValue(value);
		
	}
	
	/**
	 * Deselects all selected options from a multi-select dropdown.
	 *
	 * @param locator Selenium locator of the dropdown
	 *
	 * @throws IllegalArgumentException if the locator is null
	 * @throws ElementNotFoundException if the dropdown cannot be located
	 */
	public void deselectAll(By locator) {
		getSelect(locator).deselectAll();
	}
	
	/**
	 * Deselects an option from the dropdown by visible text.
	 *
	 * @param locator Selenium locator of the dropdown
	 * @param text Visible text of the option
	 *
	 * @throws IllegalArgumentException if the locator is null or text is null/blank
	 * @throws ElementNotFoundException if the dropdown cannot be located
	 */
	public void deselectByVisibleText(By locator, String text) {
		validateInput(text);
		getSelect(locator).deselectByVisibleText(text);
	}
	
	/**
	 * Deselects an option from the dropdown by index.
	 *
	 * @param locator Selenium locator of the dropdown
	 * @param index Index of the option to deselect
	 *
	 * @throws IllegalArgumentException if the locator is null or index is negative
	 * @throws ElementNotFoundException if the dropdown cannot be located
	 */
	public void deselectByIndex(By locator, int index) {
		
		if (index < 0) {
	        throw new IllegalArgumentException("Index cannot be negative.");
	    }
		
		getSelect(locator).deselectByIndex(index);
	}
	
	/**
	 * Deselects an option from the dropdown by value attribute.
	 *
	 * @param locator Selenium locator of the dropdown
	 * @param value Value attribute of the option
	 *
	 * @throws IllegalArgumentException if the locator is null or value is null/blank
	 * @throws ElementNotFoundException if the dropdown cannot be located
	 */
	public void deselectByValue(By locator, String value) {
		validateInput(value);
		getSelect(locator).deselectByValue(value);
	}
	
	/**
	 * Deselects an option whose visible text contains the specified value.
	 *
	 * @param locator Selenium locator of the dropdown
	 * @param text Partial visible text of the option
	 *
	 * @throws IllegalArgumentException if the locator is null or text is null/blank
	 * @throws ElementNotFoundException if the dropdown cannot be located
	 */
	public void deselectByContainsVisibleText(By locator, String text) {
		validateInput(text);
		getSelect(locator).deSelectByContainsVisibleText(text);
	}

	/**
	 * Returns the visible text of all options in the dropdown.
	 *
	 * Blank option texts are ignored.
	 *
	 * @param locator Selenium locator of the dropdown
	 * @return List of visible dropdown option texts
	 *
	 * @throws IllegalArgumentException if the locator is null
	 * @throws ElementNotFoundException if the dropdown cannot be located
	 */
	public List<String> getDropdownOptions(By locator) {

	    List<String> optionsText = new ArrayList<>();
	    int count =1;
	    List<WebElement> options = getSelect(locator).getOptions();
	    
	    for (WebElement option:options) {

	        String text = option.getText().trim();
	        
	        if (!text.isBlank()) {
	            optionsText.add(count+":" +text);
	            count++;
	        }
	    }

	    return optionsText;
	}
	
	
	/**
	 * Returns the total number of options available in the dropdown.
	 *
	 * @param locator Selenium locator of the dropdown
	 * @return Number of dropdown options
	 *
	 * @throws IllegalArgumentException if the locator is null
	 * @throws ElementNotFoundException if the dropdown cannot be located
	 */
	public int getDropdownOptionsCount(By locator) {	
		 return getSelect(locator).getOptions().size();	
	}
	
	
	/**
	 * Selects a dropdown option by visible text without using the
	 * Select class selection methods.
	 *
	 * This method uses the Select class only to retrieve the list of
	 * available options and performs the selection manually by clicking
	 * the matching option.
	 *
	 * @param locator Selenium locator of the dropdown
	 * @param value Visible text of the option to select
	 *
	 * @throws IllegalArgumentException if the locator is null or target is null/blank
	 * @throws ElementException if the specified option is not found
	 */
	public void selectOptionWithoutSelectMethods(By locator, String value) {
		
		List<WebElement> optionsText = getSelect(locator).getOptions();
		
		for(WebElement options:optionsText) {
			String text = options.getText().trim();
			if(text.equals(value)) {
				options.click();
				return;
			}
		}
		throw new ElementException("Dropdown option not found: " + value);
	}
	
	
	/**
	 * Selects a dropdown option without using the Selenium Select class.
	 *
	 * This method iterates through all matching option elements and
	 * clicks the option whose visible text matches the specified value.
	 *
	 * @param locator Selenium locator identifying the dropdown options
	 * @param value Visible text of the option to select
	 *
	 * @throws IllegalArgumentException if the locator is null or value is null/blank
	 * @throws ElementException if the specified option is not found
	 */
	public void selectOptionByTextWithoutSelect(By locator, String value) {		
		validateInput(value);
		List<WebElement> elementLists = getElements(locator);
		for(WebElement elements:elementLists) {
			String textValue = elements.getText().trim();
			if(textValue.equals(value)) {
				elements.click();
				return;
			}
		}
		throw new ElementException("Dropdown option not found: " + value);
	}
	
	
	
	/**
	 * Searches for the specified text and selects the matching suggestion.
	 *
	 * @param searchField Selenium locator of the search input field
	 * @param searchText Text to enter into the search field
	 * @param suggestionLocator Selenium locator of the suggestion list
	 * @param targetText Text of the suggestion to select
	 *
	 * @throws IllegalArgumentException if any input is null or blank
	 * @throws ElementException if the target suggestion is not found
	 */
	public void selectSuggestion(By searchField, String searchText, By suggestionLocator, String targetText) {
		validateInput(targetText);
		doSendKeys(searchField, searchText);
		List<WebElement> suggestionLists = getElements(suggestionLocator);
		for(WebElement elements:suggestionLists) {
			String text = elements.getText().trim();
			if(text.contains(targetText)) {
				elements.click();
				return;
			}
		}throw new ElementException("Suggestion not found: " +targetText);
		
	}
	
	
	/**
	 * Checks whether the specified element is displayed.
	 *
	 * @param locator Selenium locator of the target element
	 * @return true if the element is displayed
	 *
	 * @throws IllegalArgumentException if the locator is null
	 * @throws ElementNotFoundException if the element cannot be located
	 */
	public boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	/**
	 * Checks whether the specified element is enabled.
	 *
	 * @param locator Selenium locator of the target element
	 * @return true if the element is enabled; false otherwise
	 *
	 * @throws IllegalArgumentException if the locator is null
	 * @throws ElementNotFoundException if the element cannot be located
	 */
	public boolean isElementEnabled(By locator) {
	    return getElement(locator).isEnabled();
	}
	
	
	/**
	 * Checks whether the specified element is selected.
	 *
	 * Applicable to checkboxes, radio buttons, and options.
	 *
	 * @param locator Selenium locator of the target element
	 * @return true if the element is selected; false otherwise
	 *
	 * @throws IllegalArgumentException if the locator is null
	 * @throws ElementNotFoundException if the element cannot be located
	 */
	public boolean isElementSelected(By locator) {
	    return getElement(locator).isSelected();
	}
}
