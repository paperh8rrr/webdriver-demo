import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailForm {
	private final WebDriver driver;
	private final WebDriverWait wait;

	public EmailForm(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("email-form")));
	}

	public void clickComposeButton() {
		WebElement composeButton = driver.findElement(By.className("compose-button"));

		composeButton.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("compose-mode")));
	}

	public void sendEmail(String to, String subject, String text) {
		WebElement toField = driver.findElement(By.name("to"));
		WebElement subjectField = driver.findElement(By.name("subject"));
		WebElement textField = driver.findElement(By.name("text"));
		WebElement sendButton = driver.findElement(By.className("send-button"));

		toField.sendKeys(to);
		subjectField.sendKeys(subject);
		textField.sendKeys(text);

		sendButton.click();
	}

	public void ensureConfirmation() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success-mode")));
	}
}