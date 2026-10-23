
package MyTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

	@Test
	public void googleTitleTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Google", "Google page title did not match");
	}

	@Test
	public void googleURLTest() {
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("google"), "Current URL does not contain 'google': " + url);
	}
}
