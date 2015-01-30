import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.saucelabs.saucerest.SauceREST;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkState;

public class SauceLabsDriverImpl extends RemoteWebDriver implements SauceLabsDriver {

	private final SauceREST client;

	public SauceLabsDriverImpl(URL remoteAddress, DesiredCapabilities desiredCapabilities) {
		super(remoteAddress, desiredCapabilities);

		String userInfo = remoteAddress.getUserInfo();
		List<String> userInfoParts = Lists.newArrayList(userInfo.split(":"));

		checkState(userInfoParts.size() == 2, "Invalid UserInfo " + userInfo);

		client = new SauceREST(userInfoParts.get(0), userInfoParts.get(1));
	}

	@Override
	public void updateJobInfo(Map<String, Object> jobInfo) {
		String jobId = getSessionId().toString();

		client.updateJobInfo(jobId, jobInfo);
	}

	@Override
	public void updateJobInfo(String key, Object value) {
		Map<String, Object> jobInfo = Maps.newHashMap();
		jobInfo.put(key, value);

		updateJobInfo(jobInfo);
	}

	@Override
	public void breakpoint() {
		executeScript("sauce: break");
	}
}
