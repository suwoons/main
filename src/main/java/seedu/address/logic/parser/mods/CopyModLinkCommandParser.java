package seedu.address.logic.parser.mods;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MODULE_CODE;

import java.util.stream.Stream;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.mods.CopyModLinkCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.mod.ModCode;

/**
 * Parses input arguments and creates a new CopyModLinkCommand object
 */
public class CopyModLinkCommandParser implements Parser<CopyModLinkCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the CopyModLinkCommand
     * and returns a CopyModLinkCommand object for execution.
     * @throws ParseException if the user input does not conform to the expected format
     */
    public CopyModLinkCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
            ArgumentTokenizer.tokenize(args, PREFIX_MODULE_CODE);

        Index index;
        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, CopyModLinkCommand.MESSAGE_USAGE),
                pe);
        }

        if (!arePrefixesPresent(argMultimap, PREFIX_MODULE_CODE)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                CopyModLinkCommand.MESSAGE_USAGE));
        }

        ModCode modCode = ParserUtil.parseModCode(argMultimap.getValue(PREFIX_MODULE_CODE).get());
        return new CopyModLinkCommand(index, modCode);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
