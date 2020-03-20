package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalStudents.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.StudentTAble;
import seedu.address.model.UserPrefs;
import seedu.address.model.event.consult.ConsultTAble;
import seedu.address.model.event.tutorial.TutorialTAble;
import seedu.address.model.mod.ModTAble;
import seedu.address.model.reminder.ReminderTAble;

public class ClearCommandTest {

    @Test
    public void execute_emptyAddressBook_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyAddressBook_success() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs(), new ConsultTAble(),
            new TutorialTAble(), new ModTAble(), new ReminderTAble());
        Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs(), new ConsultTAble(),
            new TutorialTAble(), new ModTAble(), new ReminderTAble());
        expectedModel.setStudentTAble(new StudentTAble());

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

}
