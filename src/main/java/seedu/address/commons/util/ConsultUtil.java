package seedu.address.commons.util;

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
        return startDateTime.compareTo(endDateTime) < 0;
    }
}
