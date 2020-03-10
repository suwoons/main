package seedu.address.model.event.consult;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDateTime;

import seedu.address.model.event.Location;
//import seedu.address.model.person.Person;

/**
 * Represents a Consultation in TAble.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Consult {

    private LocalDateTime consultBeginDateTime;
    private LocalDateTime consultEndDateTime;
    private Location location;


    public Consult(LocalDateTime consultBeginDateTime, LocalDateTime consultEndDateTime,
                 Location location) {
        requireAllNonNull(consultBeginDateTime, consultEndDateTime, location);
        this.consultBeginDateTime = consultBeginDateTime;
        this.consultEndDateTime = consultEndDateTime;
        this.location = location;
    }

    public LocalDateTime getConsultBeginDateTime() {
        return consultBeginDateTime;
    }

    public LocalDateTime getConsultEndDateTime() {
        return consultEndDateTime;
    }

    public Location getPlace() {
        return location;
    }

    /**
     * Returns true if both consults have the same Date and Time, as the TA cannot attend both.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Consult)) {
            return false;
        }

        Consult otherEvent = (Consult) other;
        return otherEvent.getConsultBeginDateTime().equals(getConsultBeginDateTime())
                && otherEvent.getConsultEndDateTime().equals(getConsultEndDateTime());
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(" Start Time: ")
                .append(getConsultBeginDateTime())
                .append(" End Time: ")
                .append(getConsultEndDateTime())
                .append(" Place: ")
                .append(getPlace());
        return builder.toString();
    }
}
