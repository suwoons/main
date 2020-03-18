package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.event.consult.Consult;
import seedu.address.model.event.consult.ReadOnlyConsult;
import seedu.address.model.event.tutorial.ReadOnlyTutorial;
import seedu.address.model.event.tutorial.Tutorial;
import seedu.address.model.mod.Mod;
import seedu.address.model.reminder.ReadOnlyReminder;
import seedu.address.model.reminder.Reminder;
import seedu.address.model.student.Student;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Student> PREDICATE_SHOW_ALL_STUDENTS = unused -> true;
    Predicate<Consult> PREDICATE_SHOW_ALL_CONSULTS = unused -> true;
    Predicate<Tutorial> PREDICATE_SHOW_ALL_TUTORIALS = unused -> true;
    Predicate<Mod> PREDICATE_SHOW_ALL_MODS = unused -> true;
    Predicate<Reminder> PREDICATE_SHOW_ALL_REMINDERS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /** Returns the AddressBook */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns true if a student with the same identity as {@code student} exists in the address book.
     */
    boolean hasStudent(Student student);

    /**
     * Deletes the given student.
     * The student must exist in the address book.
     */
    void deleteStudent(Student target);

    /**
     * Adds the given student.
     * {@code student} must not already exist in the address book.
     */
    void addStudent(Student student);

    /**
     * Replaces the given student {@code target} with {@code editedStudent}.
     * {@code target} must exist in the address book.
     * The student identity of {@code editedStudent} must not be the same as another existing student in Table.
     */
    void setStudent(Student target, Student editedStudent);

    /** Returns an unmodifiable view of the filtered student list */
    ObservableList<Student> getFilteredStudentList();

    /**
     * Updates the filter of the filtered student list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredStudentList(Predicate<Student> predicate);

    // Consult-level operations =======================================================================================

    /**
     * Returns true if a consult with the same identity as {@code consult} exists in TAble.
     */
    boolean hasConsult(Consult consult);

    /**
     * Adds the given consult.
     * {@code consult} must not already exist in TAble.
     */
    void addConsult(Consult consult);

    /**
     * Deletes the given consult.
     * The consult must exist in TAble.
     */
    void deleteConsult(Consult target);

    /**
     * Replaces the given consult {@code consultToEdit} with {@code editedConsult}.
     * {@code consultToEdit} must exist in TAble.
     * The student identity of {@code editedConsult} must not be the same as another existing consult in TAble.
     */
    void setConsult(Consult consultToEdit, Consult editedConsult);

    /**
     * Deletes all consults in the Consult TAble.
     */
    void clearConsults();

    /** Returns an unmodifiable view of the filtered consult list */
    ObservableList<Consult> getFilteredConsultList();

    /**
     * Updates the filter of the filtered consult list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredConsultList(Predicate<Consult> predicate);

    /**
     * Returns true if a {@code consult}'s timing clashes with another {@code consult}'s timing in TAble.
     */
    boolean hasSameDateTime(Consult consult);

    /** Returns the Consult TAble */
    ReadOnlyConsult getConsultTAble();

    // Tutorial-level operations =====================================================================================

    /**
     * Returns true if a tutorial with the same identity as {@code tutorial} exists in TAble.
     */
    boolean hasTutorial(Tutorial tutorial);

    /**
     * Adds the given tutorial.
     * {@code tutorial} must not already exist in TAble.
     */
    void addTutorial(Tutorial tutorial);

    /**
     * Deletes the given tutorial.
     * The tutorial must exist in TAble.
     */
    void deleteTutorial(Tutorial target);

    /** Returns an unmodifiable view of the filtered tutorial list */
    ObservableList<Tutorial> getFilteredTutorialList();

    /**
     * Updates the filter of the filtered tutorial list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredTutorialList(Predicate<Tutorial> predicate);

    /**
     * Returns true if a {@code tutorial}'s timing clashes with another {@code tutorial}'s timing in TAble.
     */
    boolean hasSameTiming(Tutorial tutorial);

    /** Returns the Tutorial TAble */
    ReadOnlyTutorial getTutorialTAble();

    // Mod-level operations =====================================================================================

    /**
     * Returns true if a module with the same identity as {@code mod} exists in TAble.
     */
    boolean hasMod(Mod mod);

    /**
     * Adds the given module.
     * {@code mod} must not already exist in TAble.
     */
    void addMod(Mod mod);

    /**
     * Deletes the given module.
     * The module must exist in TAble.
     */
    void deleteMod(Mod mod);

    /** Returns an unmodifiable view of the filtered module list */
    ObservableList<Mod> getFilteredModList();

    /**
     * Updates the filter of the filtered module list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredModList(Predicate<Mod> predicate);

    // Reminder-level operations =====================================================================================

    /**
     * Returns true if a reminder with the same identity as {@code reminder} exists in TAble.
     */
    boolean hasReminder(Reminder reminder);

    /**
     * Adds the given reminder.
     * {@code reminder} must not already exist in TAble.
     */
    void addReminder(Reminder reminder);

    /**
     * Deletes the given reminder.
     * The reminder must exist in TAble.
     */
    void deleteReminder(Reminder target);

    /**
     * Replaces the given reminder {@code reminderToEdit} with {@code editedReminder}.
     * {@code reminderToEdit} must exist in TAble.
     * The identity of {@code editedReminder} must not be the same as another existing reminder in TAble.
     */
    void setReminder(Reminder reminderToEdit, Reminder editedReminder);

    /**
     * Marks the given reminder as done.
     * The reminder must exist in TAble.
     */
    Reminder doneReminder(Reminder target);

    /** Returns an unmodifiable view of the filtered reminder list */
    ObservableList<Reminder> getFilteredReminderList();

    /**
     * Updates the filter of the filtered reminder list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredReminderList(Predicate<Reminder> predicate);

    /** Returns the Reminder TAble */
    ReadOnlyReminder getReminderTAble();
}
