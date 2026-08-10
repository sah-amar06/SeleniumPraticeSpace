package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class MoveToElementActionsClass {

	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtils brUtils = new BrowserUtils();
		driver=brUtils.launchBrowser("chrome");
		brUtils.maximizePage();
		brUtils.launchURL("https://vinothqaacademy.com/mouse-event/");
		ElementUtils eUtils = new ElementUtils(driver);
		By courses = By.xpath("(//a[contains(text(),'Free Complete')])[2]");		
//		Actions action = new Actions(driver);
//		action.moveToElement(eUtils.getElement(courses)).perform();
		By cypress = By.xpath("(//a[text()='Cypress Automation'])[last()]");
		//eUtils.doClickWithWait(cypress, 10);		
		eUtils.handleParentSubMenu(courses, cypress, 10);

	}
}
