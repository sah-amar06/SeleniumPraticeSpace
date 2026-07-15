package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EventHubRegistration {

	public static void main(String[] args) throws InterruptedException {

		By signIn = By.xpath("//a[text()='Sign in']");
		By emailField = By.id("register-email");
		By password = By.id("register-password");
		By cnfrmPwd = By.xpath("//input[@placeholder='Repeat your password']");
		By registerBtn = By.id("register-btn");
		By emailErrorMsg = By.xpath("//p[text()='Enter a valid email']");
		By pwdErrorMsg = By.xpath("//p[contains(text(),'Password does not')]");
		By emailExistpopup = By.xpath("//p[contains(text(),'Email already registered')]");
		By signInEmail = By.id("email");
		By signInPwd = By.id("password");
		By signInBtn = By.id("login-btn");
		

		BrowserUtils brUtil = new BrowserUtils();
		WebDriver driver = brUtil.launchBrowser("chrome");

		brUtil.launchURL("https://eventhub.rahulshettyacademy.com/register");

		System.out.println(brUtil.getPageTitle());
		System.out.println(brUtil.getCurrentPageURL());

		ElementUtils utils = new ElementUtils(driver);
		brUtil.maximizePage();

		utils.doClick(registerBtn);

		if (utils.getText(emailErrorMsg)!=null) {
			System.out.println("Please enter your valid email id");

			utils.doSendKeys(emailField, "test1122110@test.com");
			utils.doSendKeys(password, "Test@1234");
			utils.doSendKeys(cnfrmPwd, "Test@1234");
			utils.doClick(registerBtn);
			Thread.sleep(1000);
			if(utils.getText(emailExistpopup)!=null) {
				System.out.println("Email is already registered, please sign in..");
				utils.scrollToElement(signIn);
				Thread.sleep(2000);
				utils.doClick(signIn);
				
				utils.doSendKeys(signInEmail, "test1122110@test.com");
				utils.doSendKeys(signInPwd, "Test@1234");
				utils.doClick(signInBtn);
				
			}
		}else {
			utils.doClick(registerBtn);
		}
		brUtil.quitBrowser();

	}

}
