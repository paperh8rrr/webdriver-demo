import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EmailFormTest extends WebDriverTest {

	@Test
	@Parameters({ "to", "subject", "text" })
	public void test(String to, String subject, String text) {
		driver.get("http://localhost:3000");

		EmailForm emailForm = new EmailForm(driver).waitForVisibility();

		emailForm
				.clickComposeButton();

		Sleeper.THREAD.sleep(2);

		emailForm
				.sendEmail(to, subject, text)
				.ensureConfirmation();
	}
}
