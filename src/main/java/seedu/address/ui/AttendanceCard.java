package seedu.address.ui;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.student.Student;

/**
 * A UI component that displays information of a {@code Tutorial}.
 */
public class AttendanceCard extends UiPart<Region> {

    private static final String FXML = "AttendanceListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on StudentTAble level 4</a>
     */

    public final Student student;
    public ArrayList<Boolean> attendanceList = new ArrayList<Boolean>();

    @javafx.fxml.FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label name;
    @FXML
    private Label attendance;

    public AttendanceCard(Student student, int displayedIndex, ArrayList<Boolean> attendanceList) {
        super(FXML);
        this.student = student;
        this.attendanceList = attendanceList;

        id.setText(displayedIndex + ". ");
        name.setText(student.getName().fullName);
        attendance.setText(attendanceList.get(displayedIndex - 1).toString());
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AttendanceCard)) {
            return false;
        }

        // state check
        AttendanceCard card = (AttendanceCard) other;
        return id.getText().equals(card.id.getText())
                && student.equals(card.student)
                && attendanceList.equals(card.attendanceList);
    }
}
