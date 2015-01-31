import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FeedbackView {
	private final WebDriverWait wait;

	public FeedbackView(WebDriver driver) {
		this.wait = new WebDriverWait(driver, 5);

		PageFactory.initElements(driver, this);
	}

	public void waitForVisibility() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("feedback-view")));
	}
}