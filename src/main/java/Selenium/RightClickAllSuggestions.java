package Selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RightClickAllSuggestions {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

	    BrowserUtils brUtils = new BrowserUtils();

	    driver = brUtils.launchBrowser("chrome");
	    brUtils.maximizePage();
	    brUtils.launchURL("https://swisnl.github.io/jQuery-contextMenu/demo.html");

	    ElementUtils eUtils = new ElementUtils(driver);

	    By rightClick = By.cssSelector("span.context-menu-one");

	    // Open context menu
	    eUtils.rightClick(rightClick);

	    // Locate all context-menu options
	    By contextMenuOptions =
	            By.cssSelector("li.context-menu-icon > span");

	    List<WebElement> contextMenuElements =
	            eUtils.getElements(contextMenuOptions);

	    System.out.println(
	            "Total options: " + contextMenuElements.size()
	    );

	    // Store option text instead of WebElement references
	    List<String> optionTexts = new ArrayList<>();

	    for (WebElement option : contextMenuElements) {

	        String text = option.getText().trim();

	        if (!text.isBlank()) {
	            optionTexts.add(text);
	        }
	    }

	    System.out.println(
	            "Total valid options: " + optionTexts.size()
	    );

	    // Click each option one by one
	    for (String text : optionTexts) {

	        System.out.println("Clicking: " + text);

	        // Reopen context menu
	        eUtils.rightClick(rightClick);

	        // Locate the option again
	        By optionLocator = By.xpath(
	                "//ul[contains(@class,'context-menu-list')]"
	                + "//span[normalize-space()='" + text + "']"
	        );

	        // Click option
	        eUtils.doClick(optionLocator);

	        // Handle JavaScript alert
	        if (eUtils.isAlertPresent()) {

	            System.out.println(
	                    "Alert: " + eUtils.getAlertText()
	            );

	            Thread.sleep(1000);

	            eUtils.acceptAlert();
	        }
	    }

	    brUtils.quitBrowser();
	}

}
