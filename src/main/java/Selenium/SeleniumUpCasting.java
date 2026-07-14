package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumUpCasting {

	public static void main(String[] args) {

		/**
		 *
		 *                 SearchContext (Interface)
		 *                        |
		 *                     extends
		 *                        |
		 *              WebDriver (Interface)
		 *                        |
		 *        -----------------------------------
		 *        |                |                |
		 *  JavascriptExecutor  TakesScreenshot  HasCapabilities
		 *      (Interface)       (Interface)      (Interface)
		 *        |                |                |
		 *        -----------------|----------------
		 *                        |
		 *                  implements
		 *                        |
		 *               RemoteWebDriver (Class)
		 *                        |
		 *          -----------------------------------
		 *          |                 |               |
		 *    ChromiumDriver     FirefoxDriver    SafariDriver
		 *        (Class)            (Class)         (Class)
		 *          |
		 *    -----------------
		 *    |               |
		 * ChromeDriver   EdgeDriver
		 *    (Class)       (Class)
		 *
		 */

		// Creates an object of the ChromeDriver class.

		/**
		 * Since, ChromeDriver implements WebDriver(I) through RemoteWebDriver(C).
		 * ChromeDriver object is referenced by WebDriver reference variable.
		 */
		WebDriver driver = new ChromeDriver();

		driver.get("https://eventhub.rahulshettyacademy.com/login");

		String title = driver.getTitle();

		if (title.contains("EventHub")) {
			System.out.println("Page title is correct: " + title);
		} else {
			System.out.println("Page title is incorrect: " + title);
		}

		String url = driver.getCurrentUrl();

		if (url.contains("eventhub.rahulshettyacademy.com/")) {
			System.out.println("url is correct: " + url);
		} else {
			System.out.println("url is incorrect: " + url);
		}

		//driver.quit();

	}
}
