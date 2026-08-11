package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RightClickConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtils brUtils = new BrowserUtils();
		driver = brUtils.launchBrowser("chrome");
		brUtils.maximizePage();
		brUtils.launchURL("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		ElementUtils eUtils = new ElementUtils(driver);
		By rightClick = By.cssSelector("span.context-menu-one");
		
		Actions action = new Actions(driver);
		
		//action.contextClick(eUtils.getElement(rightClick)).perform();
		eUtils.rightClick(rightClick);
		By dropdownList = By.cssSelector("ul.context-menu-list>li.context-menu-icon>span");
		List<WebElement> lists = eUtils.getElements(dropdownList);
		
		System.out.println("Total options: "+lists.size());
		
		for(WebElement e:lists) {
			String textValue = e.getText().trim();
			System.out.println(textValue);			
			if(textValue.equals("Edit")) {
				e.click();				
				eUtils.acceptAlert();
			}
		}
		
		brUtils.quitBrowser();
	}
}
