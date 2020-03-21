package seedu.address.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;

/**
 * Controller for a calendar page
 */
public class CalendarWindow extends UiPart<Stage> {

    private static final Logger logger = LogsCenter.getLogger(CalendarWindow.class);
    private static final String FXML = "CalendarWindow.fxml";
    private static final String CALENDAR_MESSAGE = "Display a calendar view of TAble.";

    @javafx.fxml.FXML
    private Button copyButton;

    @FXML
    private Label calendarView;

    /**
     * Creates a new CalendarWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public CalendarWindow(Stage root) {
        super(FXML, root);
        calendarView.setText(CALENDAR_MESSAGE);
    }

    /**
     * Creates a new CalendarWindow.
     */
    public CalendarWindow() {
        this(new Stage());
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
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }
}
