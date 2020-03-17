package seedu.address.commons.core;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_STUDENT_DISPLAYED_INDEX = "The student index provided is invalid";
    public static final String MESSAGE_STUDENTS_LISTED_OVERVIEW = "%1$d students listed!";

    public static final String MESSAGE_INVALID_CONSULT_DISPLAYED_INDEX = "The consult index provided is invalid";
    public static final String MESSAGE_CONSULT_BEGIN_TIME_BEFORE_END_TIME = "The Begin Date Time of the consult is "
            + "before the End Date Time of the consult.";
    public static final String MESSAGE_CONSULT_TIMING_CLASH = "This consult's timing clash with another pre-existing"
            + " consult.";

    public static final String MESSAGE_INVALID_TUTORIAL_DISPLAYED_INDEX = "The tutorial index provided is invalid";
    public static final String MESSAGE_TUTORIAL_BEGIN_TIME_BEFORE_END_TIME = "The Begin Time of the tutorial is before "
            + "the End Time of the tutorial.";
    public static final String MESSAGE_TUTORIAL_TIMING_CLASH = "This tutorial's timing clash with another pre-existing"
            + " tutorial.";

    public static final String MESSAGE_INVALID_MOD_DISPLAYED_INDEX = "The module index provided is invalid";
    public static final String MESSAGE_INVALID_REMINDER_DISPLAYED_INDEX = "The reminder index provided is invalid";
    public static final String MESSAGE_REMINDER_ALREADY_DONE = "This reminder is already done!";
}
