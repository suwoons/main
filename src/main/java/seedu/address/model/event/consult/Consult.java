package seedu.address.model.event.consult;

import static seedu.address.commons.core.Messages.MESSAGE_BEGIN_TIME_BEFORE_END_TIME;
import static seedu.address.commons.util.AppUtil.checkArgument;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.commons.util.ConsultUtil.checkStartEndDateTime;

import java.time.LocalDateTime;

import seedu.address.model.event.Location;
//import seedu.address.model.person.Person;

/**
 * Represents a Consultation in TAble.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Consult {

    private LocalDateTime beginDateTime;
    private LocalDateTime endDateTime;
    private Location location;


    public Consult(LocalDateTime beginDateTime, LocalDateTime endDateTime,
                   Location location) {
        requireAllNonNull(beginDateTime, endDateTime, location);
        checkArgument(checkStartEndDateTime(beginDateTime, endDateTime),
                MESSAGE_BEGIN_TIME_BEFORE_END_TIME);
        this.beginDateTime = beginDateTime;
        this.endDateTime = endDateTime;
        this.location = location;
    }

    public LocalDateTime getBeginDateTime() {
        return beginDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
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
        return otherEvent.getBeginDateTime().equals(getBeginDateTime())
                && otherEvent.getEndDateTime().equals(getEndDateTime());
    }

    /**
     * Returns true if both consults timing clash, where the beginDateTime of the first consult is after the second
     * consult or vice versa.
     */
    public boolean timeClash(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Consult)) {
            return false;
        }

        Consult otherEvent = (Consult) other;
        return !checkStartEndDateTime(otherEvent.getEndDateTime(), getBeginDateTime())
                || !checkStartEndDateTime(otherEvent.getBeginDateTime(), getEndDateTime());
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(" Start Time: ")
                .append(getBeginDateTime())
                .append(" End Time: ")
                .append(getEndDateTime())
                .append(" Place: ")
                .append(getPlace());
        return builder.toString();
    }

}
