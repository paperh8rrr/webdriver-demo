import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	}

	private class EmailForm {
		private final WebDriverWait wait;

		@FindBy(className = "compose-button")
		private WebElement composeButton;

		@FindBy(name = "to")
		private WebElement toField;

		@FindBy(name= "subject")
		private WebElement subjectField;

		@FindBy(name= "text")
		private WebElement textField;

		@FindBy(className = "send-button")
		private WebElement sendButton;

		public EmailForm(WebDriver driver) {
			this.wait = new WebDriverWait(driver, 5);

			PageFactory.initElements(driver, this);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("email-form")));
		}

		public void clickComposeButton() {
			composeButton.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("compose-mode")));
		}

		public void sendEmail(String to, String subject, String text) {
			toField.sendKeys(to);
			subjectField.sendKeys(subject);
			textField.sendKeys(text);

			sendButton.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success-mode")));

		}
	}
}
