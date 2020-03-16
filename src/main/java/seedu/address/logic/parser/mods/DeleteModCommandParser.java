package seedu.address.logic.parser.mods;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.mods.DeleteModCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteModCommand object
 */
public class DeleteModCommandParser implements Parser<DeleteModCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeleteModCommand
     * and returns a DeleteModCommand object for execution.
     * @throws ParseException if the user input does not conform to the expected format
     */
    public DeleteModCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new DeleteModCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteModCommand.MESSAGE_USAGE), pe);
        }
    }

}
