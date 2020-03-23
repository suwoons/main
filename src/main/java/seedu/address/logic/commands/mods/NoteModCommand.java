package seedu.address.logic.commands.mods;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MODULE_NOTE;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_MODS;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.mod.Mod;

/**
 * Appends notes to the end of the note in a Mod.
 */

public class NoteModCommand extends Command {

    public static final String COMMAND_WORD = "noteMod";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Appends the notes of the module identified "
        + "by the index number used in the displayed module list. "
        + "Existing values will be overwritten by the input values.\n"
        + "Parameters: INDEX (must be a positive integer) "
        + PREFIX_MODULE_NOTE + "NOTE\n"
        + "Example: " + COMMAND_WORD + " 1 "
        + PREFIX_MODULE_NOTE + "Fun module!! ";

    public static final String MESSAGE_EDIT_MODNOTE_SUCCESS = "Edited Student: %1$s";

    private final Index index;
    private final String note;

    /**
     * @param index of the module in the filtered module list to edit
     * @param note details to append the module note with
     */
    public NoteModCommand(Index index, String note) {
        requireNonNull(index);
        requireNonNull(note);

        this.index = index;
        this.note = note;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Mod> lastShownList = model.getFilteredModList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_MOD_DISPLAYED_INDEX);
        }

        Mod modToEdit = lastShownList.get(index.getZeroBased());
        Mod editedMod = new Mod(modToEdit, note);

        model.setMod(modToEdit, editedMod);
        model.updateFilteredModList(PREDICATE_SHOW_ALL_MODS);
        return new CommandResult(String.format(MESSAGE_EDIT_MODNOTE_SUCCESS, editedMod));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof NoteModCommand)) {
            return false;
        }

        // state check
        NoteModCommand e = (NoteModCommand) other;
        return index.equals(e.index)
            && note.equals(e.note);
    }
}
