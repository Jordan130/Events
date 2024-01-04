import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class makes an event that is weekly and can repeat.
 * 
 * @author Jordan Rios
 */
public class WeeklyEvent extends RepeatingEvent {

	/**
	 * This constructor makes a weekly event that can repeat.
	 * 
	 * @param eventName       The name of the event
	 * @param firstOccurrence The first time this event occurr's
	 * @param repetitions     The number of times this event happens
	 * @param startTime       The time the event starts
	 * @param endTime         The time the event ends
	 */
	public WeeklyEvent(String eventName, LocalDate firstOccurrence, int repetitions, LocalTime startTime,
			LocalTime endTime) {
		super(eventName, firstOccurrence, repetitions, startTime, endTime);
	}

	@Override
	public boolean isOnDay(LocalDate when) {
		if (super.getRepetitions() != 0) {
			if (super.getFirstOccurrence().getDayOfWeek() != when.getDayOfWeek()) {
				return false;
			}
			if (when.isBefore(super.getFirstOccurrence())) {
				return false;
			}
			if (when.isAfter(super.getFirstOccurrence().plusWeeks(getRepetitions()))) {
				return false;
			} else {
				return true;
			}
		}

		else {
			if (super.getFirstOccurrence().getDayOfWeek() != when.getDayOfWeek()) {
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
		return super.toString() + " weeks starting on " + super.getFirstOccurrence();	
	}
}
