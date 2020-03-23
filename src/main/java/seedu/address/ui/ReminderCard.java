package seedu.address.ui;

import java.time.format.DateTimeFormatter;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.reminder.Reminder;

/**
 * An UI component that displays information of a {@code Reminder}.
 */
public class ReminderCard extends UiPart<Region> {

    private static final String FXML = "ReminderListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on StudentTAble level 4</a>
     */

    public final Reminder reminder;

    @javafx.fxml.FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label description;
    @FXML
    private Label date;
    @FXML
    private Label time;

    public ReminderCard(Reminder reminder, int displayedIndex) {
        super(FXML);
        this.reminder = reminder;
        id.setText(displayedIndex + ". ");
        description.setText(reminder.getDescription().toString());
        date.setText(reminder.getDate().format(DateTimeFormatter.ofPattern("dd-MMM-YY")));
        time.setText(reminder.getTime().format(DateTimeFormatter.ofPattern("HH:mm")));
        setDone(reminder.getDone());
    }

    public void setDone(boolean done) {
        id.setStyle("-fx-text-fill: #353535;");
        description.setStyle("-fx-text-fill: #353535;");
        date.setStyle("-fx-text-fill: #353535;");
        time.setStyle("-fx-text-fill: #353535;");
        if (done) {
            cardPane.setStyle("-fx-background-color: #9fffb1;");
        } else {
            cardPane.setStyle("-fx-background-color: #FFA5AA;");
        }
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ReminderCard)) {
            return false;
        }

        // state check
        ReminderCard card = (ReminderCard) other;
        return id.getText().equals(card.id.getText())
                && reminder.equals(card.reminder);
    }
}
