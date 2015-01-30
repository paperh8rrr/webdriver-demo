import java.util.Map;

public interface SauceLabsDriver {
	void updateJobInfo(Map<String, Object> jobInfo);

	void updateJobInfo(String key, Object value);

	void breakpoint();

}
