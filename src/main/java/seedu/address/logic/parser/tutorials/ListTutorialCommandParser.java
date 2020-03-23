package seedu.address.logic.parser.tutorials;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.*;

import java.util.stream.Stream;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.tutorials.ListTutorialCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ListTutorialCommand object
 */
public class ListTutorialCommandParser implements Parser<ListTutorialCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ListTutorialCommand
     * and returns a ListTutorialCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ListTutorialCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_TUTORIAL_INDEX, PREFIX_TUTORIAL_WEEK);

        if (!arePrefixesPresent(argMultimap, PREFIX_TUTORIAL_INDEX, PREFIX_TUTORIAL_WEEK)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    ListTutorialCommand.MESSAGE_USAGE));
        }

        Index tutorialIndex = ParserUtil.parseIndex(argMultimap.getValue(PREFIX_TUTORIAL_INDEX).get());
        int weekZeroBased = ParserUtil.parseTutorialWeek(argMultimap.getValue(PREFIX_TUTORIAL_WEEK).get());

        return new ListTutorialCommand(tutorialIndex, weekZeroBased);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
