package seedu.address.logic.parser.consults;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.util.ConsultUtil.checkStartEndDateTime;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CONSULT_BEGIN_DATE_TIME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_CONSULT_END_DATE_TIME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PLACE;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.consults.EditConsultCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class EditConsultCommandParser implements Parser<EditConsultCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditConsultCommand
     * and returns an EditConsultCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditConsultCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_CONSULT_BEGIN_DATE_TIME, PREFIX_CONSULT_END_DATE_TIME,
                        PREFIX_PLACE);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    EditConsultCommand.MESSAGE_USAGE), pe);
        }

        EditConsultCommand.EditConsultDescriptor editConsultDescriptor = new EditConsultCommand.EditConsultDescriptor();
        if (argMultimap.getValue(PREFIX_CONSULT_BEGIN_DATE_TIME).isPresent()) {
            editConsultDescriptor.setBeginDateTime(
                    ParserUtil.parseDateTime(argMultimap.getValue(PREFIX_CONSULT_BEGIN_DATE_TIME).get()));
        }
        if (argMultimap.getValue(PREFIX_CONSULT_END_DATE_TIME).isPresent()) {
            editConsultDescriptor.setEndDateTime(
                    ParserUtil.parseDateTime(argMultimap.getValue(PREFIX_CONSULT_END_DATE_TIME).get()));
        }
        if (argMultimap.getValue(PREFIX_PLACE).isPresent()) {
            editConsultDescriptor.setLocation(ParserUtil.parsePlace(argMultimap.getValue(PREFIX_PLACE).get()));
        }
       // if (!checkStartEndDateTime(editConsultDescriptor.getBeginDateTime(), editConsultDescriptor.getEndDateTime()))
        if (!editConsultDescriptor.isAnyFieldEdited()) {
            throw new ParseException(EditConsultCommand.MESSAGE_NOT_EDITED);
        }

        return new EditConsultCommand(index, editConsultDescriptor);
    }
}
