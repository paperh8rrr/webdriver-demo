import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomeScreen {
	private final WebDriverWait wait;

	@FindBy(className = "compose-button")
	private WebElement composeButton;

	public WelcomeScreen(WebDriver driver) {
		this.wait = new WebDriverWait(driver, 5);

		PageFactory.initElements(driver, this);
	}

	public void waitForVisibility() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("welcome-screen")));
	}

	public void clickComposeButton() {
		composeButton.click();
	}
}