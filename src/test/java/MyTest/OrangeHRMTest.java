
package MyTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest {

	@Test(priority =1)
	public void orangeHRMTitleTest() {
		driver.get("https://orangehrm.com/");
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("All in One"), "Unexpected OrangeHRM page title: " + title);
	}

	@Test(priority =2)
	public void orangeHRMURLTest() {
		driver.get("https://orangehrm.com/");
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("orangehrm"), "Current URL does not contain 'orangehrm': " + url);
	}
}
