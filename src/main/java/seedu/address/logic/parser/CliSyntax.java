package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_MATRICNUMBER = new Prefix("m/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");
    public static final Prefix PREFIX_REMARK = new Prefix("r/");

    public static final Prefix PREFIX_PLACE = new Prefix("place/");
    public static final Prefix PREFIX_STUDENT = new Prefix("student/");
    public static final Prefix PREFIX_INDEX = new Prefix("INDEX (must be a positive integer)");


    /* Consult definitions */
    public static final Prefix PREFIX_CONSULT_BEGIN_DATE_TIME = new Prefix("beginDateTime/");
    public static final Prefix PREFIX_CONSULT_END_DATE_TIME = new Prefix("endDateTime/");

    /* Tutorial definitions */
    public static final Prefix PREFIX_TUTORIAL_NAME = new Prefix("tutorialName/");
    public static final Prefix PREFIX_TUTORIAL_WEEKDAY = new Prefix("day/");
    public static final Prefix PREFIX_TUTORIAL_BEGIN_TIME = new Prefix("beginTime/");
    public static final Prefix PREFIX_TUTORIAL_END_TIME = new Prefix("endTime/");
    public static final Prefix PREFIX_TUTORIAL_INDEX = new Prefix("tutorialIndex/");

    /* Module definitions */
    public static final Prefix PREFIX_MODULE_CODE = new Prefix("modCode/");
    public static final Prefix PREFIX_MODULE_NAME = new Prefix("modName/");

    /* Reminder definitions */
    public static final Prefix PREFIX_REMINDER_DESCRIPTION = new Prefix("desc/");
    public static final Prefix PREFIX_REMINDER_DATE = new Prefix("date/");
    public static final Prefix PREFIX_REMINDER_TIME = new Prefix("time/");
}
