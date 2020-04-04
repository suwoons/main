package seedu.address.logic.commands.students;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.student.StudentTAble;

/**
 * Clears the address book.
 */
public class ClearStudentCommand extends Command {

    public static final String COMMAND_WORD = "clearStudent";
    public static final String MESSAGE_SUCCESS = "All students have been cleared!";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.setStudentTAble(new StudentTAble());
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
