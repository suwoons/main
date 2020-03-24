package seedu.address.logic.parser.mods;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MODULE_CODE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MODULE_NAME;

import java.util.stream.Stream;

import seedu.address.logic.commands.mods.AddModCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.mod.ModCode;

/**
 * Parses input arguments and creates a new AddModCommand object
 */

public class AddModCommandParser implements Parser<AddModCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddModCommand
     * and returns an AddModCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddModCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
            ArgumentTokenizer.tokenize(args, PREFIX_MODULE_CODE, PREFIX_MODULE_NAME);

        if (!arePrefixesPresent(argMultimap, PREFIX_MODULE_CODE, PREFIX_MODULE_NAME)
            || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                AddModCommand.MESSAGE_USAGE));
        }

        ModCode modCode = ParserUtil.parseModCode(argMultimap.getValue(PREFIX_MODULE_CODE).get());
        String modName = argMultimap.getValue(PREFIX_MODULE_NAME).get();

        return new AddModCommand(modCode, modName);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
