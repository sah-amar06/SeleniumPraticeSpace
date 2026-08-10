package Selenium;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropAction {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		BrowserUtils brUtils = new BrowserUtils();
		driver=brUtils.launchBrowser("chrome");
		brUtils.maximizePage();
		brUtils.launchURL("https://www.globalsqa.com/demo-site/draganddrop/");
		ElementUtils eUtils = new ElementUtils(driver);
		
		By sourceImage = By.xpath("//img[@alt='The peaks of High Tatras']");
		By trash = By.id("trash");
		Thread.sleep(5000);
		By frame = By.className("demo-frame");
		eUtils.doSwitchToFrame(frame);
//		Actions action = new Actions(driver);
//		action.clickAndHold(eUtils.getElement(sourceImage)).moveToElement(eUtils.getElement(trash)).release().perform();

		eUtils.doDragAndDrop(sourceImage, trash);
		brUtils.quitBrowser();
	}

}
