package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectOptionWithoutSelectMethods {

	static WebDriver driver;
	public static void main(String[] args) {
		
		driver= new ChromeDriver();
		driver.get("https://orangehrm.com/contact-sales");
		
		//By countryList = By.id("Form_getForm_Country");
		By countryList = By.xpath("//Select[@id='Form_getForm_Country']/option");
		
//		Select select = new Select(driver.findElement(countryList));
//		
//		List<WebElement> optionsList = select.getOptions();
//		
//		for(WebElement options:optionsList) {
//			String text = options.getText().trim();
//			if(text.equals("Bolivia")) {
//				options.click();
//				return;
//			}
//		}
		
		//testOptions(countryList, "Bolivia");
		testDropdown(countryList, "Greenland");

	}
	
	public static void testOptions(By locator, String countryName) {
		ElementUtils eUtils = new ElementUtils(driver);
		WebElement closeBtn = eUtils.getElement(By.xpath("//*[@id='CybotCookiebotDialogHeader']/button"));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", closeBtn);
		eUtils.selectOptionWithoutSelectMethods(locator, countryName);
	}
	
	public static void testDropdown(By locator, String countryName) {
		ElementUtils eUtils = new ElementUtils(driver);
		By closeBtn = By.xpath("//*[@id='CybotCookiebotDialogHeader']/button");
			if(eUtils.isElementDisplayed(closeBtn)) {
				eUtils.doJavaScriptClick(closeBtn);
			}
			eUtils.selectOptionByTextWithoutSelect(locator, countryName);
		
	}

}
