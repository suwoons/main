package seedu.address.ui.Calendar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;
import seedu.address.ui.UiPart;

/**
 * Java class that represents one day in the Calendar Window.
 */
public class CalendarDay extends UiPart<Region> {

    private static final Logger logger = LogsCenter.getLogger(CalendarDay.class);
    private static final String FXML = "CalendarDay.fxml";

    @javafx.fxml.FXML
    private GridPane calendarDayGridPane;

    @javafx.fxml.FXML
    private Label calendarView;

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
    public GridPane getCalendarDayGridPane() {
        return calendarDayGridPane;
    }

    /**
     * Sets the date of the CalendarDay to be that of the input {@Code: calendarDate}.
     */
    public void setDate(LocalDate calendarDate) {
        this.date = date;
        Text dateNum = new Text(String.format("%d", calendarDate.getDayOfMonth()));
        calendarDayGridPane.getChildren().add(dateNum);
    }
}
