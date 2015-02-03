import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EmailFormTest {

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
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.className("compose-button")).click();

		driver.findElement(By.name("to")).sendKeys("test@example.com");
		driver.findElement(By.name("subject")).sendKeys("WebDriver");
		driver.findElement(By.name("text")).sendKeys("Automate everything!");;
		driver.findElement(By.className("send-button")).click();

		driver.findElement(By.className("feedback-view"));
	}
}
