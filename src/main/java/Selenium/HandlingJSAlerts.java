package Selenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingJSAlerts {

	
	static WebDriver driver;
	public static void main(String[] args) {
		BrowserUtils brUtils =  new BrowserUtils();
		driver = brUtils.launchBrowser("chrome");
		brUtils.launchURL("https://the-internet.herokuapp.com/javascript_alerts");
		brUtils.maximizePage();
		ElementUtils eUtils = new ElementUtils(driver);
		By jsAlert = By.xpath("//button[text()='Click for JS Alert']");
		eUtils.doClick(jsAlert);
		
		WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = myWait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		By result = By.xpath("//p[contains(text(),'successfully')]");
		String resultText = eUtils.doGetText(result);
		System.out.println(resultText);
	}

}
