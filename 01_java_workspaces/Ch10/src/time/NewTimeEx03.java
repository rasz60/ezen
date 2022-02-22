package time;

import java.time.*;
import java.time.temporal.*;
import static java.time.DayOfWeek.*;
import static java.time.temporal.TemporalAdjusters.*;

class DayAfterTomorrow implements TemporalAdjuster {
	@Override
	public Temporal adjustInto(Temporal temporal) {
		return temporal.plus(2, ChronoUnit.DAYS);
	}
		
}

public class NewTimeEx03 {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalDate date = today.with(new DayAfterTomorrow());
		
		print(today);
		print(date);
		
		print(today.with(firstDayOfNextMonth()));
		print(today.with(firstDayOfMonth()));
		print(today.with(lastDayOfMonth()));
		print(today.with(firstInMonth(TUESDAY)));
		print(today.with(lastInMonth(TUESDAY)));
		print(today.with(previous(TUESDAY)));
		print(today.with(previousOrSame(TUESDAY)));
		print(today.with(nextOrSame(TUESDAY)));
		print(today.with(next(TUESDAY)));
		print(today.with(dayOfWeekInMonth(4, TUESDAY)));
	}
	
	static void print(Object obj) {
		System.out.println(obj);
	}

}
