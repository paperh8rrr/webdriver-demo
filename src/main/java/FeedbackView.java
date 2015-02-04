import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FeedbackView {
	private final WebDriver driver;
	private final WebDriverWait wait;

	public FeedbackView(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 5);
	}

	public void waitForVisibility() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("feedback-view")));
	}
}