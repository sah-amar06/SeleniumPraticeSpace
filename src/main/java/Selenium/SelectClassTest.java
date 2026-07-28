package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectClassTest {

	
	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtils brUtils = new BrowserUtils();
		driver = brUtils.launchBrowser("chrome");
		brUtils.launchURL("https://orangehrm.com/contact-sales");
		
		By country = By.id("Form_getForm_Country");
		By employees = By.id("Form_getForm_NoOfEmployees");
		
		ElementUtils eUtils = new ElementUtils(driver);
		eUtils.doSelectByIndex(country, 22);
		eUtils.doSelectByIndex(employees, 4);
		
		eUtils.doSelectByValue(country, "India");
		
		List<String> countryList = eUtils.getDropdownOptions(country);
		System.out.println(countryList);
		
		System.out.println(eUtils.getDropdownOptionsCount(country));
		System.out.println(eUtils.getDropdownOptionsCount(employees));
		brUtils.quitBrowser();
	}

}
