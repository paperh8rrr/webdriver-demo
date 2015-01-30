import org.testng.annotations.Test;

public class EmailFormTest extends WebDriverTest {

	@Test
	public void test() {
		driver.get("http://localhost:3000");

		new EmailForm(driver)
				.waitForVisibility()
				.clickComposeButton()
				.sendEmail("test@example.com", "WebDriver", "Automate everything!")
				.ensureConfirmation();

		driver.get("http://localhost:1080");

		new MailDevPage(driver)
				.waitForVisibility()
				.findEmail("WebDriver");
	}
}
