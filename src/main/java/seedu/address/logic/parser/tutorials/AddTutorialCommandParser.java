package seedu.address.logic.parser.tutorials;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.stream.Stream;

import seedu.address.logic.commands.tutorials.AddTutorialCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.event.Location;
import seedu.address.model.event.tutorial.Tutorial;
import seedu.address.model.event.tutorial.TutorialName;
import seedu.address.model.mod.ModCode;

/**
 * Parses input arguments and creates a new AddTutorial object
 */

public class AddTutorialCommandParser implements Parser<AddTutorialCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddTutorialCommand
     * and returns an AddTutorialCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddTutorialCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_MODULE_CODE, PREFIX_TUTORIAL_NAME,
                        PREFIX_TUTORIAL_WEEKDAY, PREFIX_TUTORIAL_BEGIN_TIME, PREFIX_TUTORIAL_END_TIME,
                        PREFIX_PLACE);

        if (!arePrefixesPresent(argMultimap, PREFIX_MODULE_CODE, PREFIX_TUTORIAL_NAME,
                PREFIX_TUTORIAL_WEEKDAY, PREFIX_TUTORIAL_BEGIN_TIME, PREFIX_TUTORIAL_END_TIME,
                PREFIX_PLACE)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    AddTutorialCommand.MESSAGE_USAGE));
        }

        ModCode moduleCode = ParserUtil.parseModCode(argMultimap.getValue(PREFIX_MODULE_CODE).get());
        TutorialName tutorialName = ParserUtil.parseTutorialName(argMultimap.getValue(
                PREFIX_TUTORIAL_NAME).get());
        DayOfWeek weekday = ParserUtil.parseDay(argMultimap.getValue(
                PREFIX_TUTORIAL_WEEKDAY).get());
        LocalTime beginTime = ParserUtil.parseTime(argMultimap.getValue(
                PREFIX_TUTORIAL_BEGIN_TIME).get());
        LocalTime endTime = ParserUtil.parseTime(argMultimap.getValue(
               PREFIX_TUTORIAL_END_TIME).get());
        Location location = ParserUtil.parsePlace(argMultimap.getValue(
                PREFIX_PLACE).get());

        Tutorial tutorial = new Tutorial(moduleCode, tutorialName, weekday, beginTime, endTime, location);

        return new AddTutorialCommand(tutorial);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
