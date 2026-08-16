package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageScrollingAtTheTargetElementActionsClass {

	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtils brUtils;
		ElementUtils eUtils;
		
		brUtils = new BrowserUtils();
		driver = brUtils.launchBrowser("chrome");
		brUtils.launchURL("https://www.amazon.in/");
		eUtils = new ElementUtils(driver);
		By about = By.xpath("//a[text()='About Amazon']");
//		Actions act = new Actions(driver);
//		act.pause(3000).perform();
//		act
//		.scrollToElement(eUtils.getElement(about))
//		.click(eUtils.getElement(about))
//		.perform();
		
		eUtils.scrollToElementAndClickActions(about, 5);
		brUtils.quitBrowser();
	}
	
	

}
