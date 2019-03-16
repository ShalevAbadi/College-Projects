import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarAdapter{
	
	Calendar calendar = new GregorianCalendar();

	int getHour() {
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	int getMinute() {
		return calendar.get(Calendar.MINUTE);
	}

	int getSecond() {
		return calendar.get(Calendar.SECOND);
	}
}
