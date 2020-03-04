package seedu.address.logic.parser.consults;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
//import static seedu.address.logic.parser.CliSyntax.PREFIX_CONSULT_STUDENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EVENT_BEGIN_DATE_TIME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EVENT_END_DATE_TIME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EVENT_LOCATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EVENT_NAME;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import seedu.address.logic.commands.consults.AddConsultCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.Prefix;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.event.EventLocation;
import seedu.address.model.event.EventName;
import seedu.address.model.event.consult.Consult;
//import seedu.address.model.person.Person;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddConsultCommandParser implements Parser<AddConsultCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddConsultCommand
     * and returns an AddConsultCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddConsultCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_EVENT_NAME, PREFIX_EVENT_BEGIN_DATE_TIME,
                        PREFIX_EVENT_END_DATE_TIME, PREFIX_EVENT_LOCATION);

        if (!arePrefixesPresent(argMultimap, PREFIX_EVENT_NAME, PREFIX_EVENT_BEGIN_DATE_TIME,
                PREFIX_EVENT_END_DATE_TIME, PREFIX_EVENT_LOCATION)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    AddConsultCommand.MESSAGE_USAGE));
        }

        EventName eventName = ParserUtil.parseEventName(argMultimap.getValue(PREFIX_EVENT_NAME).get());
        LocalDateTime eventBeginDateTime = ParserUtil.parseTime(argMultimap.getValue(
                PREFIX_EVENT_BEGIN_DATE_TIME).get());
        LocalDateTime eventEndDateTime = ParserUtil.parseTime(argMultimap.getValue(
                PREFIX_EVENT_END_DATE_TIME).get());
        EventLocation eventLocation = ParserUtil.parseEventLocation(argMultimap.getValue(
                PREFIX_EVENT_LOCATION).get());
        //Index index = ParserUtil.parseIndex(argMultimap.getValue(PREFIX_CONSULT_STUDENT).get());

        Consult consult = new Consult(eventName, eventBeginDateTime, eventEndDateTime, eventLocation);

        return new AddConsultCommand(consult);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
