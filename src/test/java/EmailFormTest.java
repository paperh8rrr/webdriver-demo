import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EmailFormTest extends WebDriverTest {

	@Test
	@Parameters({ "to", "subject", "text" })
	public void test(String to, String subject, String text) {
		driver.get("http://localhost:3000");

		new EmailForm(driver)
				.waitForVisibility()
				.clickComposeButton()
				.sendEmail(to, subject, text)
				.ensureConfirmation();
	}
}
