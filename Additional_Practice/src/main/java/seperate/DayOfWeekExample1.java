import java.time.*;

public class DayOfWeekExample1 {
  public static void main(String[] args) {
    LocalDate localDate = LocalDate.of(2017, Month.JANUARY, 25);
    DayOfWeek dayOfWeek = DayOfWeek.from(localDate);
    System.out.println(dayOfWeek.name());
  }
}
