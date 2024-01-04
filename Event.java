import java.time.LocalDate;
import java.time.LocalTime;

/**
 * A thing that you want to do.
 * 
 * @author Chad Hogg
 * @author Jordan Rios
 */
public abstract class Event {
	
	// Class invariants:
	// 1: startTime is before endTime

	/** The name of the event. */
	private String eventName;
	/** The time when the event starts. */
	private LocalTime startTime;
	/** The time when the event ends. */
	private LocalTime endTime;
	
	/**
	 * Constructs a new event.
	 * 
	 * @param eventName The name of the new event.
	 * @param startTime The time when the new event starts.
	 * @param endTime The time when the new event ends.  This must be after startTime.
	 */
	public Event(String eventName, LocalTime startTime, LocalTime endTime) {
		if(!endTime.isAfter(startTime)) {
			throw new IllegalArgumentException("The endTime must be after the startTime.");
		}
		this.eventName = eventName;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	/**
	 * Gets the name of the event.
	 * 
	 * @return The name of the event.
	 */
	public String getEventName() {
		return eventName; 
	}
	
	/**
	 * Gets the time when the event starts.
	 * 
	 * @return The time when the event starts.
	 */
	public LocalTime getStartTime() {
		return startTime; 
	}
	
	/**
	 * Gets the time when the event ends.
	 * 
	 * @return The time when the event ends.
	 */
	public LocalTime getEndTime() {
		return endTime; 
	}
	
	/**
	 * Determines whether or not the event occurs on a given day.
	 * 
	 * @param when The day it might occur on.
	 * @return True if the event occurs on that day, or false otherwise.
	 */
	public abstract boolean isOnDay(LocalDate when);

	// Returns a String represenation of this object.
	@Override
	public String toString() {
		return eventName + " (" + startTime + "-" + endTime + ") ";
	}

	// Compares two objects for equality.
	@Override
	public boolean equals(Object obj) {
		boolean result;
		if(obj == null) {
			result = false;
		}
		else if(!this.getClass().equals(obj.getClass())) {
			result = false;	
		}
		else {
			Event other = (Event)obj;
			if(!eventName.equals(other.eventName)) {
				result = false;
			}
			else if(!startTime.equals(other.startTime) ) {
				result = false;
			}
			else if(!endTime.equals(other.endTime)) {
				result = false;
			}
			else {
				result = true;
			}
		}
		return result;
	}

	// Returns a hashcode value that respresents this object.
	@Override
	public int hashCode() {
		return 1 * eventName.hashCode() + 10 * startTime.hashCode() + 100 * endTime.hashCode();
	}
}
