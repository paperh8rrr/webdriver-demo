import org.openqa.selenium.support.ui.Duration;

import java.util.concurrent.TimeUnit;

/*
	Copy of org.openqa.selenium.support.ui.Sleeper but it swallows exceptions
*/
public interface Sleeper {

	public static final Sleeper THREAD = new Sleeper() {
		@Override
		public void sleep(Duration duration) {
			try {
				Thread.sleep(duration.in(TimeUnit.MILLISECONDS));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		@Override
		public void sleep(int seconds) {
			sleep(new Duration(seconds, TimeUnit.SECONDS));
		}
	};

	void sleep(Duration duration);

	void sleep(int seconds);
}