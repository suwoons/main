package seedu.address.storage.tutorials;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.event.Location;
import seedu.address.model.event.tutorial.Tutorial;
import seedu.address.model.event.tutorial.TutorialName;

/**
 * Jackson-friendly version of {@link Tutorial}.
 */

public class JsonAdaptedTutorial {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Tutorial's %s field is missing!";
    private static final String INVALID_TIME_FORMAT = "Invalid time format!";
    private static final String INVALID_DAY_FORMAT = "Invalid day format!";

    private final String moduleName;
    private final String tutorialName;
    private final String weekday;
    private final String beginTime;
    private final String endTime;
    private final String location;

    /**
     * Constructs a {@code JsonAdaptedTutorial} with the given tutorial details.
     */
    @JsonCreator
    public JsonAdaptedTutorial(@JsonProperty("moduleName") String moduleName,
                              @JsonProperty("tutorialName") String tutorialName,
                              @JsonProperty("weekday") String weekday,
                              @JsonProperty("beginTime") String beginTime,
                              @JsonProperty("endTime") String endTime,
                              @JsonProperty("location") String location) {
        this.moduleName = moduleName;
        this.tutorialName = tutorialName;
        this.weekday = weekday;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.location = location;
    }

    /**
     * Converts a given {@code Tutorial} into this class for Jackson use.
     */
    public JsonAdaptedTutorial(Tutorial source) {
        moduleName = source.getModule();
        tutorialName = source.getTutorialName().toString();
        weekday = Integer.toString(source.getDay().getValue());
        beginTime = source.getBeginTime().toString();
        endTime = source.getEndTime().toString();
        location = source.getLocation().eventLocation;
    }

    /**
     * Converts this Jackson-friendly adapted tutorial object into the model's {@code Tutorial} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted tutorial.
     */
    public Tutorial toModelType() throws IllegalValueException {

        if (moduleName == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "MODULE_NAME"));
        }

        if (tutorialName == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "TUTORIAL_NAME"));
        }

        String modelModuleName;
        TutorialName modelTutorialName;

        modelModuleName = moduleName;
        modelTutorialName = new TutorialName(tutorialName);

        DayOfWeek modelWeekday;

        try {
            modelWeekday = DayOfWeek.of(Integer.parseInt(weekday));
        } catch (DateTimeException ex) {
            throw new IllegalValueException(INVALID_DAY_FORMAT);
        }


        if (beginTime == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "BEGIN_TIME"));
        }

        if (endTime == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "END_TIME"));
        }

        LocalTime modelBeginTime;
        LocalTime modelEndTime;

        try {
            modelBeginTime = LocalTime.parse(this.beginTime);
            modelEndTime = LocalTime.parse(this.endTime);
        } catch (DateTimeParseException ex) {
            throw new IllegalValueException(INVALID_TIME_FORMAT);
        }

        if (location == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "PLACE"));
        }

        final Location modelLocation = new Location(location);

        return new Tutorial(modelModuleName, modelTutorialName, modelWeekday, modelBeginTime, modelEndTime, modelLocation);
    }
}
