import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmailForm extends PageObject {

	private static final By LOCATOR = By.className("email-form");

	private static interface ViewState {
		By COMPOSE = By.className("compose-mode");
		By SUCCESS = By.className("success-mode");
	}

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
		super(driver);
	}

	public EmailForm waitForVisibility() {
		waitFor(ExpectedConditions.visibilityOfElementLocated(LOCATOR));

		return this;
	}

	public EmailForm clickComposeButton() {
		composeButton.click();

		waitFor(ExpectedConditions.visibilityOfElementLocated(ViewState.COMPOSE));

		return this;
	}

	public EmailForm sendEmail(String to, String subject, String text) {
		toField.sendKeys(to);
		subjectField.sendKeys(subject);
		textField.sendKeys(text);

		sendButton.click();

		return this;
	}

	public EmailForm ensureConfirmation() {
		waitFor(ExpectedConditions.visibilityOfElementLocated(ViewState.SUCCESS));

		return this;
	}
}