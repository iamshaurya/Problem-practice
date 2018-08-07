import java.util.Map;

/**
 * 
 */

/**
 * @author Shaurya
 *
 */
public class MapWrapper {
	private Map<String, String> map;

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "MapWrapper [map=" + map + "]";
	}

}
