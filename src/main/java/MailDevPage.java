import com.google.common.base.CharMatcher;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MailDevPage extends PageObject {
	private static final By LOCATOR = By.className("application-conatiner");

	public MailDevPage(WebDriver driver) {
		super(driver);
	}

	public MailDevPage waitForVisibility(){
		waitFor(ExpectedConditions.visibilityOfElementLocated(LOCATOR));

		sleep(1);

		return this;
	}

	// TODO this can fail if email takes some time to send. Maybe just keep searching and waiting?
	public void findEmail(final String subject) {
		WebElement searchInput = driver.findElement(By.className("search-input"));

		searchInput.sendKeys(subject);

		sleep(1);

		WebElement emailItem = waitFor(new ExpectedCondition<WebElement>() {
			final Predicate<WebElement> byTitle = new Predicate<WebElement>() {
				@Override
				public boolean apply(WebElement webElement) {
					String title = webElement.findElement(By.className("title")).getText();
					title = CharMatcher.WHITESPACE.trimFrom(title);
					return title.equals(subject);
				}
			};

			@Override
			public WebElement apply(WebDriver driver) {
				WebElement emailList = driver.findElement(By.className("email-list"));

				return Iterables.tryFind(emailList.findElements(By.className("email-item")), byTitle).orNull();
			}
		});

		emailItem.click();
	}

	private void sleep(int secs) {
		try { Thread.sleep(secs); }
		catch (InterruptedException e) {}
	}
}

