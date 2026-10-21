package TestNGPratice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	
	@BeforeSuite
	public void connectWithDatabase() {
		System.out.println("Before Suite-- Database connection");
	}
	
	@BeforeTest
	public void createUser() {
		System.out.println("Before test -- Prepare test data");
	}
	
	@BeforeClass
	public void launchBrowser() {
		System.out.println("Before class -- launch the browser");
	}
	
	
	@BeforeMethod
	public void login() {
		System.out.println("Before method -- login to the application");
	}
	
	@Test
	public void searchProduct() {
		System.out.println("Test -- search the product");
	}
	
	@AfterMethod
	public void logOut() {
		System.out.println("After method - logout to the application");
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("After class -- Close the browser");
	}
	
	@AfterTest
	public void deleteUser() {
		System.out.println("After test -- test data cleanup");
	}
	
	@AfterSuite
	public void disconnectDB() {
		System.out.println("After suite -- disconnect from the Database");
	}
}
