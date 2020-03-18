package seedu.address.model.student;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class MatricNumberTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new MatricNumber(null));
    }

    @Test
    public void constructor_invalidMatricNumber_throwsIllegalArgumentException() {
        String invalidMatricNumber = "";
        assertThrows(IllegalArgumentException.class, () -> new MatricNumber(invalidMatricNumber));
    }

    @Test
    public void isValidMatricNumber() {
        // null matric number
        assertThrows(NullPointerException.class, () -> MatricNumber.isValidMatricNumber(null));

        // invalid matric numbers
        assertFalse(MatricNumber.isValidMatricNumber("")); // empty string
        assertFalse(MatricNumber.isValidMatricNumber(" ")); // spaces only
        assertFalse(MatricNumber.isValidMatricNumber("91")); // less than 3 numbers
        assertFalse(MatricNumber.isValidMatricNumber("test")); // non-numeric
        assertFalse(MatricNumber.isValidMatricNumber("9011p041")); // alphabets within digits
        assertFalse(MatricNumber.isValidMatricNumber("9312 1534")); // spaces within digits

        // valid matric numbers
        assertTrue(MatricNumber.isValidMatricNumber("911")); // exactly 3 numbers
        assertTrue(MatricNumber.isValidMatricNumber("93121534"));
        assertTrue(MatricNumber.isValidMatricNumber("124293842033123")); // long matric numbers
    }
}
