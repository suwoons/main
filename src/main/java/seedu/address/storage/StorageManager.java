package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;
import seedu.address.model.event.consult.ReadOnlyConsult;
import seedu.address.model.event.tutorial.ReadOnlyTutorial;
import seedu.address.model.mod.ReadOnlyMod;
import seedu.address.storage.consults.ConsultStorage;
import seedu.address.storage.mods.ModStorage;
import seedu.address.storage.tutorials.TutorialStorage;

/**
 * Manages storage of AddressBook data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private AddressBookStorage addressBookStorage;
    private UserPrefsStorage userPrefsStorage;
    private ConsultStorage consultStorage;
    private TutorialStorage tutorialStorage;
    private ModStorage modStorage;


    public StorageManager(AddressBookStorage addressBookStorage, UserPrefsStorage userPrefsStorage,
                          ConsultStorage consultStorage, TutorialStorage tutorialStorage, ModStorage modStorage) {
        super();
        this.addressBookStorage = addressBookStorage;
        this.userPrefsStorage = userPrefsStorage;
        this.consultStorage = consultStorage;
        this.tutorialStorage = tutorialStorage;
        this.modStorage = modStorage;
    }

    // ================ UserPrefs methods ==============================

    @Override
    public Path getUserPrefsFilePath() {
        return userPrefsStorage.getUserPrefsFilePath();
    }

    @Override
    public Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException {
        return userPrefsStorage.readUserPrefs();
    }

    @Override
    public void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException {
        userPrefsStorage.saveUserPrefs(userPrefs);
    }


    // ================ AddressBook methods ==============================

    @Override
    public Path getAddressBookFilePath() {
        return addressBookStorage.getAddressBookFilePath();
    }

    @Override
    public Optional<ReadOnlyAddressBook> readAddressBook() throws DataConversionException, IOException {
        return readAddressBook(addressBookStorage.getAddressBookFilePath());
    }

    @Override
    public Optional<ReadOnlyAddressBook> readAddressBook(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return addressBookStorage.readAddressBook(filePath);
    }

    @Override
    public void saveAddressBook(ReadOnlyAddressBook addressBook) throws IOException {
        saveAddressBook(addressBook, addressBookStorage.getAddressBookFilePath());
    }

    @Override
    public void saveAddressBook(ReadOnlyAddressBook addressBook, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        addressBookStorage.saveAddressBook(addressBook, filePath);
    }

    // ================ Consult methods ==============================

    @Override
    public Path getConsultsFilePath() {
        return consultStorage.getConsultsFilePath();
    }

    @Override
    public Optional<ReadOnlyConsult> readConsults() throws DataConversionException, IOException {
        return readConsults(consultStorage.getConsultsFilePath());
    }

    @Override
    public Optional<ReadOnlyConsult> readConsults(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return consultStorage.readConsults(filePath);
    }

    @Override
    public void saveConsults(ReadOnlyConsult consults) throws IOException {
        saveConsults(consults, consultStorage.getConsultsFilePath());
    }

    @Override
    public void saveConsults(ReadOnlyConsult consults, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        consultStorage.saveConsults(consults, filePath);
    }

    // ================ Tutorial methods ==============================

    @Override
    public Path getTutorialsFilePath() {
        return tutorialStorage.getTutorialsFilePath();
    }

    @Override
    public Optional<ReadOnlyTutorial> readTutorials() throws DataConversionException, IOException {
        return readTutorials(tutorialStorage.getTutorialsFilePath());
    }

    @Override
    public Optional<ReadOnlyTutorial> readTutorials(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return tutorialStorage.readTutorials(filePath);
    }

    @Override
    public void saveTutorials(ReadOnlyTutorial tutorials) throws IOException {
        saveTutorials(tutorials, tutorialStorage.getTutorialsFilePath());
    }

    @Override
    public void saveTutorials(ReadOnlyTutorial tutorials, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        tutorialStorage.saveTutorials(tutorials, filePath);
    }

    // ================ Module methods ==============================

    @Override
    public Path getModsFilePath() {
        return modStorage.getModsFilePath();
    }

    @Override
    public Optional<ReadOnlyMod> readMods() throws DataConversionException, IOException {
        return readMods(modStorage.getModsFilePath());
    }

    @Override
    public Optional<ReadOnlyMod> readMods(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return modStorage.readMods(filePath);
    }

    @Override
    public void saveMods(ReadOnlyMod mods) throws IOException {
        saveMods(mods, modStorage.getModsFilePath());
    }

    @Override
    public void saveMods(ReadOnlyMod mods, Path filePath) throws IOException {
        logger.fine("Attempting to write to data file: " + filePath);
        modStorage.saveMods(mods, filePath);
    }

}
