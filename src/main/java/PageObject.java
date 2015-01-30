import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class PageObject implements SearchContext {

	private static final int TIME_OUT_IN_SECONDS = 60;

	protected final WebDriver driver;
	protected final SearchContext searchContext;

	protected PageObject(WebDriver driver) {
		this(driver, driver);
	}

	public PageObject(WebDriver driver, SearchContext searchContext) {
		this.driver = driver;
		this.searchContext = searchContext;

		ElementLocatorFactory elementLocatorFactory = new DefaultElementLocatorFactory(searchContext);
		PageFactory.initElements(elementLocatorFactory, this);
	}

	public <V> V waitFor(final String message, Function<WebDriver, V> isTrue) {
		WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS) {
			@Override
			protected RuntimeException timeoutException(String timeoutMessage, Throwable lastException) {
				throw new AssertionError(Objects.firstNonNull(message, timeoutMessage), lastException);
			}
		};

		return wait.until(isTrue);
	}

	public <V> V waitFor(Function<WebDriver, V> isTrue) {
		return waitFor(null, isTrue);
	}

	protected boolean hasClass(WebElement webElement, String klass) {
		String classAtrribute = webElement.getAttribute("class");
		Iterable<String> classes = Splitter.on(" ").omitEmptyStrings().split(classAtrribute);

		return Iterables.contains(classes, klass);
	}

	public List<WebElement> findElements(By by) {
		return searchContext.findElements(by);
	}

	public WebElement findElement(By by) {
		return searchContext.findElement(by);
	}
}
