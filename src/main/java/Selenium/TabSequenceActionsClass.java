package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class TabSequenceActionsClass {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtils brUtils = new BrowserUtils();
		driver= brUtils.launchBrowser("chrome");
		brUtils.maximizePage();
		brUtils.launchURL("https://sauce-demo.myshopify.com/account/register");
		ElementUtils eUtils = new ElementUtils(driver);
		Actions action = new Actions(driver);
		By firstName = By.id("first_name");
		
		action.sendKeys(eUtils.getElement(firstName), "Amarnath")
			.pause(2000)
				.sendKeys(Keys.TAB)
					.sendKeys("Sah")
						.pause(Duration.ofSeconds(2))
							.sendKeys(Keys.TAB)
								.sendKeys("test12@test.com")
									.pause(2000)
										.sendKeys(Keys.TAB)
											.sendKeys("1234ASDF")
												.pause(2000)	
													.sendKeys(Keys.TAB)
														.sendKeys(Keys.ENTER)	
															.perform();
	}

}
