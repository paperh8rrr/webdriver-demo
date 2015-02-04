import com.google.common.base.Throwables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ThreadGuard;
import org.springframework.beans.factory.InitializingBean;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

public class WebDriverFactory implements InitializingBean {

	private Map<String, String> capabilities;
	private String seleniumServerUri;

	public WebDriver createInstance(String name) {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities(capabilities);

		desiredCapabilities.setCapability("name", name);

		URL remoteAddress;
		try {
			remoteAddress = new URL(seleniumServerUri);
		} catch (MalformedURLException e) {
			throw Throwables.propagate(e);
		}

		RemoteWebDriver driver;
		
		if (remoteAddress.getHost().contains("saucelabs")) {
			driver = new SauceLabsDriverImpl(remoteAddress, desiredCapabilities);
		} else {
			driver = new RemoteWebDriver(remoteAddress, desiredCapabilities);
		}

		return ThreadGuard.protect(driver);
	}

	@Override
	public void afterPropertiesSet() {
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
