import org.testng.annotations.Test;
import pageobjects.EmailForm;
import pageobjects.FeedbackView;
import pageobjects.WelcomeScreen;

import java.util.UUID;

public class EmailFormTest extends WebDriverTest {

	@Test
	public void test_workflow() {
		driver.get("http://localhost:3000");

		new WelcomeScreen(driver)
				.waitForVisibility()
				.clickComposeButton();

		String uuid = UUID.randomUUID().toString();
		new EmailForm(driver)
				.waitForVisibility()
				.sendEmail("test@example.com", uuid, "Automate everything!");
		
		new FeedbackView(driver)
				.waitForVisibility();
		
		driver.get("http://localhost:1080");

		new MailDevPage(driver)
				.waitForVisibility()
				.findEmail(uuid);
	}

	@Test
	public void test_back_button() {
		driver.get("http://localhost:3000");

		new WelcomeScreen(driver)
				.waitForVisibility()
				.clickComposeButton();

		new EmailForm(driver)
				.waitForVisibility()
				.clickBackButton();

		new WelcomeScreen(driver)
				.waitForVisibility();
	}
}
