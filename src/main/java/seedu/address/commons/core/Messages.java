package seedu.address.commons.core;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX = "The student index provided is invalid.";
    public static final String MESSAGE_STUDENTS_LISTED_OVERVIEW = "%1$d students listed!";

    public static final String MESSAGE_INVALID_CONSULT_DISPLAYED_INDEX = "The consult index provided is invalid.";
    public static final String MESSAGE_CONSULT_BEGIN_TIME_BEFORE_END_TIME = "The Begin Date Time of the consult is "
            + "after the End Date Time of the consult.";
    public static final String MESSAGE_CONSULT_TIMING_CLASH = "This consult's timing clash with another pre-existing"
            + " consult.";
    public static final String MESSAGE_CONSULT_DIFFERENT_DATE = "The start and end date of the consult is different.";

    public static final String MESSAGE_INVALID_TUTORIAL_DISPLAYED_INDEX = "The tutorial index provided is invalid.";
    public static final String MESSAGE_INVALID_TUTORIAL_STUDENT_INDEX = "The student index provided is invalid.";
    public static final String MESSAGE_TUTORIAL_BEGIN_TIME_BEFORE_END_TIME = "The Begin Time of the tutorial is before "
            + "the End Time of the tutorial.";
    public static final String MESSAGE_TUTORIAL_TIMING_CLASH = "This tutorial's timing clash with another pre-existing"
            + " tutorial.";
    public static final String MESSAGE_INVALID_WEEK = "The week specified is invalid. Please enter a value between"
            + " 1 and 13 (inclusive).";

    public static final String MESSAGE_MISSING_MOD = "The module code provided does not exist in TAble.";
    public static final String MESSAGE_INVALID_MODLINK_INDEX = "This index does not correspond to a ModLink in TAble.";

    public static final String MESSAGE_REMINDER_PAST_REMINDER = "The reminder must not be in the past.";
    public static final String MESSAGE_INVALID_REMINDER_DISPLAYED_INDEX = "The reminder index provided is invalid.";
    public static final String MESSAGE_REMINDER_ALREADY_DONE = "This reminder is already done!";
    public static final String MESSAGE_REMINDERS_LISTED_OVERVIEW = "%1$d reminders listed!";
    public static final String MESSAGE_REMINDERS_EMPTY_DESCRIPTION = "Description cannot be empty!";
    public static final String MESSAGE_REMINDER_INVALID_SNOOZE_DURATION = "Duration to be snoozed by must be a "
            + "positive integer.";

    public static final String NO_CALENDAR_OPEN_MESSAGE = "There is no calendar window that is currently open.";
}
