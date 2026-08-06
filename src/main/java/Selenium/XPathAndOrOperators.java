package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XPathAndOrOperators {

	static WebDriver driver;
	public static void main(String[] args) {
		
		BrowserUtils brUtil = new BrowserUtils();		
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchURL("https://www.amazon.in/");
		ElementUtils eUtil = new ElementUtils(driver);
		By mobile = By.xpath("//a[text()='Mobiles']");
		eUtil.doClickWithWait(mobile, 10);
		By smartphones = By.xpath("//span[text()='Smartphones & Basic Mobiles']");
		eUtil.doClick(smartphones);
		By seeAllResults = By.xpath("//span[text()='See all results']");
		eUtil.doClick(seeAllResults);
		By productPrice = By.xpath("//span[text()='22,999' or text()='18,999']");
		List<WebElement> productList = eUtil.getElements(productPrice);
		System.out.println("Total number of phones having price 22,999 and 18,999: " +productList.size());
		
		int count1=0, count2=0;
		for(WebElement price:productList) {
			String phonePrice = price.getText();
			
			if(phonePrice.equals("22,999")) {
				count1++;
			}else {
				count2++;
			}
			
		}
		System.out.println("Total phones having price 22,999: " +count1);
		System.out.println("Total phones having price 18,999: " +count2);
		
		By mobilePrice = By.xpath("//span[@class='a-price-whole']");
		List<WebElement> price = eUtil.getElements(mobilePrice);
		int count=0;
		for(WebElement e:price) {
			String unitPrice = e.getText().replace(",", "").trim();
			int value = Integer.parseInt(unitPrice);
			if(value>=18999 && value <=30999) {
				System.out.println(value);
				count++;
			}
		}
		System.out.println("Total smartphones in the range of 18999 and 30999: " +count);
	}

}
