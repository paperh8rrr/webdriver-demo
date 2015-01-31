package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WelcomeScreen extends PageObject {

	private static final By LOCATOR = By.className("welcome-screen");

	@FindBy(className = "compose-button")
	private WebElement composeButton;

	public WelcomeScreen(WebDriver driver) {
		super(driver);
	}

	public WelcomeScreen waitForVisibility() {
		waitFor(ExpectedConditions.visibilityOfElementLocated(LOCATOR));

		return this;
	}

	public WelcomeScreen clickComposeButton() {
		composeButton.click();

		return this;
	}
}