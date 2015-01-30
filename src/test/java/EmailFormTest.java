import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmailFormTest {

	private WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
	}

	@AfterMethod
	public void after() {
		driver.quit();
	}

	@Test
	public void test() {
		driver.get("http://localhost:3000");

		EmailForm emailForm = new EmailForm(driver);

		emailForm.clickComposeButton();
		emailForm.sendEmail("test@example.com", "WebDriver", "Automate everything!");
		emailForm.ensureConfirmation();
	}
}
