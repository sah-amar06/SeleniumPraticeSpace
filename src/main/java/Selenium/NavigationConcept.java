package Selenium;

public class NavigationConcept {

	public static void main(String[] args) {
		
		testNavigation();
	}
	
	public static void testNavigation() {
		
		
		BrowserUtils brUtils = new BrowserUtils();
		//ElementUtils eUtils = new ElementUtils(driver);
		
		brUtils.launchBrowser("chrome");
		brUtils.launchURL("https://www.google.com/");
		System.out.println(brUtils.getPageTitle());
		
		brUtils.navigateTo("https://sauce-demo.myshopify.com/");
		System.out.println(brUtils.getPageTitle());
		
		brUtils.goBack();
		System.out.println("Page title after navigating to  backward: "+brUtils.getPageTitle());
		brUtils.goForward();
		System.out.println("Page title after navigating to  backward: " +brUtils.getPageTitle());
		
		brUtils.refresh();
		
		brUtils.quitBrowser();
		
	}
	
	

}
