import org.testng.annotations.Test;

public class EmailFormTest extends WebDriverTest {

	@Test
	public void test() {
		driver.get("http://localhost:3000");

		EmailForm emailForm = new EmailForm(driver).waitForVisibility();

		emailForm
				.clickComposeButton();

		Sleeper.THREAD.sleep(2);

		emailForm
				.sendEmail("test@example.com", "WebDriver", "Automate everything!")
				.ensureConfirmation();
	}
}
