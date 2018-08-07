import java.util.ArrayList;
import java.util.List;

public class TestArrayList {
	public static void main(String[] args) {
		List<String> s = new ArrayList<String>(20);
		s.add(5, "test");
		System.out.println(s.get(5));
	}
}
