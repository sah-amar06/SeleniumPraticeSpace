package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class TestJSAlertsWithExplicitlyWait {

	static WebDriver driver;
	public static void main(String[] args) {
		BrowserUtils brUtils =  new BrowserUtils();
		driver = brUtils.launchBrowser("chrome");
		brUtils.launchURL("https://the-internet.herokuapp.com/javascript_alerts");
		brUtils.maximizePage();
		ElementUtils eUtils = new ElementUtils(driver);
		By jsAlert = By.xpath("//button[text()='Click for JS Alert']");
		By jsConfirm = By.xpath("//button[text()='Click for JS Confirm']");
		By jsPrompt = By.xpath("//button[text()='Click for JS Prompt']");
		eUtils.doClick(jsAlert, 5);
		eUtils.acceptAlert(5);
		By alertResult = By.xpath("//p[contains(text(),'successfully')]");
		System.out.println(eUtils.doGetText(alertResult));
		
		eUtils.doClick(jsConfirm);
		eUtils.acceptAlert();
		By confirmResult = By.xpath("//p[contains(text(),'Ok')]");
		System.out.println(eUtils.doGetText(confirmResult));
		
		eUtils.doClick(jsPrompt);
		eUtils.sendValueAndAccept("Hello", 5);
		By promptResult = By.xpath("//p[contains(text(),'Hello')]");
		System.out.println(eUtils.doGetText(promptResult));
	}

}
