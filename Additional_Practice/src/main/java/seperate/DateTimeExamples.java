package seperate;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

class DateTimeExamples {
	public static void main(String[] args) {
//		G	Era designator	AD
//		y	Year in four digits	2001
//		M	Month in year	July or 07
//		d	Day in month	10
//		h	Hour in A.M./P.M. (1~12)	12
//		H	Hour in day (0~23)	22
//		m	Minute of hour (30)
//		s	Second of minute (55)
//		S	Millisecond	(223334)
//		E	Day of week	(Tuesday)
//		D	Day of year	360
//		F	Day of week in month	2 (second Wed. in July)
//		w	Week of year (40)
//		W	Week of month (1)
//		a	A.M./P.M.
//		k	Hour in 24 hr (1~24)
//		K	Hour in 12 hr (0~11)
//		z	Time zone	Eastern Standard Time
//		'	Escape for text	Delimiter
//		"	Single quote	`

		SimpleDateFormat day = new SimpleDateFormat("E EEEE");
		SimpleDateFormat date = new SimpleDateFormat("k h");

		Date now = new Date();
		System.out.println(day.format(now));
		System.out.println(date.format(now));

		DayOfWeek sunday = LocalDate.parse("2016-06-12").getDayOfWeek();
		int twelve = LocalDate.parse("2016-06-12").getDayOfMonth();
		System.out.println(sunday.toString() + twelve);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
		System.out.println(simpleDateFormat.format(new Date()));

		// Libibrary calendar
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println(LocalDate.of(2019, 10, 3).getDayOfWeek().name());
	}
}