
package MyTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

	@Test
	public void googleTitleTest() {
		driver.get("https://www.google.com/");

		String title = driver.getTitle();

		Assert.assertEquals(title, "Google", "Google page title did not match");
	}

	@Test
	public void googleURLTest() {
		driver.get("https://www.google.com/");

		String url = driver.getCurrentUrl();

		Assert.assertTrue(url.contains("google"), "Current URL does not contain 'google': " + url);
	}
}
