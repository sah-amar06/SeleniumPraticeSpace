package Selenium;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaitWithFluentFeatures {

	
	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtils brutil = new BrowserUtils();
		driver = brutil.launchBrowser("chrome");
		brutil.launchURL("https://orangehrm.com/");
		brutil.maximizePage();
		ElementUtils eutil = new ElementUtils(driver);
		By sales = By.xpath("//button[text()='Contact Sales']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.pollingEvery(Duration.ofSeconds(1))
		//.ignoring(NoSuchElementException.class)
		.withMessage("===Element is not present===");
		
		wait.until(ExpectedConditions.elementToBeClickable(sales)).click();
	}

}
