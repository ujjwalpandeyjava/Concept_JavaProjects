package pandey.ujjwal.concepts.dateTime_Use;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

/**
 * Don't use:
 * java.util.Date, java.util.Calendar, java.util.GregorianCalendar,
 * java.util.TimeZone
 * 
 * Use:
 * 0. Use Instant, OffsetDateTime, or ZonedDateTime (with UTC) save data in DB.
 * 
 * 1. LocalDate: Represents a date without a time zone.
 * 2. LocalTime: Represents a time without a date or time zone.
 * 3. LocalDateTime: Represents a date and time without a time zone.
 * 4. Instant: Represents an instantaneous point on the timeline, typically used
 * for machine timestamps.
 * 5. OffsetDateTime:
 * 6. ZonedDateTime: Represents a date and time with a time zone.
 * 7. Duration: Represents a duration of time between two points in time.
 * 8. Period: Represents a period of time between two dates.
 * 9. DateTimeFormatter: Formats and parses dates and times.
 */
public class DateTime_NewWay {
	private static final Logger LOGGER = LoggerFactory.getLogger(DateTime_NewWay.class);

	public static void main(String[] args) {
		localDateEg();
		localTimeEg();
		localDateTimeEg();
		instantEg();
		offSetDateTimeEg();
		zonedDateTimeEg();
		durationUseEg();
		dateTimeFormatterEg();
	}

	/**
	 * LocalDate: Represents a date without a time zone.
	 * 
	 * eg: 2025-03-17
	 */
	private static void localDateEg() {
		LOGGER.info("LocalDate example ===");

		LOGGER.info("LocalDate.now(): {}\n", LocalDate.now());
		LocalDate date = LocalDate.of(2025, 3, 17);
		LOGGER.info("LocalDate: " + date);

		LocalDate startDate = LocalDate.of(2025, 3, 17);
		LocalDate endDate = startDate.plusDays(10);
		Period period = Period.between(startDate, endDate);
		LOGGER.info("Period: {}\n", period);
	}

	/**
	 * LocalTime: Represents a time without a date or time zone.
	 * 
	 * eg: 13:45:30
	 */
	private static void localTimeEg() {
		LOGGER.info("LocalTime example ===");

		LocalTime time = LocalTime.of(13, 45, 30);
		LOGGER.info("LocalTime: " + time);
		LOGGER.info("LocalTime.now(): {}\n", LocalTime.now());
	}

	/**
	 * LocalDateTime: Represents a date and time without a time zone.
	 * 
	 * eg: 2025-03-17T13:45:30
	 */
	private static void localDateTimeEg() {
		LOGGER.info("LocalDateTime example ===");

		LocalDateTime dateTime = LocalDateTime.of(2025, 3, 17, 13, 45, 30);
		LOGGER.info("LocalDateTime: {}", dateTime);
		LOGGER.info("LocalDateTime.now(): {}\n", LocalDateTime.now());
	}

	/**
	 * Instant: Instantaneous point on the timeline, used for machine timestamps.
	 * eg: 2025-06-11T11:44:40.835801Z
	 */
	private static void instantEg() {
		LOGGER.info("Instant example ===");

		Instant instant = Instant.now();
		LOGGER.info("Instant: {}\n", instant);
	}

	/**
	 * OffsetDateTime: Date-time with an offset from UTC in ISO-8601
	 * eg - 2025-06-11T17:14:40.849581+05:30
	 */
	private static void offSetDateTimeEg() {
		LOGGER.info("OffsetDateTime example ===");

		// Current time with system default offset
		OffsetDateTime now = OffsetDateTime.now();
		LOGGER.info("OffsetDateTime.now(): {}", now);

		// Create with specific offset (e.g., UTC+5:30)
		OffsetDateTime custom = OffsetDateTime.now(ZoneOffset.ofHoursMinutes(5, 30));
		LOGGER.info("OffsetDateTime custom: {}", custom);

		// Convert to Instant (for saving in DB)
		LOGGER.info("Instant (UTC): {}\n", now.toInstant());
	}

	/**
	 * ZonedDateTime: Represents a date and time with a time zone.
	 * eg: 2025-06-11T17:14:40.851780+05:30[Asia/Kolkata]
	 */
	private static void zonedDateTimeEg() {
		LOGGER.info("ZonedDateTime example ===");

		ZonedDateTime zdt = ZonedDateTime.of(2025, 3, 17, 13, 45, 30, 0, ZoneId.of("America/New_York"));
		LOGGER.info("ZonedDateTime: {}", zdt);
		LOGGER.info("ZonedDateTime.now(): {}\n", ZonedDateTime.now());
	}

	/**
	 * Duration: Duration of time between two passing points.
	 */
	private static void durationUseEg() {
		LOGGER.info("Duration example ===");

		Instant start = Instant.now();
		Instant end = start.plusSeconds(10);
		Duration duration = Duration.between(start, end);
		LOGGER.info("Duration: {}\n", duration.getSeconds());
	}

	/**
	 * DateTimeFormatter: Formats and parses dates and times.
	 */
	private static void dateTimeFormatterEg() {
		LOGGER.info("DateTimeFormatter example ===");

		LocalDateTime dateTime = LocalDateTime.of(2025, 3, 17, 13, 45, 30);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
		String formatted = dateTime.format(formatter);
		LOGGER.info("Formatted LocalDateTime: {}\n", formatted);
	}
}
