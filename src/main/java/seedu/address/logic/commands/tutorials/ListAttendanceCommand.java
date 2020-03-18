package seedu.address.logic.commands.tutorials;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.event.tutorial.Tutorial;

import java.util.List;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_TUTORIALS;

/**
 * Lists attendance for a specified tutorial and week
 */
public class ListAttendanceCommand extends Command {
    public final Index tutorialIndex;
    public final Index week;

    public ListAttendanceCommand(Index tutorialIndex, Index week) {
        this.tutorialIndex = tutorialIndex;
        this.week = week;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        // model.updateFilteredTutorialList(PREDICATE_SHOW_ALL_TUTORIALS);
        return null;
    }

}
