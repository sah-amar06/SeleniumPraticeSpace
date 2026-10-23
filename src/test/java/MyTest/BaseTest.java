package MyTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Selenium.BrowserException;


public class BaseTest {

    protected WebDriver driver;

    @Parameters({"browser", "url"})
    @BeforeTest
    public void setup(String browserName, String url) {
    	
    	switch(browserName.toLowerCase().trim()) {
    	case "chrome":
    		driver = new ChromeDriver();
    		break;
    	case "firefox":
    		driver = new FirefoxDriver();
    		break;
    	case "edge" :
    		driver = new EdgeDriver();
    		break;
    	case "safari" :
    		driver = new SafariDriver();
    		break;
    	default:
    		System.out.println("please enter the right browser: " +browserName);
    		throw new BrowserException("Wrong browser name");  	
    	}
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

