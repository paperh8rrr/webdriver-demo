import com.beust.jcommander.internal.Maps;
import com.google.common.collect.Lists;
import com.saucelabs.saucerest.SauceREST;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkState;

public class SauceLabsDriver extends RemoteWebDriver {

	private final SauceREST client;

	public SauceLabsDriver(URL remoteAddress, DesiredCapabilities desiredCapabilities) {
		super(remoteAddress, desiredCapabilities);

		String userInfo = remoteAddress.getUserInfo();
		List<String> userInfoParts = Lists.newArrayList(userInfo.split(":"));

		checkState(userInfoParts.size() == 2, "Invalid UserInfo " + userInfo);

		client = new SauceREST(userInfoParts.get(0), userInfoParts.get(1));
	}

	public void updateJobInfo(Map<String, Object> jobInfo) {
		String jobId = getSessionId().toString();

		client.updateJobInfo(jobId, jobInfo);
	}

	public void updateJobInfo(String key, Object value) {
		Map<String, Object> jobInfo = Maps.newHashMap();
		jobInfo.put(key, value);

		updateJobInfo(jobInfo);
	}

	public void breakpoint() {
		executeScript("sauce: break");
	}
}
