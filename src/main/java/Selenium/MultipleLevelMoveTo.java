package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleLevelMoveTo {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtils brUtils = new BrowserUtils();
		driver= brUtils.launchBrowser("chrome");
		brUtils.maximizePage();
		brUtils.launchURL("https://www.bigbasket.com/");
		ElementUtils eUtils = new ElementUtils(driver);
		By shopCategory = By.xpath("(//span[contains(text(),'Shop by')])[last()]");
		By fashionCategories = By.linkText("Fashion");
		By footwear = By.linkText("Footwear");
		By mensFootwear = By.linkText("Men's Footwear");
		
		eUtils.doClick(shopCategory);
		Thread.sleep(2000);
		eUtils.doMoveToElement(fashionCategories,4);
		eUtils.doMoveToElement(footwear,4);
		eUtils.doClick(mensFootwear);
		brUtils.quitBrowser();
	}

}
