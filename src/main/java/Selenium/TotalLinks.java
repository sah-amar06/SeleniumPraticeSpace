package Selenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TotalLinks {

	public static WebDriver driver;
	public static void main(String[] args) {
		
		
		/**
		 * To get the total links: "html tag" =<a>;
		 * We have to first locate all the links with findElements(By.tagName("a"));
		 */
		
		BrowserUtils brUtils = new BrowserUtils();
		driver = brUtils.launchBrowser("chrome");
		brUtils.launchURL("https://www.flipkart.com/");
		
		//ElementUtils eUtils = new ElementUtils(driver);
		
//		List<WebElement> links = driver.findElements(By.tagName("a"));
//		System.out.println("Total links available on the home page: " +links.size());
//		
//		int textCount=0;
//		int noTextCount = 0;
//		int index = 1;
//		for(int i=0; i<links.size(); i++) {
//			String text = links.get(i).getText();
//			if(!text.isBlank()) {
//				textCount++;
//				System.out.println(index + " : [" +text + "]");
//				index++;
//			}else {
//				noTextCount++;
//			}
//		}
//		
//		System.out.println(textCount);
//		System.out.println(noTextCount);
		
		By linkTag = By.tagName("a");
		By images = By.tagName("img");
		System.out.println("Total links on the web page: " +getElementsCount(linkTag));
		System.out.println("Total images on the web page: " +getElementsCount(images));
		
		List<String> textLists = getElementsTextList(linkTag);
		System.out.println(textLists);
		
		System.out.println(textLists.contains("Login"));
		
		
		
	}
	
	public static void getTotalLinks(By locator) {
		
		List<WebElement> links = getElements(locator);
		System.out.println("Total links available on the web page :" +links.size());
		
		
		
		
		int textCount=0;
		int noTextCount = 0;
		int index = 1;
		for(WebElement element: links) {
			String text = element.getText().trim();
			
			
			
			if(!text.isBlank()) {
				textCount++;
				System.out.println(index + " : [" +text + "]");
				index++;
			}else {
				noTextCount++;
			}
		}
		System.out.println(textCount);
		System.out.println(noTextCount);
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static int getElementsCount(By locator) {
		return getElements(locator).size();
	}
	
	public static List<String> getElementsTextList(By locator) {
		
		List<WebElement> elements = getElements(locator);
		List<String> textList = new ArrayList<>(); 
		
		for(WebElement element:elements) {
			String text = element.getText().trim();
			
			if(!text.isBlank()) {
				textList.add(text);
			}
		}
		return textList;
	}
	

}
