import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
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
		String user = System.getProperty("user");
		String key = System.getProperty("key");

		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", Platform.XP);
		caps.setCapability("version", "29");

		String url = String.format("http://%s:%s@ondemand.saucelabs.com:80/wd/hub", user, key);
		URL remoteAddress = new URL(url);

		driver = new RemoteWebDriver(remoteAddress, caps);
	}

	@AfterMethod
	public void after() {
		driver.quit();
	}

	@Test
	public void test() {
		driver.get("http://localhost:3000");

		WebDriverWait wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("welcome-screen")));

		driver.findElement(By.className("compose-button")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("email-form")));

		driver.findElement(By.name("to")).sendKeys("test@example.com");
		driver.findElement(By.name("subject")).sendKeys("WebDriver");
		driver.findElement(By.name("text")).sendKeys("Automate everything!");;
		driver.findElement(By.className("send-button")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("feedback-view")));
	}
}
