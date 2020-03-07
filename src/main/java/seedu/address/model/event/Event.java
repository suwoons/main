package seedu.address.model.event;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDateTime;

/**
 * Represents an Event in TAble.
 * Guarantees: details are present and not null, field values are validated.
 */
public abstract class Event {

    private LocalDateTime eventBeginDateTime;
    private LocalDateTime eventEndDateTime;
    private Location location;


    public Event(LocalDateTime eventBeginDateTime, LocalDateTime eventEndDateTime,
                 Location location) {
        requireAllNonNull(eventBeginDateTime, eventEndDateTime, location);
        this.eventBeginDateTime = eventBeginDateTime;
        this.eventEndDateTime = eventEndDateTime;
        this.location = location;
    }

    public LocalDateTime getEventBeginDateTime() {
        return eventBeginDateTime;
    }

    public LocalDateTime getEventEndDateTime() {
        return eventEndDateTime;
    }

    public Location getLocation() {
        return location;
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
        return otherEvent.getEventBeginDateTime().equals(getEventBeginDateTime())
                && otherEvent.getEventEndDateTime().equals(getEventEndDateTime())
                && otherEvent.getLocation().equals(getLocation());
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(" Start Time: ")
                .append(getEventBeginDateTime())
                .append(" End Time: ")
                .append(getEventEndDateTime())
                .append(" Location: ")
                .append(getLocation());
        return builder.toString();
    }

}
