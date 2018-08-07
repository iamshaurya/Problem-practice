import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class TestRedisDel {

	public static void main(String[] args) {
		String in = "4512125,4512126,4510506,4512128,4512130,4512546,4512146,4512587,4512147,4512148,4512501,4512169,4512170,4512178,4512204,4511503,4512205,4512230,4512483,4512341,4512400,4511885,4511886,4512437,4511889,4512522,4511677,4510023,4510024,4511992,4512527,4512035,4512041,4512069,4512070,4512071,4512092,4512093,4512538";
		String[] inArr = in.split(",");
		for(String a: inArr){
			String delCommand = "redis-cli -a 742c8bb70bed479eac5c646df3e0b37f735b78c5 -n 6 KEYS \"BRAND_USER_SCOPE*NUM*\" | xargs redis-cli -a 742c8bb70bed479eac5c646df3e0b37f735b78c5 -n 6 DEL"; 
			System.out.println(delCommand.replaceFirst("NUM", a));
		}
		
		
		Field[] fs = TestSet.class.getDeclaredFields();
		for(Field f: fs){
			System.out.println(f.getName());
		}
		
	}

}
