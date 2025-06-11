package pandey.ujjwal.concepts.dateTime_Use;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Don't use:
 * java.util.Date, java.util.Calendar, java.util.GregorianCalendar,
 * java.util.TimeZone
 * 
 * Use:
 * 1. LocalDate: Represents a date without a time zone. •
 * 2. LocalTime: Represents a time without a date or time zone.
 * 3. LocalDateTime: Represents a date and time without a time zone.
 * 4. ZonedDateTime: Represents a date and time with a time zone.
 * 5. Instant: Represents an instantaneous point on the timeline, typically used
 * for machine timestamps.
 * 6. Duration: Represents a duration of time between two points in time.
 * 7. Period: Represents a period of time between two dates.
 * 8. DateTimeFormatter: Formats and parses dates and times.
 */
public class DateTime_NewWay {
	public static void main(String[] args) {
		// 1. LocalDate: Represents a date without a time zone.
		LocalDate date = LocalDate.of(2025, 3, 17);
		System.out.println("LocalDate: " + date);
		System.out.println("LocalDate.now(): " + LocalDate.now());

		// 2. LocalTime: Represents a time without a date or time zone.
		LocalTime time = LocalTime.of(13, 45, 30);
		System.out.println("LocalTime: " + time);
		System.out.println("LocalTime.now(): " + LocalTime.now());


		// 3. LocalDateTime: Represents a date and time without a time zone.
		LocalDateTime dateTime = LocalDateTime.of(2025, 3, 17, 13, 45, 30);
		System.out.println("LocalDateTime: " + dateTime);
		System.out.println("LocalDateTime.now(): " + LocalDateTime.now());

		// 4. ZonedDateTime: Represents a date and time with a time zone.
		ZonedDateTime zdt = ZonedDateTime.of(2025, 3, 17, 13, 45, 30, 0, ZoneId.of("America/New_York"));
		System.out.println("ZonedDateTime: " + zdt);
		System.out.println("ZonedDateTime.now(): " + ZonedDateTime.now());

		// 5. Instant: Represents an instantaneous point on the timeline, typically used
		// for machine timestamps.
		Instant instant = Instant.now();
		System.out.println("Instant: " + instant);

		// 6. Duration: Represents a duration of time between two points in time.
		Instant start = Instant.now();
		// Simulate some time passing
		Instant end = start.plusSeconds(10);
		Duration duration = Duration.between(start, end);
		System.out.println("Duration: " + duration);

		// 7. Period: Represents a period of time between two dates.
		LocalDate startDate = LocalDate.of(2025, 3, 17);
		LocalDate endDate = startDate.plusDays(10);
		Period period = Period.between(startDate, endDate);
		System.out.println("Period: " + period);

		// 8. DateTimeFormatter: Formats and parses dates and times.
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatted = dateTime.format(formatter);
		System.out.println("Formatted LocalDateTime: " + formatted);
	}
}
