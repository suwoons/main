package seedu.address.ui;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.plaf.synth.Region;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.student.Student;

/**
 * Panel containing the list of attendance for a particular week and Tutorial.
 */
public class AttendanceListPanel extends UiPart<Node> {

    private static final String FXML = "AttendanceListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(AttendanceListPanel.class);

    @FXML
    private ListView<Student> studentListView;
    private ArrayList<Boolean> attendanceList;

    public AttendanceListPanel(ObservableList<Student> students, ArrayList<Boolean> attendanceList) {
        super(FXML);
        this.attendanceList = attendanceList;
        studentListView.setItems(students);
        studentListView.setCellFactory(listView -> new AttendanceListPanel.AttendanceListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of attendance of a {@code Tutorial} using an
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
