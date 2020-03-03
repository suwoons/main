package seedu.address.model.student;
import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;


public class StudentID {

    public static final String MESSAGE_CONSTRAINS =
            "Student ID should be of the format A[Number][Letter], for example A1234567Y."
                    + " And adhere to the following constraints:\n"
                    + "1. Student ID must only be 9 characters long"
                    + "2. The numerical part must be 7 characters long and contain only numbers";

    private static final String INITIAL_REGEX = "[A]";
    private static final String NUMBER_REGEX = "\\d{7}";
    private static final String LETTER_REGEX = "[A-Z]";

    public final String studentID;

    public StudentID(String studentID) {
        requireNonNull(studentID);
        checkArgument(isValidStudentID(studentID), MESSAGE_CONSTRAINS);
        this.studentID = studentID;
    }

    private Boolean isValidStudentID(String studentID) {
        return studentID.matches(INITIAL_REGEX + NUMBER_REGEX + LETTER_REGEX);
    }

    @Override
    public String toString() {
        return this.studentID;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof StudentID // instanceof handles nulls
                && studentID.equals(((StudentID) other).studentID)); // state check
    }


}
