package seedu.address.storage.tutorials;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

class JsonAdaptedAttendanceWeek {

    private final List<Boolean> attendanceWeek = new ArrayList<Boolean>();

    /**
     * Constructs a {@code JsonAdaptedAttendanceWeek} with the given tutorial attendance details.
     */
    @JsonCreator
    public JsonAdaptedAttendanceWeek(@JsonProperty("isPresent") List<Boolean> attendanceWeek) {
        if (attendanceWeek != null) {
            this.attendanceWeek.addAll(attendanceWeek);
        }
    }

    /**
     * Converts a given {@code ArrayList} into this class for Jackson use.
     */
    public JsonAdaptedAttendanceWeek(ArrayList<Boolean> source) {
        this.attendanceWeek.addAll(source);
    }

    /**
     * Converts this Jackson-friendly adapted tutorial attendance week object into the model's
     * {@code ArrayList<Boolean>} object.
     */
    public ArrayList<Boolean> toModelType() {
        final ArrayList<Boolean> modelAttendanceWeek = new ArrayList<Boolean>();

        if (!attendanceWeek.isEmpty()) {
            modelAttendanceWeek.addAll(attendanceWeek);
        }

        return modelAttendanceWeek;
    }
}
