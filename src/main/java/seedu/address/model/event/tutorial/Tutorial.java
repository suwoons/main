package seedu.address.model.event.tutorial;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.commons.util.TutorialUtil.checkStartEndTime;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import seedu.address.model.event.Location;
import seedu.address.model.mod.ModCode;

/**
 * Represents a Tutorial in TAble.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Tutorial {
    private ModCode modCode;
    private TutorialName tutorialName;
    private DayOfWeek weekday;
    private LocalTime beginTime;
    private LocalTime endTime;
    private Location location;
    // ArrayList<Student> enrolledStudents;

    public Tutorial(ModCode modCode, TutorialName tutorialName, DayOfWeek weekday,
                    LocalTime beginTime, LocalTime endTime, Location location) {

        requireAllNonNull(modCode, tutorialName, weekday, beginTime, endTime, location);
        this.modCode = modCode;
        this.tutorialName = tutorialName;
        this.weekday = weekday;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.location = location;
    }

    public ModCode getModCode() {
        return modCode;
    }

    public TutorialName getTutorialName() {
        return tutorialName;
    }

    public DayOfWeek getDay() {
        return weekday;
    }

    public LocalTime getBeginTime() {
        return beginTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Location getLocation() {
        return location;
    }

    public String getDayAndTime() {
        String day = weekday.toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        return day + " " + beginTime.format(formatter) + "-" + endTime.format(formatter);
    }

    /**
     * Returns true if both tutorials have the same module and tutorial name fields.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Tutorial)) {
            return false;
        }

        Tutorial otherTutorial = (Tutorial) other;
        return otherTutorial.getModCode().equals(getModCode())
                && otherTutorial.getTutorialName().equals(getTutorialName());
    }

    /**
     * Returns true if both consults timing clash, where the beginDateTime of the first consult is after the second
     * consult or vice versa.
     */
    public boolean timeClash(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Tutorial)) {
            return false;
        }

        Tutorial otherEvent = (Tutorial) other;
        return !checkStartEndTime(otherEvent.getEndTime(), getBeginTime())
                || !checkStartEndTime(otherEvent.getBeginTime(), getEndTime());
    }


    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(" Module Code: ")
                .append(getModCode())
                .append(" Tutorial Name: ")
                .append(getTutorialName())
                .append(" Day: ")
                .append(getDay())
                .append(" Begin TIme: ")
                .append(getBeginTime())
                .append(" End Time: ")
                .append(getEndTime())
                .append(" Location: ")
                .append(getLocation());
        return builder.toString();
    }
}
