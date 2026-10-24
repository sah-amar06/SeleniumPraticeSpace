package MyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class SauceDemoRegistration extends BaseTest{
	
	public static String getEmail() {
		return  "saucedemo" + System.currentTimeMillis() + "@test.com";
	}
	
	@DataProvider
	public Object[][] getRegTestData() {
		
		return new Object[][] {
			{"Ramnath", "9876543210", "Google", "SDET"},
		};
	}
	
	@Test(dataProvider = "getRegTestData")
	public void registerationTest(String fullName, String phoneNumber, String companyName, String jobTitle) {
		driver.findElement(By.xpath("(//*[local-name()='svg'])[2]")).click();
		driver.findElement(By.name("FullName")).sendKeys(fullName);
		driver.findElement(By.name("Email")).sendKeys(getEmail());
		driver.findElement(By.name("Contact")).sendKeys(phoneNumber);
		Select select = new Select(driver.findElement(By.name("Country")));
		select.selectByVisibleText("India");
		driver.findElement(By.name("CompanyName")).sendKeys(companyName);
		driver.findElement(By.name("JobTitle")).sendKeys(jobTitle);
		Select select1 = new Select(driver.findElement(By.name("NoOfEmployees")));
		select1.selectByIndex(4);
		driver.findElement(By.xpath("//div[@role='presentation']")).click();
		driver.findElement(By.name("action_submitForm")).click();
			
	}
	
	

}
