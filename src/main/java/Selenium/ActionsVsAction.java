package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ActionsVsAction {

	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtils brUtils = new BrowserUtils();
		driver= brUtils.launchBrowser("chrome");
		brUtils.maximizePage();
		brUtils.launchURL("https://www.google.com/");
		ElementUtils eUtils = new ElementUtils(driver);
		By searchField = By.name("q");
		Actions act = new Actions(driver);
		Action action = act.sendKeys(eUtils.getElement(searchField), "Automation").build();
		action.perform();
		
		eUtils.getElement(searchField).clear();
	}

}
