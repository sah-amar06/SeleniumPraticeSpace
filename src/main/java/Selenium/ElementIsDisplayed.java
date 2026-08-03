package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementIsDisplayed {

	static WebDriver driver;
	public static void main(String[] args) {
		
//		driver = new ChromeDriver();
//		driver.get("https://orangehrm.com/contact-sales");
		
		By contactSales = By.xpath("//button[text()='Contact Sales']");
		//System.out.println(contactSales);
		
//		boolean flag = driver.findElement(contactSales).isDisplayed();
//		System.out.println(flag);
		
		BrowserUtils brUtils = new BrowserUtils();
		driver =brUtils.launchBrowser("chrome");
		brUtils.launchURL("https://orangehrm.com/contact-sales");
		
		ElementUtils eUtils = new ElementUtils(driver);
		boolean flag = eUtils.isElementDisplayed(contactSales);
		System.out.println(flag);
		brUtils.quitBrowser();

	}

}
