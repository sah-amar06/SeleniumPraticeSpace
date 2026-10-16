package Selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShadowDOMElement2 {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtils brUtils = new BrowserUtils();
		driver = brUtils.launchBrowser("chrome");
		brUtils.launchURL("https://selectorshub.com/xpath-practice-page/");
		brUtils.maximizePage();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		String jsRoot = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#kils\")";
		WebElement  file=(WebElement)js.executeScript(jsRoot);
		file.sendKeys("test");

	}

}
