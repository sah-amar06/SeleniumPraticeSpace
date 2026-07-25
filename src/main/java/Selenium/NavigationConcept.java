package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		System.out.println("Page title: "+driver.getTitle());
		
		driver.navigate().to("https://sauce-demo.myshopify.com/");
		
		System.out.println("Page title: "+driver.getTitle());
		
		driver.navigate().back();
		System.out.println("Page title after navigating to  backward: "+driver.getTitle());
		driver.navigate().forward();
		System.out.println("Page title after navigating to forward: "+driver.getTitle());
		
		driver.navigate().refresh();
	}
	
	

}
