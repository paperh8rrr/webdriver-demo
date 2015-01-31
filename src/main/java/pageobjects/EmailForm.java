package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmailForm extends PageObject {

	private static final By LOCATOR = By.className("email-form");

	@FindBy(name = "to")
	private WebElement toField;

	@FindBy(name= "subject")
	private WebElement subjectField;

	@FindBy(name= "text")
	private WebElement textField;

	@FindBy(className = "send-button")
	private WebElement sendButton;

	@FindBy(className = "back-button")
	private WebElement backButton;

	public EmailForm(WebDriver driver) {
		super(driver);
	}

	public EmailForm waitForVisibility() {
		waitFor(ExpectedConditions.visibilityOfElementLocated(LOCATOR));

		return this;
	}
	
	public EmailForm clickBackButton() {
		backButton.click();
	}

	public EmailForm sendEmail(String to, String subject, String text) {
		toField.sendKeys(to);
		subjectField.sendKeys(subject);
		textField.sendKeys(text);

		sendButton.click();

		return this;
	}
}