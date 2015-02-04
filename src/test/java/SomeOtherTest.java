import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class SomeOtherTest extends WebDriverTest {
	
	@Test
	public void google() {
		driver.get("http://localhost:3000");


		try {
			Sleeper.SYSTEM_SLEEPER.sleep(new Duration(5, TimeUnit.SECONDS));
		} catch (InterruptedException e) {}

		assertEquals("WebDriver Demo App", driver.getTitle());
	}
}
