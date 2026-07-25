package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GetAttributeConcept {

	public static void main(String[] args) {
		
		BrowserUtils brUtil = new BrowserUtils();
		WebDriver driver = brUtil.launchBrowser("chrome");
		
		brUtil.launchURL("https://sauce-demo.myshopify.com/");
		
		By home = By.xpath("(//ul[@id='main-menu']/li/a)[1]");
		ElementUtils eleUtil = new ElementUtils(driver);
		
		String text = eleUtil.doGetAttribute(home, "href");
		System.out.println(text);

	}

}
