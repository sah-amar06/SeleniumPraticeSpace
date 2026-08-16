package Selenium;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class PageScrollingWithActionsClass {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtils brUtils = new BrowserUtils();
		driver= brUtils.launchBrowser("chrome");
		brUtils.maximizePage();
		brUtils.launchURL("https://www.amazon.in/");
		Actions action = new Actions(driver);
		
		action.sendKeys(Keys.COMMAND)
				.sendKeys(Keys.END).perform();
		action.pause(Duration.ofSeconds(5));
		action.sendKeys(Keys.COMMAND)
				.sendKeys(Keys.HOME)
				.perform();
	}

}
