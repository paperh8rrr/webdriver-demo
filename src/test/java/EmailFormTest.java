import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class EmailFormTest {

	private WebDriver driver;

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		URL remoteAddress = new URL("http://localhost:4444/wd/hub");
		driver = new RemoteWebDriver(remoteAddress, capabilities);
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

		driver.findElement(By.className("compose-button")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("compose-mode")));

		driver.findElement(By.name("to")).sendKeys("test@example.com");
		driver.findElement(By.name("subject")).sendKeys("WebDriver");
		driver.findElement(By.name("text")).sendKeys("Automate everything!");;
		driver.findElement(By.className("send-button")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("success-mode")));
	}
}
