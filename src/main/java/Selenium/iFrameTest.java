package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class iFrameTest {

	static WebDriver driver;

	public static void main(String[] args) {

		BrowserUtils brUtil = new BrowserUtils();
		driver = brUtil.launchBrowser("chrome");
		brUtil.launchURL("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		ElementUtils eUtil = new ElementUtils(driver);
		By registrationForm = By.xpath("//img[contains(@title,'Vehicle-Registration-Forms')]");
		By proposalTitle =  By.id("RESULT_TextField-1");
		By location = By.id("RESULT_TextField-3");
		By proposedCalender = By.className("icon_calendar");
		By proposedDate = By.xpath("//a[text()='12']");
		
		eUtil.doClick(registrationForm);
		driver.switchTo().frame(1);
		eUtil.doSendKeys(proposalTitle, "Test");
		eUtil.doSendKeys(location, "Gopalganj");
		eUtil.doClick(proposedCalender);
		eUtil.doClick(proposedDate);
		brUtil.quitBrowser();
	}

}
