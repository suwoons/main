package seedu.address.ui.Calendar;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;
import seedu.address.ui.UiPart;

/**
 * Controller for a calendar page.
 * Solution adapted from https://github.com/SirGoose3432/javafx-calendar/blob/master/src/FullCalendarView.java
 */
public class CalendarWindow extends UiPart<Stage> {

    private static final Logger logger = LogsCenter.getLogger(CalendarWindow.class);
    private static final String FXML = "CalendarWindow.fxml";
    private static final String CALENDAR_MESSAGE = "Display a calendar view of TAble.";
    private static final int MAX_WEEKS_OF_MONTH = 5;
    private static final int DAYS_OF_WEEK = 7;

    @javafx.fxml.FXML
    private GridPane calendarGrid;

    @FXML
    private Label calendarTitle;

    private ArrayList<CalendarDay> allCalendarDays;
    private YearMonth currentYearMonth;

    /**
     * Creates a new CalendarWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public CalendarWindow(Stage root) {
        super(FXML, root);
        currentYearMonth = YearMonth.now();
        allCalendarDays = new ArrayList<>(35);
        calendarGrid = new GridPane();
        createUI();
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
     * Create the UI elements for Calendar.
     */
    public void createUI() {
        for (int i = 0; i < MAX_WEEKS_OF_MONTH; i++) {
            for (int j = 0; j < DAYS_OF_WEEK; j++) {
                CalendarDay day = new CalendarDay();
                allCalendarDays.add(day);
                StackPane dayPane = day.getCalendarDayStackPane();
                calendarGrid.add(dayPane, j, i);
            }
        }
    }

    /**
     * Fill the Calendar with the created CalendarDays.
     */
    public void fillDays() {
        // Get the date we want to start with on the calendar
        LocalDate calendarDate = LocalDate.of(currentYearMonth.getYear(), currentYearMonth.getMonthValue(), 1);
        // Dial back the day until it is SUNDAY (unless the month starts on a sunday)
        while (!calendarDate.getDayOfWeek().toString().equals("SUNDAY") ) {
            calendarDate = calendarDate.minusDays(1);
        }
        // Populate the calendar with day numbers
        for (CalendarDay calendarDay : allCalendarDays) {
            StackPane calendarDayStackPane = calendarDay.getCalendarDayStackPane();
            calendarDayStackPane.getChildren().clear();
            Text dateText = new Text(String.format("%02d", calendarDate.getDayOfMonth()));
            calendarDayStackPane.getChildren().add(dateText);
            calendarDay.setDate(calendarDate);
            calendarDate = calendarDate.plusDays(1);
        }
    }

    /**
     * Fill the Calendar Title with text.
     */
    public void fillTitle() {
        calendarTitle.setText(currentYearMonth.getMonth().toString() + " "
            + currentYearMonth.getYear());
        logger.info(currentYearMonth.getMonth().toString() + " " + currentYearMonth.getYear());
    }


    /**
     * Shows the Calendar window.
     * @throws IllegalStateException
     * <ul>
     *     <li>
     *         if this method is called on a thread other than the JavaFX Application Thread.
     *     </li>
     *     <li>
     *         if this method is called during animation or layout processing.
     *     </li>
     *     <li>
     *         if this method is called on the primary stage.
     *     </li>
     *     <li>
     *         if {@code dialogStage} is already showing.
     *     </li>
     * </ul>
     */
    public void show() {
        logger.fine("Showing the application in calendar window.");
        getRoot().show();
        getRoot().centerOnScreen();
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
     * Focuses on the Calendar window.
     */
    public void focus() {
        getRoot().requestFocus();
    }
}
