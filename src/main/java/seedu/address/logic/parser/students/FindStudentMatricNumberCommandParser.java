package seedu.address.logic.parser.students;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_STUDENT_EMPTY_MATRIC_NUMBER;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MATRIC_NUMBER;

import java.util.Arrays;

import seedu.address.logic.commands.students.FindStudentMatricNumberCommand;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.student.MatricNumberContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindStudentMatricNumberCommand object
 */
public class FindStudentMatricNumberCommandParser implements Parser<FindStudentMatricNumberCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindStudentMatricNumberCommand
     * and returns a FindStudentMatricNumberCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public FindStudentMatricNumberCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_MATRIC_NUMBER);

        boolean matricNumberProvided = argMultimap.getValue(PREFIX_MATRIC_NUMBER).isPresent();

        if (matricNumberProvided) {
            String trimmedArgs = argMultimap.getValue(PREFIX_MATRIC_NUMBER).get().trim();
            if (trimmedArgs.isEmpty()) {
                throw new ParseException(
                        String.format(MESSAGE_STUDENT_EMPTY_MATRIC_NUMBER
                                + FindStudentMatricNumberCommand.MESSAGE_USAGE));
            }

            String[] matricKeywords = trimmedArgs.split("\\s+");

            return new FindStudentMatricNumberCommand(
                    new MatricNumberContainsKeywordsPredicate(Arrays.asList(matricKeywords)));
        }

        throw new ParseException(
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindStudentMatricNumberCommand.MESSAGE_USAGE));
    }

}
