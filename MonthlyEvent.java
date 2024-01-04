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
	public MonthlyEvent(String eventName, LocalDate firstOccurrence, int repetitions, LocalTime startTime,
			LocalTime endTime) {
		super(eventName, firstOccurrence, repetitions, startTime, endTime);
	}

	@Override
	public boolean isOnDay(LocalDate when) {
		if (super.getRepetitions() != 0) {
			if (super.getFirstOccurrence().getDayOfMonth() != when.getDayOfMonth()) {
				return false;
			}
			if (when.isBefore(super.getFirstOccurrence())) {
				return false;
			}
			if (when.isAfter(super.getFirstOccurrence().plusMonths(getRepetitions()))) {
				return false;
			} else {
				return true;
			}
		}

		else {
			if (super.getFirstOccurrence().getDayOfMonth() != when.getDayOfMonth()) {
				return false;
			}
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
		if (super.getRepetitions() == 0) {
			return super.toString() + " months starting on " + super.getFirstOccurrence();
		} else {
			return super.toString() + " months starting on " + super.getFirstOccurrence();
		}
	}
}
