package Selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShadowDOMElement {

	
	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtils brUtils = new BrowserUtils();
		
		driver=brUtils.launchBrowser("chrome");
		brUtils.launchURL("https://practice.expandtesting.com/shadowdom");
		brUtils.maximizePage();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		String jsString = "return document.querySelector(\"#shadow-host\").shadowRoot.querySelector(\"#my-btn\")";
		WebElement shadowButton = (WebElement)js.executeScript(jsString);
		shadowButton.click();

	}
	
	

}
