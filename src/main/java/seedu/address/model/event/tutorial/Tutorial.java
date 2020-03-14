package seedu.address.model.event.tutorial;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.DayOfWeek;
import java.time.LocalTime;

import seedu.address.model.event.Location;

/**
 * Represents a Tutorial in TAble.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Tutorial {
    private String module;
    private TutorialName tutorialName;
    private DayOfWeek weekday;
    private LocalTime beginTime;
    private LocalTime endTime;
    private Location location;
    // ArrayList<Student> enrolledStudents;

    // note to self: implement tutorialName object to replace the String, and replace module with Module object
    public Tutorial(String module, TutorialName tutorialName, DayOfWeek weekday,
                    LocalTime beginTime, LocalTime endTime, Location location) {

        requireAllNonNull(module, tutorialName, weekday, beginTime, endTime, location);
        this.module = module.toUpperCase();
        this.tutorialName = tutorialName;
        this.weekday = weekday;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.location = location;
    }

    public String getModuleCode() {
        return module;
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
        return otherTutorial.getModuleCode().equals(getModuleCode())
                && otherTutorial.getTutorialName().equals(getTutorialName());
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(" Module: ")
                .append(getModuleCode())
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
