import java.util.Calendar;

/**
 * 
 */

/**
 * @author Shaurya
 *
 */
public class TestTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar cal1 = Calendar.getInstance();
		cal1.set(Calendar.MINUTE, 15);
		cal1.set(Calendar.SECOND, 0);
		cal1.set(Calendar.MILLISECOND, 0);
		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.MINUTE, 16);
		cal2.set(Calendar.SECOND, 0);
		cal2.set(Calendar.MILLISECOND, 0);
		System.out.println(cal2.getTimeInMillis()-cal1.getTimeInMillis());

	}

}
