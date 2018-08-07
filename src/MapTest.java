import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		MapWrapper wrap = new MapWrapper();
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		wrap.setMap(map);
		System.out.println(wrap.toString());
	}

}
