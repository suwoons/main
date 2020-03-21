package seedu.address.ui.calendar;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;
import seedu.address.ui.UiPart;

/**
 * Controller for a calendar page.
 * Code below adapted from https://github.com/SirGoose3432/javafx-calendar/blob/master/src/FullCalendarView.java
 */
public class CalendarWindow extends UiPart<Stage> {

    public static final String FXML = "CalendarWindow.fxml";
    private static final int MAX_WEEK_OF_MONTH = 5;
    private static final int WEEKDAYS = 7;
    private final Logger logger = LogsCenter.getLogger(getClass());

    @FXML
    private GridPane dateDisplayGrid;

    @FXML
    private Label calendarTitle;

    private List<CalendarDay> calendarDays;
    private YearMonth currentYearMonth;

    /**
     * Constructs a calendar window with the current month as reference.
     */
    public CalendarWindow(Stage root) {
        super(FXML, root);
        calendarDays = new ArrayList<>();
        currentYearMonth = YearMonth.now();
        createUi();
        fillDays();
        fillTitle();
    }

    /**
     * Creates a new CalendarWindow.
     */
    public CalendarWindow() {
        this(new Stage());
    }

    /**
     * Creates the UI elements for the calendar.
     */
    private void createUi() {
        for (int i = 0; i < MAX_WEEK_OF_MONTH; i++) {
            for (int j = 0; j < WEEKDAYS; j++) {
                CalendarDay calendarDay = new CalendarDay();
                calendarDays.add(calendarDay);
                StackPane calendarDayStackPane = calendarDay.getCalendarDayStackPane();
                dateDisplayGrid.add(calendarDayStackPane, j, i);
            }
        }
    }

    /**
     * Fill the calendar based on the created CalendarDays.
     */
    private void fillDays() {
        // Get the date we want to start with on the calendar
        LocalDate calendarDate = LocalDate.of(currentYearMonth.getYear(), currentYearMonth.getMonthValue(), 1);
        // Dial back the day until it is SUNDAY (unless the month starts on a sunday)
        while (!calendarDate.getDayOfWeek().toString().equals("SUNDAY")) {
            calendarDate = calendarDate.minusDays(1);
        }

        for (CalendarDay calendarDay : calendarDays) {
            StackPane calendarDayStackPane = calendarDay.getCalendarDayStackPane();
            calendarDayStackPane.getChildren().clear();
            Text dateText = new Text(String.format("%02d", calendarDate.getDayOfMonth()));
            StackPane.setAlignment(dateText, Pos.TOP_LEFT);
            calendarDayStackPane.getChildren().add(dateText);
            calendarDay.setDate(calendarDate);
            calendarDate = calendarDate.plusDays(1);
        }
    }

    /**
     * Fill the calendar's title with month and year.
     */
    private void fillTitle() {
        calendarTitle.setText(currentYearMonth.getMonth().toString() + " "
            + currentYearMonth.getYear());
        logger.info(currentYearMonth.getMonth().toString() + " " + currentYearMonth.getYear());
    }

    /**
     * Returns true if the Calendar window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the Calendar window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Shows the Calendar window.
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Focuses on the Calendar window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

}
