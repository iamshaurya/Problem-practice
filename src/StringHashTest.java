import java.util.ArrayList;
import java.util.List;

public class StringHashTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1234);
		convertToDelimetedString(list);
	}
	
	public static void convertToDelimetedString(List<Integer> brandSlaTargetList) {
		StringBuilder sb = new StringBuilder();
		sb.append(brandSlaTargetList.get(0));
		for(int i=1;i<brandSlaTargetList.size();i++ ){
			sb.append(",");
			sb.append(brandSlaTargetList.get(i));
		}
		System.out.println(sb.toString());
	}

}
