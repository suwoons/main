package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

import seedu.address.model.event.tutorial.Tutorial;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    private final String feedbackToUser;

    /** Help information should be shown to the user. */
    private final boolean showHelp;

    /** The application should exit. */
    private final boolean exit;

    /** The application should show the calendar. */
    private final boolean showCalendar;

    /** The application should show the relevant attendance list for specified tutorial and week */
    private final boolean showAttendance;
    private final Tutorial tutorialToShow;
    private final int weekZeroBased;

    /**
     * Constructs a {@code CommandResult} for a calendar command.
     */
    public CommandResult(String feedbackToUser, boolean showCalendar, boolean showHelp, boolean exit) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.showCalendar = showCalendar;
        this.showHelp = showHelp;
        this.exit = exit;
        this.showAttendance = false;
        this.tutorialToShow = null;
        this.weekZeroBased = 0;
    }

    /**
     * Constructs a {@code CommandResult} for a ListTutorial command.
     */
    public CommandResult(String feedbackToUser, Tutorial tutorial, int weekZeroBased) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.showCalendar = false;
        this.showHelp = false;
        this.exit = false;
        this.showAttendance = true;
        this.tutorialToShow = tutorial;
        this.weekZeroBased = weekZeroBased;
    }

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.showHelp = showHelp;
        this.exit = exit;
        this.showCalendar = false;
        this.showAttendance = false;
        this.tutorialToShow = null;
        this.weekZeroBased = 0;
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser},
     * and other fields set to their default value.
     */
    public CommandResult(String feedbackToUser) {
        this(feedbackToUser, false, false);
    }

    public String getFeedbackToUser() {
        return feedbackToUser;
    }

    public Tutorial getTutorialToShow() {
        return tutorialToShow;
    }

    public int getWeekZeroBased() {
        return weekZeroBased;
    }

    public boolean isShowHelp() {
        return showHelp;
    }

    public boolean isExit() {
        return exit;
    }

    public boolean isShowCalendar() {
        return showCalendar;
    }

    public boolean isShowAttendance() {
        return showAttendance;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CommandResult)) {
            return false;
        }

        CommandResult otherCommandResult = (CommandResult) other;
        return feedbackToUser.equals(otherCommandResult.feedbackToUser)
                && showHelp == otherCommandResult.showHelp
                && showCalendar == otherCommandResult.showCalendar
                && exit == otherCommandResult.exit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackToUser, showHelp, showCalendar, exit);
    }

}
