import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.springframework.beans.factory.InitializingBean;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Preconditions.checkNotNull;

public class WebDriverFactory implements InitializingBean {

	private Map<String, String> capabilities;
	private String seleniumServerUri;

	public WebDriver createInstance(String name) throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities(capabilities);

		desiredCapabilities.setCapability("name", name);

		URL remoteAddress = new URL(seleniumServerUri);
		
		RemoteWebDriver driver;
		
		if (remoteAddress.getHost().contains("saucelabs")) {
			driver = new SauceLabsDriverImpl(remoteAddress, desiredCapabilities);
		} else {
			driver = new RemoteWebDriver(remoteAddress, desiredCapabilities);
		}

		ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<WebDriver>();
		webDriverThreadLocal.set(driver);
		return ThreadGuard.protect(driver);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		checkNotNull(capabilities, "capabilities must be set");
		checkNotNull(seleniumServerUri, "seleniumServerUri must be set");
	}

	public void setCapabilities(Map<String, String> capabilities) {
		this.capabilities = capabilities;
	}

	public void setSeleniumServerUri(String seleniumServerUri) {
		this.seleniumServerUri = seleniumServerUri;
	}
}
