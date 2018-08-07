import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class TestDate {

	public static void main(String[] args) {
int x = 100;
double y = 100.1;
//boolean a = (x=y);
	}

	public static Date getFirstTimeOfDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.AM_PM, Calendar.AM);

		return cal.getTime();
	}

	public static List<Date> getDateRange(Date startDate, Date endDate) {
		List<Date> dateRange = new ArrayList<Date>();
		/*
		 * SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
		 * String inputString1 = "23 01 1997"; String inputString2 =
		 * "27 04 1997";
		 */

		// Date date1 = myFormat.parse(inputString1);
		// Date date2 = myFormat.parse(inputString2);
		startDate.setHours(0);
		startDate.setMinutes(0);
		startDate.setSeconds(0);
		endDate.setHours(23);
		endDate.setMinutes(59);
		endDate.setSeconds(59);
		long diff = endDate.getTime() - startDate.getTime();
		long daysDiff = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		System.out.println("Days: " + daysDiff);
		dateRange.add(startDate);
		daysDiff--;
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		while (daysDiff >= 0) {
			cal.roll(Calendar.DATE, true);
			dateRange.add(cal.getTime());
			daysDiff--;
		}
		return dateRange;
	}

	public static long getDaysDiff(Date startDate, Date endDate) {
		long diff = endDate.getTime() - startDate.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public static Date getLastDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR, 11);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.AM_PM, Calendar.PM);
		return cal.getTime();
	}

	public static String extractTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(date);
	}

	public static String getDurationInFormat(BigDecimal duration) {
		int t = duration.intValue();
		int h = t / 60;
		int m = t % 60;
		return h + " hr " + m + " min ";

	}

}
