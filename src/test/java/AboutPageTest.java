import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AboutPageTest extends WebDriverTest {

	@Test
	public void test() {
		driver.get("http://localhost:3000/about");

		assertEquals(driver.getTitle(), "About");
	}
}
