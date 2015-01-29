import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirefoxDriverTest {

	private WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
	}

	@AfterMethod
	public void after() {
		driver.quit();
	}

	@Test
	public void test() {
		driver.get("http://localhost:3000");

		WebDriverWait wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("email-form")));

		WebElement composeButton = driver.findElement(By.className("compose-button"));

		composeButton.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("compose-mode")));

		WebElement toField = driver.findElement(By.name("to"));
		WebElement subjectField = driver.findElement(By.name("subject"));
		WebElement textField = driver.findElement(By.name("text"));
		WebElement sendButton = driver.findElement(By.className("send-button"));

		toField.sendKeys("test@example.com");
		subjectField.sendKeys("WebDriver");
		textField.sendKeys("Automate everything!");

		sendButton.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success-mode")));
	}
}
