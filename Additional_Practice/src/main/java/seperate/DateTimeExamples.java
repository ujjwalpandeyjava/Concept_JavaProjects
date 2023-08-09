import java.util.Date;
import java.util.Calendar;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
class GetDayFromDate {
    public static void main(String[] args) {
        Date now = new Date();
        /*SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
        System.out.println(simpleDateformat.format(now));

        simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
        System.out.println(simpleDateformat.format(08/10/2019));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); // the day of the week in numerical format
		*/
		System.out.println( LocalDate.of(2019, 10, 3).getDayOfWeek().name());


	}
}