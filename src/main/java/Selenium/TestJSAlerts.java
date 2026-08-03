package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestJSAlerts {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtils brUtil = new BrowserUtils();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchURL("https://the-internet.herokuapp.com/");
		
		By alertLink = By.xpath("//a[text()='JavaScript Alerts']");
		By result = By.xpath("//p[@id='result']");
		ElementUtils eUtils = new ElementUtils(driver);
		//eUtils.getElement(jsAlert).click();
		eUtils.doClick(alertLink);
		
		By jsAlertBtn = By.xpath("//button[text()='Click for JS Alert']");		
		eUtils.doClick(jsAlertBtn);
		Thread.sleep(2000);
		eUtils.acceptAlert();
		printAlertResult(eUtils, result);
		Thread.sleep(2000);
		
		By jsConfirmBtn = By.xpath("//button[text()='Click for JS Confirm']");
		eUtils.doClick(jsConfirmBtn);
		Thread.sleep(2000);
		eUtils.acceptAlert();
		printAlertResult(eUtils, result);
		Thread.sleep(2000);
		
		eUtils.doClick(jsConfirmBtn);
		Thread.sleep(2000);
		eUtils.dismissAlert();
		printAlertResult(eUtils, result);
		Thread.sleep(2000);
		
		By jsPromptBtn = By.xpath("//button[text()='Click for JS Prompt']");
		eUtils.doClick(jsPromptBtn);
		Thread.sleep(2000);
		eUtils.sendValueAndAccept("Hi");
		printAlertResult(eUtils, result);
		Thread.sleep(2000);
		
		eUtils.doClick(jsPromptBtn);
		Thread.sleep(2000);
		eUtils.sendValueAndDismiss("Hello");
		printAlertResult(eUtils, result);
		
		brUtil.quitBrowser();
		
	}
	private static void printAlertResult(ElementUtils eUtils, By locator) {
		
		if(eUtils.isElementDisplayed(locator)) {
			System.out.println(eUtils.doGetText(locator)); 
		}
	}

}
