package seedu.address.ui.tutorial;

import java.util.ArrayList;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.student.Student;
import seedu.address.ui.UiPart;

/**
 * Panel containing the list of attendance for a particular week and Tutorial.
 */
public class AttendanceListPanel extends UiPart<Region> {

    private static final String FXML = "AttendanceListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(AttendanceListPanel.class);

    @javafx.fxml.FXML
    private ListView<Student> studentListView;
    private ArrayList<Boolean> attendanceList;

    public AttendanceListPanel(ObservableList<Student> students, ArrayList<Boolean> attendanceList) {
        super(FXML);
        this.attendanceList = attendanceList;
        studentListView.setItems(students);
        studentListView.setCellFactory(listView -> new AttendanceListPanel.AttendanceListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a student's attendance in a {@code Tutorial} using an
     * {@code AttendanceCard}.
     */
    class AttendanceListViewCell extends ListCell<Student> {
        @Override
        protected void updateItem(Student student, boolean empty) {
            super.updateItem(student, empty);

            if (empty || student == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new AttendanceCard(student, getIndex() + 1, attendanceList).getRoot());
            }
        }
    }
}