package seedu.address.model.reminder;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * Represents a Reminder in TAble.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Reminder {

    // Identity fields
    private final String description;
    private final LocalDate date;
    private final LocalTime time;

    // Data fields
    private final boolean done;

    /**
     * Every field must be present and not null.
     */
    public Reminder(String description, LocalDate date, LocalTime time, boolean done) {
        requireAllNonNull(description, date, time);
        this.description = description;
        this.date = date;
        this.time = time;
        this.done = done;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public boolean getDone() {
        return done;
    }

    /**
     * Returns true if both reminders have the same identity.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Reminder)) {
            return false;
        }

        Reminder otherReminder = (Reminder) other;
        return otherReminder.getDescription().equals(getDescription())
                && otherReminder.getDate().equals(getDate())
                && otherReminder.getTime().equals(getTime());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(description, date, time);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getDescription())
                .append(" Date: ")
                .append(getDate())
                .append(" Time: ")
                .append(getTime())
                .append(" Done: ")
                .append(getDone() ? "Yes" : "No");
        return builder.toString();
    }

}
