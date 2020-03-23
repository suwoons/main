package seedu.address.commons.util;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ConsultUtil contains methods for manipulating Consults.
 */
public class ConsultUtil {

    /**
     * Check that {@code beginDateTime} provided is earlier than {@code endDateTime} provided
     * @return true if beginDateTime is before endDateTime
     */
    public static boolean checkStartEndDateTime(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return startDateTime.isBefore(endDateTime);
    }

    /**
     *
     */
    public static boolean isSameDate(LocalDateTime consultDateTime, LocalDate calendarDate) {
        LocalDate startDate = LocalDate.of(consultDateTime.getYear(), consultDateTime.getMonthValue(),
            consultDateTime.getDayOfMonth());
        return startDate.isEqual(calendarDate);
    }
}
