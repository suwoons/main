package seedu.address.model.event;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Event's location in TAble.
 * Guarantees: immutable; is valid as declared in {@link #isValidLocation(String)}
 */
public class EventLocation {
    /**
     * Represents an Event's location in the address book.
     * Guarantees: immutable; is valid as declared in {@link #isValidLocation(String)}
     */

    public static final String MESSAGE_CONSTRAINTS =
            "Locations should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The first character of the address must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String eventLocation;

    /**
     * Constructs a {@code EventLocation}.
     *
     * @param eventLocation A valid event location.
     */
    public EventLocation(String eventLocation) {
        requireNonNull(eventLocation);
        checkArgument(isValidLocation(eventLocation), MESSAGE_CONSTRAINTS);
        this.eventLocation = eventLocation;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidLocation(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return eventLocation;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof EventLocation // instanceof handles nulls
                && eventLocation.equals(((EventLocation) other).eventLocation)); // state check
    }

    @Override
    public int hashCode() {
        return eventLocation.hashCode();
    }

}
