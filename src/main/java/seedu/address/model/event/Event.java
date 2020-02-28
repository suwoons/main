package seedu.address.model.event;


import seedu.address.model.person.Person;

import java.time.LocalDateTime;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * Represents an Event in TAble.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public abstract class Event {

    private String eventName;
    private LocalDateTime eventStartTime;
    private LocalDateTime eventEndTime;


    public Event(String eventName, LocalDateTime eventStartTime, LocalDateTime eventEndTime) {
        requireAllNonNull(eventName, eventStartTime, eventEndTime);
        this.eventName = eventName;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
    }

    public String getEventName() {
        return eventName;
    }

    public LocalDateTime getEventStartTime() {
        return eventStartTime;
    }

    public LocalDateTime getEventEndTime() {
        return eventEndTime;
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Event)) {
            return false;
        }

        Event otherEvent = (Event) other;
        return otherEvent.getEventName().equals(getEventName())
                && otherEvent.getEventStartTime().equals(getEventStartTime())
                && otherEvent.getEventEndTime().equals(getEventEndTime());
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getEventName())
                .append(" Start Time: ")
                .append(getEventStartTime())
                .append(" End Time: ")
                .append(getEventEndTime());
        return builder.toString();
    }

}
