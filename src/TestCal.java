import java.util.Calendar;

/**
 * 
 */

/**
 * @author Shaurya
 *
 */
public class TestCal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.roll(Calendar.DATE, true);
		System.out.println(cal.getTime());
		cal.roll(Calendar.DATE, false);
		cal.roll(Calendar.DATE, false);
		cal.roll(Calendar.DATE, false);
		System.out.println(cal.getTime());

	}

}
