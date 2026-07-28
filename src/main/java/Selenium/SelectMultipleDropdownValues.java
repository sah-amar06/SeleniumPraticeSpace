package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
		String bird1 = "American flamingo";
		String bird2= "Chilean flamingo";
		String bird3 = "Andean flamingo";
		String bird4= "Greater flamingo";
		String bird5 = "James's flamingo";
		String bird6= "Lesser flamingo";
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
