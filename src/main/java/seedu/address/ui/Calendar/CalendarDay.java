package seedu.address.ui.Calendar;

import java.time.LocalDate;
import java.util.logging.Logger;

import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import seedu.address.commons.core.LogsCenter;
import seedu.address.ui.UiPart;

/**
 * Java class that represents one day in the Calendar Window.
 */
public class CalendarDay extends UiPart<Region> {

    private static final Logger logger = LogsCenter.getLogger(CalendarDay.class);
    private static final String FXML = "CalendarDay.fxml";

    @javafx.fxml.FXML
    private StackPane calendarDayStackPane;

    @javafx.fxml.FXML
    private Label calendarDate;

    private LocalDate date;

    /**
     * Creates a new CalendarDay.
     **/
    public CalendarDay() {
        super(FXML);
    }

    /**
     * Returns the calendarDayGridPane
     */
    public StackPane getCalendarDayStackPane() {
        return calendarDayStackPane;
    }

    /**
     * Sets the date of the CalendarDay to be that of the input {@Code: calendarDate}.
     */
    public void setDate(LocalDate calendarDate) {
        this.date = calendarDate;
        //this.calendarDate = new Label(String.format("%d", calendarDate.getDayOfMonth())); }
    }
}
