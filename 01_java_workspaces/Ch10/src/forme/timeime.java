package forme;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class timeime {

	public static void main(String[] args) {
		
	LocalDate date1 = LocalDate.now();
	LocalTime time1 = LocalTime.now();
	
	LocalDate date2 = LocalDate.of(1991, 3, 7);
	LocalTime time2 = LocalTime.of(06, 30, 41);
	
	
	LocalDateTime dateNtime1 = LocalDateTime.of(date1, time1);
	LocalDateTime dateNtime2 = LocalDateTime.of(date2, time2);
	
	System.out.println(dateNtime1);
	System.out.println(dateNtime2);
	
	Period pe = Period.between(date2, date1);
	Duration du = Duration.between(time2, time1);
		
	System.out.println(pe);
	System.out.println(du);
//	LocalDateTime dateNtime3 = LocalDateTime.of(pe.getYears(), pe.getMonths(), pe.getDays(), du.getUnits());
	}	
}
