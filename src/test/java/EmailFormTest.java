import org.testng.annotations.Test;
import pageobjects.EmailForm;
import pageobjects.FeedbackView;
import pageobjects.WelcomeScreen;

public class EmailFormTest extends WebDriverTest {

	@Test
	public void test() {
		driver.get("http://localhost:3000");

		new WelcomeScreen(driver)
				.waitForVisibility()
				.clickComposeButton();
		
		new EmailForm(driver)
				.waitForVisibility()
				.sendEmail("test@example.com", "WebDriver", "Automate everything!");
		
		new FeedbackView(driver)
				.waitForVisibility();
		
		driver.get("http://localhost:1080");

		new MailDevPage(driver)
				.waitForVisibility()
				.findEmail("WebDriver");
	}
}
