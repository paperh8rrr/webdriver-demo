import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailForm {
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

	public void ensureConfirmation() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success-mode")));
	}
}