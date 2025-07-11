import java.time.*;
import java.time.format.*;

public class Date{

public static void main (String[] args){

//LocalDate date = localDate.of(2025,5,22); 
//just like String if i don't assign nothing changes.

//localDate date = date.plusDays(10).plusWeeks(1);

//LocalDate startDate = LocalDate.of(2023,1,1);
 //LocalDate endDate = LocalDate.of(2023,4,1);

//period gap = period.between(startDate,endDate);
//System.out.println("Gap in months: + gap.getMonthss()");//output:3 months

//LocalDateTime current = LocalDateTime.now();
DateTimeFormatter x =
DateTimeFormatter.ofPattern("MM dd yyyy");
LocalDate x = LocalDate.parse("05 22 2025", x);

System.out.println(y);

}
}