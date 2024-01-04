import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class creates an event that repeats.
 * 
 * @author Jordan Rios
 */
public abstract class RepeatingEvent extends Event {

	private LocalDate firstOccurrence;
	private int repetitions;

	/**
	 * This constructs a repeating event.
	 * 
	 * @param eventName       The name of the event
	 * @param firstOccurrence The first time an event happens
	 * @param repetitions     How many times the event repeats
	 * @param startTime       What time the event starts
	 * @param endTime         What time the event ends
	 */
	public RepeatingEvent(String eventName, LocalDate firstOccurrence, int repetitions, LocalTime startTime,
			LocalTime endTime) {
		super(eventName, startTime, endTime);
		this.firstOccurrence = firstOccurrence;
		this.repetitions = repetitions;
		if (repetitions < 0) {
			throw new IllegalArgumentException("You cannot have a number less than zero.");
		}
	}

	/**
	 * This getter method returns the number of repetitions.
	 * 
	 * @return The number of repetitions
	 */
	public int getRepetitions() {
		return repetitions;
	}

	/**
	 * This getter method returns the date of the first occurrence.
	 * 
	 * @return The date of the first occurrence
	 */
	public LocalDate getFirstOccurrence() {
		return firstOccurrence;
	}

	@Override
	public String toString() {
		if (repetitions == 0) {
			return super.toString() + "repeating for all";
		} else {
			return super.toString() + "repeating for " + repetitions;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!super.equals(obj)) {
			return false;
		} else {
			RepeatingEvent other = (RepeatingEvent) obj;
			if (!firstOccurrence.equals(other.firstOccurrence)) {
				return false;
			} else if (repetitions != other.repetitions) {
				return false;
			} else {
				return true;
			}
		}
	}

	@Override
	public int hashCode() {
		return super.hashCode() + 1000 * repetitions + 10000 * firstOccurrence.hashCode();
	}

}
