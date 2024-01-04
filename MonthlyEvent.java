import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class makes an event that is monthly and can repeat.
 * 
 * @author Jordan Rios
 */
public class MonthlyEvent extends RepeatingEvent {

	/**
	 * This constructor makes a monthly event that can repeat.
	 * 
	 * @param eventName       The name of the event
	 * @param firstOccurrence The first time this event occurr's
	 * @param repetitions     The number of times this event happens
	 * @param startTime       The time the event starts
	 * @param endTime         The time the event ends
	 */
	public MonthlyEvent(String eventName, LocalDate firstOccurrence, int repetitions, LocalTime startTime, LocalTime endTime) {
		super(eventName, firstOccurrence, repetitions, startTime, endTime);
	}

	/**
	 * Determines wether or not the event occurs on a given day.
	 * 
	 * @param when The day it might occur on.
	 * @return     True if the event occurs on that day, or false otherwise.
	 */
	@Override
	public boolean isOnDay(LocalDate when) {
		// Check if the event has repetitions.
		if (super.getRepetitions() != 0) {
			// Check if the days of the month match.
			if (super.getFirstOccurrence().getDayOfMonth() != when.getDayOfMonth()) {
				return false;
			}
			// Check if the provided date is before the intial occurance.
			if (when.isBefore(super.getFirstOccurrence())) {
				return false;
			}
			// Check if the provided date is after the last occurance (inital occurance + repetitions).
			if (when.isAfter(super.getFirstOccurrence().plusMonths(getRepetitions()))) {
				return false;
			} else {
				return true;
			}
		}
		// If the event does not have repetitions.
		else {
			// Check if the days of the month match.
			if (super.getFirstOccurrence().getDayOfMonth() != when.getDayOfMonth()) {
				return false;
			}
			// Check if the provided date is before the intial occurance.
			if (when.isBefore(super.getFirstOccurrence())) {
				return false;
			} else {
				return true;
			}
		}
	}

	// Returns a String representaion of this object.
	@Override
	public String toString() {
		return super.toString() + " months starting on " + super.getFirstOccurrence();
	}
}
