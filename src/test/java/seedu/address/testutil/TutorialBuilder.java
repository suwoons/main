package seedu.address.testutil;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.event.Location;
import seedu.address.model.event.tutorial.Tutorial;
import seedu.address.model.event.tutorial.TutorialName;
import seedu.address.model.mod.ModCode;

/**
 * A utility class to help with building Tutorial objects.
 */
public class TutorialBuilder {
    public static final String DEFAULT_MODCODE = "CS2103";
    public static final String DEFAULT_TUTORIAL_NAME = "T02";
    public static final String DEFAULT_DAY = "3";
    public static final String DEFAULT_BEGIN_TIME = "15:00";
    public static final String DEFAULT_END_TIME = "17:00";
    public static final String DEFAULT_LOCATION = "SR1";

    private ModCode modCode;
    private TutorialName tutorialName;
    private DayOfWeek day;
    private LocalTime beginTime;
    private LocalTime endTime;
    private Location location;

    public TutorialBuilder() throws ParseException {
        modCode = ParserUtil.parseModCode(DEFAULT_MODCODE);
        tutorialName = ParserUtil.parseTutorialName(DEFAULT_TUTORIAL_NAME);
        day = ParserUtil.parseDay(DEFAULT_DAY);
        beginTime = ParserUtil.parseTime(DEFAULT_BEGIN_TIME);
        endTime = ParserUtil.parseTime(DEFAULT_END_TIME);
        location = new Location(DEFAULT_LOCATION);
    }

    /**
     * Initializes the TutorialBuilder with the data of {@code tutorialToCopy}.
     */
    public TutorialBuilder(Tutorial tutorialToCopy) {
        modCode = tutorialToCopy.getModCode();
        tutorialName = tutorialToCopy.getTutorialName();
        day = tutorialToCopy.getDay();
        beginTime = tutorialToCopy.getBeginTime();
        endTime = tutorialToCopy.getEndTime();
        location = tutorialToCopy.getLocation();
    }

    /**
     * Sets the {@code modCode} of the {@code Tutorial} that we are building.
     */
    public TutorialBuilder withModCode(String modCode) {
        this.modCode = new ModCode(modCode);
        return this;
    }

    /**
     * Sets the {@code tutorialName} of the {@code Tutorial} that we are building.
     */
    public TutorialBuilder withTutorialName(String tutorialName) {
        this.tutorialName = new TutorialName(tutorialName);
        return this;
    }

    /**
     * Sets the {@code day} of the {@code Tutorial} that we are building.
     */
    public TutorialBuilder withDay(String day) {
        this.day = DayOfWeek.of(Integer.parseInt(day));
        return this;
    }

    /**
     * Sets the {@code BeginTime} of the {@code Tutorial} that we are building.
     */
    public TutorialBuilder withBeginTime(String beginTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm a");
        this.beginTime = LocalTime.parse(beginTime, formatter);
        return this;
    }

    /**
     * Sets the {@code EndTime} of the {@code Tutorial} that we are building.
     */
    public TutorialBuilder withEndTime(String endTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        this.endTime = LocalTime.parse(endTime, formatter);
        return this;
    }

    /**
     * Sets the {@code Location} of the {@code Tutorial} that we are building.
     */
    public TutorialBuilder withLocation(String location) {
        this.location = new Location(location);
        return this;
    }


    public Tutorial build() {
        return new Tutorial(modCode, tutorialName, day, beginTime, endTime, location);
    }

}
