package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NestedFrames {

	
	/**
	 * Main Document
	 * 	│
	    ├── Frame A
	    │      │
	    │      └── Frame B
	    │             │
	    │             └── Frame C

	 */
    
	
	static WebDriver driver;
	public static void main(String[] args) {
		ElementUtils eUtils;
		BrowserUtils brUtils = new BrowserUtils();
		driver = brUtils.launchBrowser("chrome");
		brUtils.launchURL("https://selectorshub.com/iframe-scenario/");
		eUtils = new ElementUtils(driver);
		
		//Frame1
		eUtils.doSwitchToFrame("pact1");
		By firstCrush = By.id("inp_val");
		eUtils.doSendKeys(firstCrush, "I don't know");
		
		
		//Frame2
		eUtils.doSwitchToFrame("pact2");
		By currentCrush = By.id("jex");
		eUtils.doSendKeys(currentCrush, "I don't know her name");
		
		System.out.println(eUtils.doGetText(By.tagName("h4")));
		
		//Frame3
		eUtils.doSwitchToFrame("pact3");
		By heaven = By.id("glaf");
		eUtils.doSendKeys(heaven, "Earth");
		
		
		//Switching back to parent frame of Frame3
		eUtils.doSwitchToParentFrame();
		eUtils.doSendKeys(currentCrush, " She is beautiful");
		
		//Switching back to parent frame of frame2
		eUtils.doSwitchToParentFrame();
		eUtils.doSendKeys(firstCrush, " She was very chulbuli");
		
		
		/**
		 * 
		 * Switching from frame1 to frame3 --> Not applicable
		 * 
		 * 
		 * eUtils.doSwitchToFrame("pact3");
		 * eUtils.doSendKeys(heaven, "  is beautiful");
		 */
		
		
		
		/**
		 * 
		 * Main page > Frame1 > Frame2 > Frame3 --> Possible because all are nested frames and Frame1 is parent frame
		 * Main page > Frame1 --> yes
		 * Main page > Frame2 --> Not applicable(Because of nested frame)
		 * Main page > Frame3 --> Not applicable
		 * Frame1 > Frame 3 --> Not applicable
		 */
		
	}

}
