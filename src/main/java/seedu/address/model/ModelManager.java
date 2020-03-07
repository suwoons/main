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
import seedu.address.model.event.tutorial.Tutorial;
import seedu.address.model.event.tutorial.TutorialTAble;
import seedu.address.model.event.tutorial.ReadOnlyTutorial;
import seedu.address.model.person.Person;

/**
 * Represents the in-memory model of the address book data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final AddressBook addressBook;
    private final UserPrefs userPrefs;
    private final FilteredList<Person> filteredPersons;
    private final ConsultTAble consultTAble;
    private final FilteredList<Consult> filteredConsults;
    private final TutorialTAble tutorialTAble;
    private final FilteredList<Tutorial> filteredTutorials;

    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public ModelManager(ReadOnlyAddressBook addressBook, ReadOnlyUserPrefs userPrefs, ReadOnlyConsult consultTAble,
                        ReadOnlyTutorial tutorialTAble) {
        super();
        requireAllNonNull(addressBook, userPrefs, consultTAble, tutorialTAble);

        logger.fine("Initializing with address book: " + addressBook + " ,user prefs " + userPrefs
            + " and " + consultTAble);

        this.addressBook = new AddressBook(addressBook);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredPersons = new FilteredList<>(this.addressBook.getPersonList());
        this.consultTAble = new ConsultTAble(consultTAble);
        filteredConsults = new FilteredList<>(this.consultTAble.getAllConsults());
        this.tutorialTAble = new TutorialTAble(tutorialTAble);
        filteredTutorials = new FilteredList<>(this.tutorialTAble.getAllTutorials());
    }

    public ModelManager() {
        this(new AddressBook(), new UserPrefs(), new ConsultTAble(), new TutorialTAble());
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
    public boolean hasPerson(Person person) {
        requireNonNull(person);
        return addressBook.hasPerson(person);
    }

    @Override
    public void deletePerson(Person target) {
        addressBook.removePerson(target);
    }

    @Override
    public void addPerson(Person person) {
        addressBook.addPerson(person);
        updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
    }

    @Override
    public void setPerson(Person target, Person editedPerson) {
        requireAllNonNull(target, editedPerson);
        addressBook.setPerson(target, editedPerson);
    }

    /**
     * Gets student with specific index number.
     *
     * @param indexNumber Index number of student.
     * @return Student with index number specified.
     */
    public Person getStudent(int indexNumber) {
        return addressBook.getStudent(indexNumber);
    }

    //=========== Filtered Person List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Person} backed by the internal list of
     * {@code versionedAddressBook}
     */
    @Override
    public ObservableList<Person> getFilteredPersonList() {
        return filteredPersons;
    }

    @Override
    public void updateFilteredPersonList(Predicate<Person> predicate) {
        requireNonNull(predicate);
        filteredPersons.setPredicate(predicate);
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
                && filteredPersons.equals(other.filteredPersons);
    }

    // Consults section

    @Override
    public boolean hasConsult(Consult consult) {
        requireNonNull(consult);
        return addressBook.hasConsult(consult);
    }

    @Override
    public void addConsult(Consult consult) {
        addressBook.addConsult(consult);
        updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
    }

    @Override
    public void deleteConsult(Consult target) {
        consultTAble.removeConsult(target);
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

    // Tutorials section

    @Override
    public boolean hasTutorial(Tutorial tutorial) {
        requireNonNull(tutorial);
        return addressBook.hasTutorial(tutorial);
    }

    @Override
    public void addTutorial(Tutorial tutorial) {
        addressBook.addTutorial(tutorial);
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
}
