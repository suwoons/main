package seedu.address.logic.commands.mods;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_INDEX;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.mod.Mod;

/**
 * Deletes an existing Mod from TAble.
 */

public class DeleteModCommand extends Command {
    public static final String COMMAND_WORD = "deleteMod";

    public static final String MESSAGE_USAGE = COMMAND_WORD
        + ": Deletes the module identified by the index number used in the displayed ModTAble.\n"
        + "Parameters: "
        + PREFIX_INDEX
        + "\nExample: " + COMMAND_WORD + " 2";

    public static final String MESSAGE_DELETE_MOD_SUCCESS = "Deleted module!\n%1$s";

    private final Index targetIndex;

    public DeleteModCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Mod> lastShownList = model.getFilteredModList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_TUTORIAL_DISPLAYED_INDEX);
        }

        Mod modToDelete = lastShownList.get(targetIndex.getZeroBased());
        model.deleteMod(modToDelete);
        return new CommandResult(String.format(MESSAGE_DELETE_MOD_SUCCESS, modToDelete));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof seedu.address.logic.commands.mods.DeleteModCommand
            && targetIndex.equals(((seedu.address.logic.commands.mods.DeleteModCommand) other).targetIndex));
    }
}
