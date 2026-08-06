package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XpathPratice {

	
	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtils brUtil = new BrowserUtils();		
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchURL("https://sauce-demo.myshopify.com/");
		ElementUtils eUtil = new ElementUtils(driver);
		
		//1.Generic X-path
		//Syntax: //tagname[@attribute='value']
		By logo = By.xpath("//img[@alt='Sauce Demo']");
		System.out.println(eUtil.isElementDisplayed(logo));
		
		//2. X-path with *
		//Synatx : //*[@tagname='value']
		By login = By.xpath("//*[@id='customer_login_link']");
		eUtil.doClick(login);
		
		
//=====================================================
//      AND Operator (Intersection)
//=====================================================

/**
* Use case:
* On an e-commerce website, use the XPath 'and' operator to retrieve
* products that satisfy all the specified conditions.
*
* Examples:
* 1. Products priced between ₹1000 and ₹5000.
* 2. Products rated between 3 and 5 stars.
* 3. Products listed between 01-01-2026 and 31-01-2026.
* 4. Locate a unique web element when multiple attribute-value
*    pairs must be satisfied.
*/
		
		
		//3. X-path with 2 attributes and their values
		//Syntax: //tagname[@attribute1='value1' and @attribute2='value']
		By emailField = By.xpath("//input[@type='email' and @id='customer_email']");		
		eUtil.doSendKeys(emailField, "test@test.com");
		
		//4. X-path with one attribute andvalue and another only attribute
		//Syntax: //tagname[@attribute1='value' and @attribute2]
		By passwordFiled = By.xpath("//input[@type='password' and @id]");
		eUtil.doSendKeys(passwordFiled, "Test12345");
		
		/**
		 * NOTE: There is no concept of creating X-path with only attribute's value
		 * i.e. //tagname['value']--> Not available
		 */
		By signInBtn = By.xpath("//input[@type='submit' and @value='Sign In']");
		eUtil.doClick(signInBtn);
		
//=====================================================
//      OR Operator (Union)
//=====================================================


/**
* Use case: On e-commerce site when we have to get all the listed products:
* Examples:
* 1. Retrieve products with a specific price (e.g., ₹999 or ₹1999).
* 2. Retrieve products with a specific rating (e.g., 3 or 5 stars).
* 3. Retrieve products listed on specific dates
*    (e.g., 01-01-2026 or 01-05-2026).
*/
		
//5. X-path with 'or' keyword
//Syntax: //tagname[@attribute1='value' or @attribute2='value']
		
// The OR operator is used when an element can be identified by either of the specified attribute-value pairs.
// The XPath matches an element if at least one condition is true.
//There might be chance that with this x-path approach we will get more than one element
//because, either one WebElement will have any one of the attribute-value pair.
// Note:
// - If multiple elements satisfy either condition,
//   findElements() will return all matching elements.
// - If findElement() is used, Selenium returns only the first matching element.
		 
		
		
		
		brUtil.quitBrowser();

	}

}
