package dateUse;

import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

class DateTimeExamples {
	public static void main(String[] args) throws ParseException {
// 		https://jenkov.com/tutorials/java-internationalization/simpledateformat.html

//		G	Era designator (before christ, after christ)
//		y	Year (e.g. 12 or 2012). Use either yy or yyyy.
//		M	Month in year. Number of M's determine length of format (e.g. MM, MMM or MMMMM)
//		d	Day in month. Number of d's determine length of format (e.g. d or dd)
//		h	Hour of day, 1-12 (AM / PM) (normally hh)
//		H	Hour of day, 0-23 (normally HH)
//		m	Minute in hour, 0-59 (normally mm)
//		s	Second in minute, 0-59 (normally ss)
//		S	Millisecond in second, 0-999 (normally SSS)
//		E	Day in week (e.g Monday, Tuesday etc.)
//		D	Day in year (1-366)
//		F	Day of week in month (e.g. 1st Thursday of December)
//		w	Week in year (1-53)
//		W	Week in month (0-5)
//		a	AM / PM marker
//		k	Hour in day (1-24, unlike HH's 0-23)
//		K	Hour in day, AM / PM (0-11)
//		z	Time Zone
//		'	Escape for text delimiter
//		'	Single quote

//		Pattern				Example
//		dd-MM-yy			31-01-12
//		dd-MM-yyyy			31-01-2012
//		MM-dd-yyyy			01-31-2012
//		yyyy-MM-dd			2012-01-31
//		yyyy-MM-dd HH:mm:ss	2012-01-31 23:59:59
//		yyyy-MM-dd HH:mm:ss.SSS			2012-01-31 23:59:59.999
//		yyyy-MM-dd HH:mm:ss.SSSZ		2012-01-31 23:59:59.999+0100
//		EEEEE MMMMM yyyy HH:mm:ss.SSSZ	Saturday November 2012 10:45:42.720+0100

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

		/* Libibrary calendar */
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println(LocalDate.of(2019, 10, 3).getDayOfWeek().name());

		Date d1 = new Date();
		System.out.println("Current date: " + d1);
		Date d2 = new Date(2323223232L);
		System.out.println("Date represented: " + d2);

		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");

		String date2 = simpleDateFormat2.format(new Date());
		System.out.println(date2);

		/* Format Date Into StringBuffer */
		StringBuffer stringBuffer = new StringBuffer();

		SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
		simpleDateFormat3.format(now, stringBuffer, new FieldPosition(0));
		System.out.println(stringBuffer);

		/* Parsing Dates */
		SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("== " + simpleDateFormat4.parse("2023-08-15"));
		System.out.println("== " + simpleDateFormat4.parse("2023-15-08"));

		/* Creating a SimpleDateFormat For a Specific Locale */
		SimpleDateFormat sdf5 = new SimpleDateFormat("EEEEE dd MMMMM yyyy HH:mm:ss.SSSZ", new Locale("da", "DK"));
		System.out.println(sdf5.format(new Date()));

		/* DateFormatSymbols : customize the date symbols, for a specific Locale */
		Locale locale = new Locale("en", "UK");
		DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
		dateFormatSymbols.setWeekdays(new String[] { "Unused", "vikas Sunday", "Savi Monday", "Nites Tuesday",
				"Vics Wednesday", "BBM Thursday", "Sur Friday", "Rahu Saturday", });
		SimpleDateFormat simpleDateFormat6 = new SimpleDateFormat("EEEEE MMMMM yyyy", dateFormatSymbols);
		System.out.println(simpleDateFormat6.format(new Date()));

		/* Can set more date formatting symbols on the DateFormatSymbols instance */
		DateFormatSymbols format = new DateFormatSymbols(new Locale("en", "US"));
		String[] daysName = format.getWeekdays();

		System.out.println("Original: " + Arrays.toString(daysName) + " Length: " + daysName.length);

		dateFormatSymbols.setWeekdays(new String[] { "11", "12", "13", "14", "15", "16", "17", "18", "19" });
		// After 7 it will iterate to 1st day
		String[] modifiedDays = dateFormatSymbols.getWeekdays();
		System.out.println("Modified: " + Arrays.toString(modifiedDays) + " Length: " + modifiedDays.length);
//		dateFormatSymbols.setAmPmStrings();
//		dateFormatSymbols.setEras();
//		dateFormatSymbols.setLocalPatternChars();
//		dateFormatSymbols.setMonths();
//		dateFormatSymbols.setShortMonths();
//		dateFormatSymbols.setShortWeekdays();
//		dateFormatSymbols.setZoneStrings();

		/* Custom Time Zone */
		var sdf7 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");
		sdf7.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
		System.out.println(sdf7.format(now));
		sdf7.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		System.out.println(sdf7.format(now));
		sdf7.setTimeZone(TimeZone.getTimeZone("America/Ottawa"));
		System.out.println(sdf7.format(now));
		sdf7.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		System.out.println(sdf7.format(now));

		/* ISO Date Format */ // Use '' to add string
		var sdf8 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		System.out.println(sdf8.format(now));

		/* Convert between time zones using the java.util.Calendar */
		System.out.println("=== Time zone setting  ===");
		Calendar calendar1 = new GregorianCalendar();

//		System.out.println("\n\n" + Arrays.toString(TimeZone.getAvailableIDs()) + "\n\n");

		calendar1.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		System.out.println("Delhi: " + calendar1.get(Calendar.HOUR_OF_DAY) + ":" + calendar1.get(Calendar.MINUTE));
		System.out.println("Delhi: " + calendar1.getTimeInMillis());

		calendar1.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
		System.out.println("UTC: " + calendar1.get(Calendar.HOUR_OF_DAY) + ":" + calendar1.get(Calendar.MINUTE));
		System.out.println("UTC: " + calendar1.getTimeInMillis());

		calendar1.setTimeZone(TimeZone.getTimeZone("Europe/Paris"));
		System.out.println("Paris: " + calendar1.get(Calendar.HOUR_OF_DAY) + ":" + calendar1.get(Calendar.MINUTE));
		System.out.println("Paris: " + calendar1.getTimeInMillis());

	}
}