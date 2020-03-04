package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands
 */
public class CliSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("n/");
    public static final Prefix PREFIX_PHONE = new Prefix("p/");
    public static final Prefix PREFIX_EMAIL = new Prefix("e/");
    public static final Prefix PREFIX_ADDRESS = new Prefix("a/");
    public static final Prefix PREFIX_TAG = new Prefix("t/");
    public static final Prefix PREFIX_REMARK = new Prefix("r/");

    /* Event definitions */
    public static final Prefix PREFIX_EVENT_NAME = new Prefix("event/");
    public static final Prefix PREFIX_EVENT_BEGIN_DATE_TIME = new Prefix("beginDateTime/");
    public static final Prefix PREFIX_EVENT_END_DATE_TIME = new Prefix("endDateTime/");
    public static final Prefix PREFIX_EVENT_LOCATION = new Prefix("location/");

    /* Consult definitions */
    public static final Prefix PREFIX_CONSULT_STUDENT = new Prefix("student/");


}
