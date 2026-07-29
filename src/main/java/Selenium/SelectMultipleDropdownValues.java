package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectMultipleDropdownValues {

	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		driver= new ChromeDriver();
		driver.get("https://html.com/attributes/select-multiple/");
		
//		WebElement speciesList = driver.findElement(By.xpath("//select[@multiple]"));
//		
//		Select select = new Select(speciesList);
//		System.out.println(select.isMultiple());
//		
//		select.selectByVisibleText("American flamingo");
//		select.selectByVisibleText("Chilean flamingo");
//		select.selectByVisibleText("Andean flamingo");
//		select.selectByVisibleText("Greater flamingo");
//		select.selectByVisibleText("James's flamingo");
//		select.selectByVisibleText("Lesser flamingo");
//		Thread.sleep(1000);
//		select.deselectAll();
		
		By birdLists = By.xpath("//select[@multiple]");
		
		testSelectAndSeselectAll(birdLists);
	}
	
	public static void testSelectAndSeselectAll(By locator) {
		ElementUtils eUtils = new ElementUtils(driver);
		By birdLists = By.xpath("//select[@multiple]");
		eUtils.doSelectByVisibleText(birdLists, "American flamingo");
		eUtils.doSelectByVisibleText(birdLists, "Andean flamingo");
		eUtils.doSelectByVisibleText(birdLists, "Chilean flamingo");
		eUtils.doSelectByVisibleText(birdLists, "Greater flamingo");
		eUtils.doSelectByVisibleText(birdLists, "James's flamingo");
		eUtils.doSelectByVisibleText(birdLists, "Lesser flamingo");
		
		eUtils.deselectAll(locator);
		
	}

}
