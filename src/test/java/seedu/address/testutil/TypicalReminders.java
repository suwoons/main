package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.reminder.Description;
import seedu.address.model.reminder.Reminder;
import seedu.address.model.reminder.ReminderTAble;

/**
 * A utility class containing a list of {@code Reminders}  to be used in tests.
 */
public class TypicalReminders {

    private static Reminder reminder1;
    private static Reminder reminder2;

    static {
        try {
            reminder1 = new ReminderBuilder()
                    .withDescription(new Description("Send out email to T02"))
                    .withDate("2022-03-20")
                    .withTime("15:00").build();
            reminder2 = new ReminderBuilder()
                    .withDescription(new Description("Get back to alice on tutorial 3 qns 5"))
                    .withDate("2022-03-23")
                    .withTime("16:00").build();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns an {@code ReminderTAble} with all the typical reminders.
     */
    public static ReminderTAble getTypicalReminderTAble() {
        ReminderTAble st = new ReminderTAble();
        for (Reminder reminder : getTypicalReminders()) {
            st.addReminder(reminder);
        }
        return st;
    }

    public static List<Reminder> getTypicalReminders() {
        return new ArrayList<>(Arrays.asList(reminder1, reminder2));
    }
}
