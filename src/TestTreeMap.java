import java.util.Calendar;
import java.util.Date;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 
 */

/**
 * @author Shaurya
 *
 */
public class TestTreeMap {
	public static void main(String[] args) {
		Calendar cal1 = Calendar.getInstance();
		cal1.roll(Calendar.DATE, false);
		Calendar cal2 = Calendar.getInstance();
		cal2.roll(Calendar.DATE, false);
		cal2.roll(Calendar.DATE, false);
		Calendar cal3 = Calendar.getInstance();
		Calendar cal4 = Calendar.getInstance();
		cal4.roll(Calendar.DATE, true);
		Calendar cal5 = Calendar.getInstance();
		cal5.roll(Calendar.DATE, true);
		cal5.roll(Calendar.DATE, true);
		cal5.roll(Calendar.DATE, true);
		cal5.roll(Calendar.DATE, true);
		Calendar cal6 = Calendar.getInstance();
		cal6.roll(Calendar.MINUTE, true);
		
		TreeMap<Date, Boolean> map = new TreeMap<>();
		map.put(cal1.getTime(), true);
		map.put(cal2.getTime(), true);
		map.put(cal3.getTime(), true);
		map.put(cal4.getTime(), true);
		map.put(cal5.getTime(), true);
		map.put(cal6.getTime(), true);

		for(Entry<Date, Boolean> e: map.entrySet()){
			System.out.println(e.getKey());
		}
		System.out.println("last date : "+map.lastEntry().getKey());
	}

}
