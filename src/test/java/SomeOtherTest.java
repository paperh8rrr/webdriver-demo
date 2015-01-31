import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class SomeOtherTest extends WebDriverTest {
	
	@Test
	public void google() throws InterruptedException {
		driver.get("http://localhost:3000");
		
		Thread.sleep(5000); // pretend to do stuff

		assertEquals("WebDriver Demo App", driver.getTitle());
	}
}
