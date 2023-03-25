import java.time.LocalDate;

public class DateTime {
    public static void main(String[] args) {
        LocalDate toDay = LocalDate.now();
        System.out.println(toDay);
        System.out.println(toDay.getYear());
        System.out.println(toDay.getMonthValue());
    }
}
