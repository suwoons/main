package seedu.address.ui.calendar;

import java.time.LocalDate;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.address.commons.core.LogsCenter;
import seedu.address.ui.UiPart;

/**
 * Represents a calendar date cell in the calendar window.
 */
public class CalendarDay extends UiPart<Region> {

    private static final String FXML = "CalendarDay.fxml";
    private final Logger logger = LogsCenter.getLogger(getClass());

    @FXML
    private StackPane calendarDayStackPane;

    private LocalDate date;

    /**
     * Creates a CalendarDay.
     */
    public CalendarDay() {
        super(FXML);
    }

    public StackPane getCalendarDayStackPane() {
        logger.fine("Return StackPane");
        return calendarDayStackPane;
    }

    /**
     * Sets the date of this {@code CalendarDay} to the specified date.
     *
     * */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Returns the date of this {@code CalendarDay}.
     *
     * @return The date of this {@code CalendarDay}.
     */
    public LocalDate getDate() {
        return date;
    }
}
