package seedu.address.model.mod;


import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Module's module code in TAble.
 * Guarantees: immutable; is valid as declared in {@link #isValidModCode(String)}
 */

public class ModCode {

    public static final String MESSAGE_CONSTRAINTS = "Modules should be of the format Department0000Subcode "
            + "and adhere to the following constraints:\n"
            + "1. The department should only contain either two or three capital letters\n"
            + "2. This is followed by 4 numbers, with the first not being zero.\n"
            + "The subcode cannot be more than 2 capital letters long. ";

    /*
     * The entire string must fit the specifications for it to be valid.
     */
    public static final String VALIDATION_REGEX = "^[A-Z]{2,3}\\d{4}[A-Z]{0,2}$";

    public final String modCode;

    /**
     * Constructs a {@code ModCode}.
     *
     * @param modCode A valid module code.
     */
    public ModCode(String modCode) {
        requireNonNull(modCode);
        checkArgument(isValidModCode(modCode), MESSAGE_CONSTRAINTS);
        this.modCode = modCode;
    }

    /**
     * Returns true if a given string is a valid tutorial name.
     */
    public static boolean isValidModCode(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public String getModCode() {
        return modCode;
    }

    @Override
    public String toString() {
        return modCode;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof seedu.address.model.mod.ModCode // instanceof handles nulls
                && modCode.equals(((seedu.address.model.mod.ModCode) other).modCode)); // state check
    }

    @Override
    public int hashCode() {
        return modCode.hashCode();
    }
}
