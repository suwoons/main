package seedu.address.commons.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * TutorialUtil contains methods for manipulating Tutorials.
 */
public class TutorialUtil {

    /**
     * Check that {@code beginTime} provided is earlier than {@code endTime} provided
     * @return true if beginTime is before endTime
     */
    public static boolean isStartEarlierThanEndTime(LocalTime startTime, LocalTime endTime) {
        return startTime.compareTo(endTime) < 0;
    }

    /**
     * Check that {@code beginTime} provided is earlier than {@code endTime} provided
     * @return true if beginTime is before endTime
     */
    public static boolean checkDayOfWeek(DayOfWeek tutorialDay, LocalDate calendarDate) {
        return tutorialDay.equals(calendarDate.getDayOfWeek());
    }
}
