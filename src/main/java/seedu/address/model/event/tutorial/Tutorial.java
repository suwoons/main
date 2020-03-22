package seedu.address.model.event.tutorial;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.commons.util.TutorialUtil.checkStartEndTime;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import seedu.address.model.event.Location;
import seedu.address.model.mod.ModCode;
import seedu.address.model.student.MatricNumber;
import seedu.address.model.student.Student;

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
    private ArrayList<MatricNumber> enrolledStudents;
    private ArrayList<ArrayList<Boolean>> studentAttendance;

    /**
     * Constructor for Tutorial to initialize an empty Tutorial class with no enrolled students, and
     * empty attendance sheet.
     * @param modCode Module code of the tutorial
     * @param tutorialName Name of the tutorial
     * @param weekday Day of the week that the tutorial takes place
     * @param beginTime Time that the tutorial begins
     * @param endTime Time that the tutorial ends
     * @param location Location of the tutorial
     */
    public Tutorial(ModCode modCode, TutorialName tutorialName, DayOfWeek weekday,
                    LocalTime beginTime, LocalTime endTime, Location location) {

        requireAllNonNull(modCode, tutorialName, weekday, beginTime, endTime, location);
        this.modCode = modCode;
        this.tutorialName = tutorialName;
        this.weekday = weekday;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.location = location;
        this.enrolledStudents = new ArrayList<MatricNumber>();

        ArrayList<ArrayList<Boolean>> studentAttendance = new ArrayList<ArrayList<Boolean>>();
        for (int i = 0; i < 13; i++) {
            ArrayList<Boolean> week = new ArrayList<Boolean>();
            studentAttendance.add(week);
        }
        this.studentAttendance = studentAttendance;
    }

    /**
     * Adds a new student to the list based on the provided {@code matric}
     * and adds a new row in the attendance sheet for the student for all the weeks, default as false.
     *
     */
    public void setEnrolledStudents(MatricNumber matric) {
        enrolledStudents.add(matric);
        for (int i = 0; i < 13; i++) {
            ArrayList<Boolean> week = studentAttendance.get(i);
            week.add(false);
        }
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

    public ArrayList<MatricNumber> getEnrolledStudents() {
        return enrolledStudents;
    }

    public ArrayList<ArrayList<Boolean>> getAttendance() {
        return studentAttendance;
    }

    /**
     * Returns the attendance of a tutorial for a specified week
     * @param week Specified week of attendance to be retrieved
     * @return ArrayList of attendance represented by Boolean for the specified week
     */
    public ArrayList<Boolean> getAttendanceWeek(int week) {
        return studentAttendance.get(week);
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

        // same tutorial as long as same modCode and tutorialName
        Tutorial otherTutorial = (Tutorial) other;
        return otherTutorial.getModCode().equals(getModCode())
                && otherTutorial.getTutorialName().equals(getTutorialName());
    }

    /**
     * Returns true if both tutorials timing clash, where the tutorials are set in periods
     * which overlap.
     */
    public boolean timeClash(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Tutorial)) {
            return false;
        }

        Tutorial otherTutorial = (Tutorial) other;
        return (!checkStartEndTime(otherTutorial.getBeginTime(), getEndTime())
                && !checkStartEndTime(getBeginTime(), otherTutorial.getBeginTime()))
                || (!checkStartEndTime(otherTutorial.getEndTime(), getBeginTime())
                && !checkStartEndTime(getEndTime(), otherTutorial.getEndTime()));
    }

    /**
     * Returns true if the other tutorial already contains the specified student.
     */
    public boolean tutorialStudentClash(Student student) {
        boolean hasDuplicateStudent = false;
        for (MatricNumber matric : this.getEnrolledStudents()) {
            if (matric.equals(student.getMatricNumber())) {
                hasDuplicateStudent = true;
                break;
            }
        }
        return hasDuplicateStudent;
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
