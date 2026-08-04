package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUpload {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtils brUtils = new BrowserUtils();
		driver= brUtils.launchBrowser("chrome");
		brUtils.launchURL("https://the-internet.herokuapp.com/upload");
		
		By upload = By.id("file-upload");
		ElementUtils eUtils = new ElementUtils(driver);
		eUtils.doSendKeys(upload, "/Users/amaranthsah/Downloads/krishna 🚩.jpeg");
		
	}

}
