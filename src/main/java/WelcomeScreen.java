import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomeScreen {
	private final WebDriver driver;
	private final WebDriverWait wait;

	public WelcomeScreen(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);
	}

	public void waitForVisibility() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("welcome-screen")));
	}
	
	public void clickComposeButton() {
		WebElement composeButton = driver.findElement(By.className("compose-button"));

		composeButton.click();
	}
}