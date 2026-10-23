
package MyTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest {

	@Test
	public void orangeHRMTitleTest() {
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("All in One"), "Unexpected OrangeHRM page title: " + title);
	}

	@Test
	public void orangeHRMURLTest() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("orangehrm"), "Current URL does not contain 'orangehrm': " + url);
	}
}
