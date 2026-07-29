package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchSuggestionLists {

	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("sdet");
		
		
		Thread.sleep(3000);
	//	List<WebElement> suggestionLists =driver.findElements(By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']/span"));
		
//		System.out.println(suggestionLists.size());
//		
//		for(WebElement lists : suggestionLists) {
//			String text = lists.getText();
//			System.out.println(text);
//			if(text.contains("jobs")) {
//				lists.click();
//				return;
//			}
//		}throw new ElementException("Dropdown option not found: ")
		
		
		ElementUtils eUtils = new ElementUtils(driver);
		By searchText = By.name("q");
		By suggestionLists = By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']/span");	
		eUtils.selectSuggestion(searchText,"sdet" , suggestionLists, "jobs");
				
		}

}
