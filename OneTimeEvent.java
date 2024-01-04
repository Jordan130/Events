import java.time.LocalDate;
import java.time.LocalTime;

/**
 * This class creates an event that only occurs once.
 * 
 * @author Jordan Rios
 *
 */
public class OneTimeEvent extends Event {

	private LocalDate date;

	/**
	 * This constructor creates a one time event.
	 * 
	 * @param eventName The name of the event
	 * @param date      The date of the event
	 * @param startTime The time the event starts
	 * @param endTime   The time the event ends
	 */
	public OneTimeEvent(String eventName, LocalDate date, LocalTime startTime, LocalTime endTime) {
		super(eventName, startTime, endTime);
		this.date = date;
	}

	@Override
	public boolean isOnDay(LocalDate when) {
		if (date.equals(when)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return super.toString() + "on " + date;
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		} else {
			OneTimeEvent other = (OneTimeEvent) obj;
			if (!date.equals(other.date)) {
				return false;
			} else {
				return true;
			}
		}
	}

	@Override
	public int hashCode() {
		return super.hashCode() + 1000 * date.hashCode();
	}

}
