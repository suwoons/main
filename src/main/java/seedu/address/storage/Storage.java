package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.ReadOnlyStudent;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;
import seedu.address.storage.consults.ConsultStorage;
import seedu.address.storage.mods.ModStorage;
import seedu.address.storage.reminders.ReminderStorage;
import seedu.address.storage.tutorials.TutorialStorage;

/**
 * API of the Storage component
 */
public interface Storage extends AddressBookStorage, UserPrefsStorage, ConsultStorage,
    TutorialStorage, ModStorage, ReminderStorage {

    @Override
    Optional<UserPrefs> readUserPrefs() throws DataConversionException, IOException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    @Override
    Path getAddressBookFilePath();

    @Override
    Optional<ReadOnlyStudent> readAddressBook() throws DataConversionException, IOException;

    @Override
    void saveAddressBook(ReadOnlyStudent addressBook) throws IOException;

}
