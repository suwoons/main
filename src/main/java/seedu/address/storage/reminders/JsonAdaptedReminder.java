package seedu.address.storage.reminders;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.reminder.Reminder;

/**
 * Jackson-friendly version of {@link Reminder}.
 */
class JsonAdaptedReminder {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Reminder's %s field is missing!";
    private static final String INVALID_DATE_TIME_FORMAT = "Invalid date or time format!";

    private final String description;
    private final String date;
    private final String time;

    /**
     * Constructs a {@code JsonAdaptedReminder} with the given reminder details.
     */
    @JsonCreator
    public JsonAdaptedReminder(@JsonProperty("description") String description,
                              @JsonProperty("date") String date,
                              @JsonProperty("time") String time) {
        this.description = description;
        this.date = date;
        this.time = time;
    }

    /**
     * Converts a given {@code Reminder} into this class for Jackson use.
     */
    public JsonAdaptedReminder(Reminder source) {
        description = source.getDescription();
        date = source.getDate().toString();
        time = source.getTime().toString();
    }

    /**
     * Converts this Jackson-friendly adapted reminder object into the model's {@code Reminder} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted reminder.
     */
    public Reminder toModelType() throws IllegalValueException {

        if (description == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "DESCRIPTION"));
        }

        if (date == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "DATE"));
        }

        if (time == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "TIME"));
        }

        String modelDescription;
        LocalDate modelDate;
        LocalTime modelTime;

        modelDescription = description;

        try {
            modelDate = LocalDate.parse(this.date);
            modelTime = LocalTime.parse(this.time);
        } catch (DateTimeParseException ex) {
            throw new IllegalValueException(INVALID_DATE_TIME_FORMAT);
        }

        return new Reminder(modelDescription, modelDate, modelTime, false);
    }
}
