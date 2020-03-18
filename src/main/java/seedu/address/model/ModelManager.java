package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.event.consult.Consult;
import seedu.address.model.event.consult.ConsultTAble;
import seedu.address.model.event.consult.ReadOnlyConsult;
import seedu.address.model.event.tutorial.ReadOnlyTutorial;
import seedu.address.model.event.tutorial.Tutorial;
import seedu.address.model.event.tutorial.TutorialTAble;
import seedu.address.model.mod.Mod;
import seedu.address.model.mod.ModTAble;
import seedu.address.model.mod.ReadOnlyMod;
import seedu.address.model.reminder.ReadOnlyReminder;
import seedu.address.model.reminder.Reminder;
import seedu.address.model.reminder.ReminderTAble;
import seedu.address.model.student.Student;


/**
 * Represents the in-memory model of the address book data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final AddressBook addressBook;
    private final UserPrefs userPrefs;
    private final FilteredList<Student> filteredStudents;
    private final ConsultTAble consultTAble;
    private final FilteredList<Consult> filteredConsults;
    private final TutorialTAble tutorialTAble;
    private final FilteredList<Tutorial> filteredTutorials;
    private final ModTAble modTAble;
    private final FilteredList<Mod> filteredMods;
    private final ReminderTAble reminderTAble;
    private final FilteredList<Reminder> filteredReminders;

    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public ModelManager(ReadOnlyAddressBook addressBook, ReadOnlyUserPrefs userPrefs, ReadOnlyConsult consultTAble,
                        ReadOnlyTutorial tutorialTAble, ReadOnlyMod modTAble, ReadOnlyReminder reminderTAble) {
        super();
        requireAllNonNull(addressBook, userPrefs, consultTAble, tutorialTAble, modTAble, reminderTAble);

        logger.fine("Initializing with address book: " + addressBook + " , user prefs " + userPrefs
            + ", with consults " + consultTAble + " and modules in " + modTAble);

        this.addressBook = new AddressBook(addressBook);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredStudents = new FilteredList<>(this.addressBook.getStudentList());
        this.consultTAble = new ConsultTAble(consultTAble);
        filteredConsults = new FilteredList<>(this.consultTAble.getAllConsults());
        this.tutorialTAble = new TutorialTAble(tutorialTAble);
        filteredTutorials = new FilteredList<>(this.tutorialTAble.getAllTutorials());
        this.modTAble = new ModTAble(modTAble);
        filteredMods = new FilteredList<>(this.modTAble.getAllMods());
        this.reminderTAble = new ReminderTAble(reminderTAble);
        filteredReminders = new FilteredList<>(this.reminderTAble.getAllReminders());
    }

    public ModelManager() {
        this(new AddressBook(), new UserPrefs(), new ConsultTAble(), new TutorialTAble(),
                new ModTAble(), new ReminderTAble());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getAddressBookFilePath() {
        return userPrefs.getAddressBookFilePath();
    }

    @Override
    public void setAddressBookFilePath(Path addressBookFilePath) {
        requireNonNull(addressBookFilePath);
        userPrefs.setAddressBookFilePath(addressBookFilePath);
    }

    //=========== AddressBook ================================================================================

    @Override
    public void setAddressBook(ReadOnlyAddressBook addressBook) {
        this.addressBook.resetData(addressBook);
    }

    @Override
    public ReadOnlyAddressBook getAddressBook() {
        return addressBook;
    }

    @Override
    public boolean hasStudent(Student student) {
        requireNonNull(student);
        return addressBook.hasStudent(student);
    }

    @Override
    public void deleteStudent(Student target) {
        addressBook.removeStudent(target);
    }

    @Override
    public void addStudent(Student student) {
        addressBook.addStudent(student);
        updateFilteredStudentList(PREDICATE_SHOW_ALL_STUDENTS);
    }

    @Override
    public void setStudent(Student target, Student editedStudent) {
        requireAllNonNull(target, editedStudent);
        addressBook.setStudent(target, editedStudent);
    }

    /**
     * Gets student with specific index number.
     *
     * @param indexNumber Index number of student.
     * @return Student with index number specified.
     */
    public Student getStudent(int indexNumber) {
        return addressBook.getStudent(indexNumber);
    }

    //=========== Filtered Student List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Student} backed by the internal list of
     * {@code versionedAddressBook}
     */
    @Override
    public ObservableList<Student> getFilteredStudentList() {
        return filteredStudents;
    }

    @Override
    public void updateFilteredStudentList(Predicate<Student> predicate) {
        requireNonNull(predicate);
        filteredStudents.setPredicate(predicate);
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return addressBook.equals(other.addressBook)
                && userPrefs.equals(other.userPrefs)
                && filteredStudents.equals(other.filteredStudents);
    }

    // Consults section =======================================================

    @Override
    public boolean hasConsult(Consult consult) {
        requireNonNull(consult);
        return consultTAble.hasConsult(consult);
    }

    @Override
    public void addConsult(Consult consult) {
        consultTAble.addConsult(consult);
        updateFilteredStudentList(PREDICATE_SHOW_ALL_STUDENTS);
    }

    @Override
    public void deleteConsult(Consult target) {
        consultTAble.removeConsult(target);
    }

    @Override
    public void setConsult(Consult consultToEdit, Consult editedConsult) {
        requireAllNonNull(consultToEdit, editedConsult);
        consultTAble.setConsult(consultToEdit, editedConsult);
    }

    @Override
    public void clearConsults() {
        consultTAble.clearConsults();
    }

    @Override
    public ObservableList<Consult> getFilteredConsultList() {
        return filteredConsults;
    }

    @Override
    public void updateFilteredConsultList(Predicate<Consult> predicate) {
        requireNonNull(predicate);
        filteredConsults.setPredicate(predicate);
    }

    @Override
    public boolean hasSameDateTime(Consult consult) {
        requireAllNonNull(consult, consultTAble);
        return consultTAble.hasSameDateTime(consult);
    }

    @Override
    public ReadOnlyConsult getConsultTAble() {
        return consultTAble;
    }

    // Tutorials section ==========================================================================

    @Override
    public boolean hasTutorial(Tutorial tutorial) {
        requireNonNull(tutorial);
        return tutorialTAble.hasTutorial(tutorial);
    }

    @Override
    public void addTutorial(Tutorial tutorial) {
        tutorialTAble.addTutorial(tutorial);
    }

    @Override
    public void deleteTutorial(Tutorial target) {
        tutorialTAble.removeTutorial(target);
    }

    @Override
    public ObservableList<Tutorial> getFilteredTutorialList() {
        return filteredTutorials;
    }

    @Override
    public void updateFilteredTutorialList(Predicate<Tutorial> predicate) {
        requireNonNull(predicate);
        filteredTutorials.setPredicate(predicate);
    }

    @Override
    public boolean hasSameTiming(Tutorial tutorial) {
        requireAllNonNull(tutorial, tutorialTAble);
        return tutorialTAble.hasSameTiming(tutorial);
    }

    @Override
    public ReadOnlyTutorial getTutorialTAble() {
        return tutorialTAble;
    }

    // Modules section ==========================================================================

    @Override
    public boolean hasMod(Mod mod) {
        requireNonNull(mod);
        return modTAble.hasMod(mod);
    }

    @Override
    public void addMod(Mod mod) {
        modTAble.addMod(mod);
    }

    @Override
    public void deleteMod(Mod target) {
        modTAble.removeMod(target);
    }

    @Override
    public ObservableList<Mod> getFilteredModList() {
        return filteredMods;
    }

    @Override
    public void updateFilteredModList(Predicate<Mod> predicate) {
        requireNonNull(predicate);
        filteredMods.setPredicate(predicate);
    }

    // Reminders section ==========================================================================

    @Override
    public boolean hasReminder(Reminder reminder) {
        requireNonNull(reminder);
        return reminderTAble.hasReminder(reminder);
    }

    @Override
    public void addReminder(Reminder reminder) {
        reminderTAble.addReminder(reminder);
    }

    @Override
    public void deleteReminder(Reminder target) {
        reminderTAble.removeReminder(target);
    }

    @Override
    public void setReminder(Reminder reminderToEdit, Reminder editedReminder) {
        requireAllNonNull(reminderToEdit, editedReminder);
        reminderTAble.setReminder(reminderToEdit, editedReminder);
    }

    @Override
    public Reminder doneReminder(Reminder target) {
        return reminderTAble.markReminderAsDone(target);
    }

    @Override
    public ObservableList<Reminder> getFilteredReminderList() {
        return filteredReminders;
    }

    @Override
    public void updateFilteredReminderList(Predicate<Reminder> predicate) {
        requireNonNull(predicate);
        filteredReminders.setPredicate(predicate);
    }

    @Override
    public ReadOnlyReminder getReminderTAble() {
        return reminderTAble;
    }
}
