package seedu.address.commons.core;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The person index provided is invalid";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";

    public static final String MESSAGE_INVALID_CONSULT_DISPLAYED_INDEX = "The consult index provided is invalid";
    public static final String MESSAGE_INVALID_TUTORIAL_DISPLAYED_INDEX = "The tutorial index provided is invalid";
    public static final String MESSAGE_BEGIN_TIME_BEFORE_END_TIME = "The Begin Date Time of the consult is before "
            + "the End Date Time of the consult.";
    public static final String MESSAGE_CONSULT_TIMING_CLASH = "This consult's timing clash with another pre-existing"
            + " consult.";
    public static final String MESSAGE_INVALID_MOD_DISPLAYED_INDEX = "The module index provided is invalid";
}
