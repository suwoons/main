package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.RemarkCommand;
import seedu.address.logic.commands.consults.AddConsultCommand;
import seedu.address.logic.commands.consults.DeleteConsultCommand;
import seedu.address.logic.commands.consults.EditConsultCommand;
import seedu.address.logic.commands.consults.ListConsultCommand;
import seedu.address.logic.commands.mods.AddModCommand;
import seedu.address.logic.commands.mods.DeleteModCommand;
import seedu.address.logic.commands.mods.ListModCommand;
import seedu.address.logic.commands.reminders.AddReminderCommand;
import seedu.address.logic.commands.reminders.DeleteReminderCommand;
import seedu.address.logic.commands.reminders.DoneReminderCommand;
import seedu.address.logic.commands.reminders.EditReminderCommand;
import seedu.address.logic.commands.tutorials.AddTutorialCommand;
import seedu.address.logic.commands.tutorials.AddTutorialStudentCommand;
import seedu.address.logic.commands.tutorials.DeleteTutorialCommand;
import seedu.address.logic.commands.tutorials.DeleteTutorialStudentCommand;
import seedu.address.logic.commands.tutorials.ListTutorialCommand;
import seedu.address.logic.parser.consults.AddConsultCommandParser;
import seedu.address.logic.parser.consults.ClearConsultCommand;
import seedu.address.logic.parser.consults.DeleteConsultCommandParser;
import seedu.address.logic.parser.consults.EditConsultCommandParser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.mods.AddModCommandParser;
import seedu.address.logic.parser.mods.DeleteModCommandParser;
import seedu.address.logic.parser.reminders.AddReminderCommandParser;
import seedu.address.logic.parser.reminders.DeleteReminderCommandParser;
import seedu.address.logic.parser.reminders.DoneReminderCommandParser;
import seedu.address.logic.parser.reminders.EditReminderCommandParser;
import seedu.address.logic.parser.tutorials.AddTutorialCommandParser;
import seedu.address.logic.parser.tutorials.AddTutorialStudentCommandParser;
import seedu.address.logic.parser.tutorials.DeleteTutorialCommandParser;
import seedu.address.logic.parser.tutorials.DeleteTutorialStudentCommandParser;

/**
 * Parses user input.
 */
public class TAbleParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {

        case AddCommand.COMMAND_WORD:
            return new AddCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            return new EditCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommand();

        case ExitCommand.COMMAND_WORD:
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            return new HelpCommand();

        case RemarkCommand.COMMAND_WORD:
            return new RemarkCommandParser().parse(arguments);

        case AddConsultCommand.COMMAND_WORD:
            return new AddConsultCommandParser().parse(arguments);

        case ListConsultCommand.COMMAND_WORD:
            return new ListConsultCommand();

        case DeleteConsultCommand.COMMAND_WORD:
            return new DeleteConsultCommandParser().parse(arguments);

        case EditConsultCommand.COMMAND_WORD:
            return new EditConsultCommandParser().parse(arguments);

        case ClearConsultCommand.COMMAND_WORD:
            return new ClearConsultCommand();

        case AddTutorialCommand.COMMAND_WORD:
            return new AddTutorialCommandParser().parse(arguments);

        case AddTutorialStudentCommand.COMMAND_WORD:
            return new AddTutorialStudentCommandParser().parse(arguments);

        case DeleteTutorialStudentCommand.COMMAND_WORD:
            return new DeleteTutorialStudentCommandParser().parse(arguments);

        case DeleteTutorialCommand.COMMAND_WORD:
            return new DeleteTutorialCommandParser().parse(arguments);

        case ListTutorialCommand.COMMAND_WORD:
            return new ListTutorialCommand();

        case AddModCommand.COMMAND_WORD:
            return new AddModCommandParser().parse(arguments);

        case DeleteModCommand.COMMAND_WORD:
            return new DeleteModCommandParser().parse(arguments);

        case ListModCommand.COMMAND_WORD:
            return new ListModCommand();

        case AddReminderCommand.COMMAND_WORD:
            return new AddReminderCommandParser().parse(arguments);

        case DeleteReminderCommand.COMMAND_WORD:
            return new DeleteReminderCommandParser().parse(arguments);

        case DoneReminderCommand.COMMAND_WORD:
            return new DoneReminderCommandParser().parse(arguments);

        case EditReminderCommand.COMMAND_WORD:
            return new EditReminderCommandParser().parse(arguments);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
