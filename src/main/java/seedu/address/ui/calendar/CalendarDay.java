package seedu.address.ui.calendar;

import java.time.LocalDate;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.event.consult.Consult;
import seedu.address.ui.UiPart;

/**
 * Represents a calendar date cell in the calendar window.
 */
public class CalendarDay extends UiPart<Region> {

    private static final String FXML = "CalendarDay.fxml";
    private final Logger logger = LogsCenter.getLogger(getClass());
    private LocalDate date;
    private ObservableList<Consult> consults;

    @FXML
    private StackPane calendarDayStackPane;

    /**
     * Creates a CalendarDay.
     */
    public CalendarDay() {
        super(FXML);
        consults = FXCollections.observableArrayList();
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

    /**
     * Adds the consult that is happening on this day to the {@Code CalendarDay}.
     */
    public void addConsult(Consult consult) {
        consults.add(consult);
    }

    /**
     * Updates the number of consults on this CalendarDay.
     */
    public void updateNumConsults() {
        int noConsults = consults.size();
        if (noConsults > 0) {
            Text consultsCount;
            if (noConsults == 1) {
                consultsCount = new Text("1 consult");
            } else {
                consultsCount = new Text(noConsults + " consults");
            }
            calendarDayStackPane.getChildren().add(consultsCount);
        }
    }
}
