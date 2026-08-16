package Selenium;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AccessibilityTesting {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtils brUtils = new BrowserUtils();
		driver= brUtils.launchBrowser("chrome");
		brUtils.maximizePage();
		brUtils.launchURL("https://www.amazon.in/");
		Actions action = new Actions(driver);
		
		action.sendKeys(Keys.TAB)
					.pause(Duration.ofSeconds(2))
					.sendKeys(Keys.TAB)
					.pause(Duration.ofSeconds(2))
					.sendKeys(Keys.TAB)
					.pause(Duration.ofSeconds(2))
					.sendKeys(Keys.TAB)
					.pause(Duration.ofSeconds(2))
					.sendKeys(Keys.TAB)
					.sendKeys("iPhone 17 Pro")
					.pause(Duration.ofSeconds(2))
					.sendKeys(Keys.ENTER)
					.perform();
				
		
	}

}
