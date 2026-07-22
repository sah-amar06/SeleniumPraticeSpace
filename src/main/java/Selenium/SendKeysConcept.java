package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * sendKeys taking character sequence every time.
 * i.e sendKeys can accept following char sequence:
 * 
 * 1. String
 * 2. Array String
 * 3. StringBuffer
 * 4. StringBuilder
 * 
 * 
 * 
 * We can also send multiple string values with one sendKeys().
 * 
 *                 CharSequence (Interface)
                      │
      ┌───────────────┼───────────────┐
      │               │               │
   String        StringBuilder    StringBuffer
 */


public class SendKeysConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		By search = By.id("APjFqb");
		
		String name = "Striver";
		StringBuffer sbf = new StringBuffer("A-Z");
		StringBuilder sb = new StringBuilder("Sheet");
		
		//driver.findElement(search).sendKeys(name, " ", sbf," ", sb," ", "dsa");
		
		String[] names = {"Ram", "Mohan", "Ramu", "Sita"};
		
		//driver.findElement(search).sendKeys(names);
		
		
		/**
		 * We can also pass the character within sendKeys(). Character-by-character typing.
		 * Step 1: Conver the String into character Array (str.toCharArray()).
		 * Step 2: Iterate each character with the help of for-loop.
		 * Step 3: Pass the each character(because char is primitive data type), but before that convert each character into String
		 * String.valueOf(char).
		 */
		String job = "SDET on top product companies";
		
//		char[] ch = job.toCharArray();
//		
//		for(char e:ch) {
//			driver.findElement(search).sendKeys(String.valueOf(e));
//			Thread.sleep(500);
//		}
//		
		
		//Here, element is being located only once. 
		WebElement searchBox = driver.findElement(search);

//		for (char chars : job.toCharArray()) {
//		    searchBox.sendKeys(String.valueOf(chars));
//		    Thread.sleep(200);
//		}
		typeCharacterByCharacter(search, job, 300);
		
	}
	
	public static void typeCharacterByCharacter(By locator, String value, long delay) {
		
		if(locator == null) {
			throw new IllegalArgumentException("Locator cannot be null");
		}
		
		if(value==null || value.isBlank()) {
			throw new IllegalArgumentException("Input value cannot be null or blank");
		}
		
		WebElement element = driver.findElement(locator);
		
		for(char chars: value.toCharArray()) {
			element.sendKeys(String.valueOf(chars));
			
			try {
			Thread.sleep(delay);
			}catch(InterruptedException e) {
				Thread.currentThread().interrupt();
				throw new RuntimeException("Thread interrupted while typing: ", e);
			}
		}
	}

}
