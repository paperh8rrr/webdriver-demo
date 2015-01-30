import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

@ContextConfiguration(locations = {"classpath:context.xml"})
@TestExecutionListeners(
		listeners = {DependencyInjectionTestExecutionListener.class},
		inheritListeners = false
)
public abstract class WebDriverTest extends AbstractTestNGSpringContextTests {

	protected WebDriver driver;

	@Autowired
	private WebDriverFactory webDriverFactory;

	@BeforeClass(alwaysRun = true, dependsOnMethods = "springTestContextPrepareTestInstance")
	protected void beforeClass(ITestContext context) throws MalformedURLException {
		driver = webDriverFactory.createInstance(context.getName());
	}

	@AfterMethod(alwaysRun = true, dependsOnMethods = "springTestContextAfterTestMethod")
	protected void afterMethod(ITestResult result) {
		if (driver instanceof SauceLabsDriver) {
			((SauceLabsDriver) driver).updateJobInfo("passed", Boolean.valueOf(result.isSuccess()));
		}
	}

	@AfterClass(alwaysRun = true, dependsOnMethods = "springTestContextAfterTestClass")
	protected void afterClass() {
		driver.quit();
	}
}
