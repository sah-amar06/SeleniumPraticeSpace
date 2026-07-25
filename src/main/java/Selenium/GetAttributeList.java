package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GetAttributeList {

	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtils brUtils = new BrowserUtils();
		driver = brUtils.launchBrowser("chrome");
		brUtils.launchURL("https://www.flipkart.com/");
		
		ElementUtils eUtils = new ElementUtils(driver);
		
		By images = By.tagName("img");
		
		List<String> attributeList = eUtils.getElementAttributeList(images, "src");
		System.out.println(attributeList);
		

	}
	
	
}
