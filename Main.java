import java.time.LocalDate;
import java.time.LocalTime;
public class Main {

	/**
	 * Demonstrate how to use Events program.
	 * 
	 * @param args does nothing
	 */
	public static void main(String[] args) {
		
	// Example: Creating a WeeklyEvent
        String eventName = "Workout";
        LocalDate firstOccurrence = LocalDate.of(2024, 1, 1); // Set the initial date
        int repetitions = 52; // Repeat the event for 52 weeks
        LocalTime startTime = LocalTime.of(7, 0); // Set the start time (7:00)
        LocalTime endTime = LocalTime.of(8, 0); // Set the end time (8:00)

        WeeklyEvent weeklyEvent = new WeeklyEvent(eventName, firstOccurrence, repetitions, startTime, endTime);

        // Print information about the event
        System.out.println("Created Weekly Event:");
        System.out.println(weeklyEvent);
        
        /**************************************************************************************************************/
        
        // Example: Creating a MonthlyEvent
        String eventName2 = "Haircut";
        LocalDate firstOccurrence2 = LocalDate.of(2024, 1, 15); // Set the initial date
        int repetitions2 = 12; // Repeat the event for 12 months
        LocalTime startTime2 = LocalTime.of(6, 0); // Set the start time
        LocalTime endTime2 = LocalTime.of(6, 20); // Set the end time

        MonthlyEvent monthlyEvent = new MonthlyEvent(eventName2, firstOccurrence2, repetitions2, startTime2, endTime2);

        // Print information about the event
        System.out.println("Created Monthly Event:");
        System.out.println(monthlyEvent);
     
        /**************************************************************************************************************/
        
        // Example: Creating a OneTimeEvent
        String eventName3 = "Interview";
        LocalDate date = LocalDate.of(2024, 1, 4); // Set the initial date
        LocalTime startTime3 = LocalTime.of(3, 0); // Set the start time (3:00)
        LocalTime endTime3 = LocalTime.of(4, 0); // Set the end time (4:00)

        OneTimeEvent oneTimeEvent = new OneTimeEvent(eventName3, date, startTime3, endTime3);

        // Print information about the event
        System.out.println("Created One Time Event:");
        System.out.println(oneTimeEvent);
       
        /**************************************************************************************************************/
        
        // Output:
        // Created Weekly Event:
        // Workout (07:00-08:00) repeating for 52 weeks starting on 2024-01-01
        // Created Monthly Event:
        // Haircut (06:00-06:20) repeating for 12 months starting on 2024-01-15
        // Created One Time Event:
        // Interview (03:00-04:00) on 2024-01-04
	}
}
