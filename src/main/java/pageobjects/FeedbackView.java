package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FeedbackView extends PageObject {

	private static final By LOCATOR = By.className("feedback-view");

	public FeedbackView(WebDriver driver) {
		super(driver);
	}

	public FeedbackView waitForVisibility() {
		waitFor(ExpectedConditions.visibilityOfElementLocated(LOCATOR));

		return this;
	}
}