package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.commands.consults.AddConsultCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.event.consult.Consult;
import seedu.address.model.event.consult.ReadOnlyConsult;
import seedu.address.model.event.tutorial.ReadOnlyTutorial;
import seedu.address.model.event.tutorial.Tutorial;
import seedu.address.model.mod.Mod;
import seedu.address.model.reminder.ReadOnlyReminder;
import seedu.address.model.reminder.Reminder;
import seedu.address.model.student.Student;
import seedu.address.testutil.ConsultBuilder;


public class AddConsultCommandTest {

    @Test
    public void constructor_nullConsult_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new AddConsultCommand(null));
    }

    @Test
    public void execute_consultAcceptedByModel_addSuccessful() throws Exception {
        AddConsultCommandTest.ModelStubAcceptingConsultAdded modelStub =
                new AddConsultCommandTest.ModelStubAcceptingConsultAdded();
        Consult validConsult = new ConsultBuilder().build();

        CommandResult commandResult = new AddConsultCommand(validConsult).execute(modelStub);

        assertEquals(String.format(AddConsultCommand.MESSAGE_SUCCESS, validConsult), commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validConsult), modelStub.consultsAdded);
    }

    @Test
    public void execute_duplicateConsult_throwsCommandException() throws ParseException {
        Consult validConsult = new ConsultBuilder().build();
        AddConsultCommand addConsultCommand = new AddConsultCommand(validConsult);
        AddConsultCommandTest.ModelStub modelStub = new AddConsultCommandTest.ModelStubWithConsult(validConsult);

        assertThrows(CommandException.class, AddConsultCommand.MESSAGE_DUPLICATE_CONSULT, ()
            -> addConsultCommand.execute(modelStub));
    }

    @Test
    public void equals() throws ParseException {
        Consult c1 = new ConsultBuilder().withLocation("sr1").build();
        Consult c2 = new ConsultBuilder().withBeginDateTime("2020-02-02 12:00").withEndDateTime("2020-02-02 13:00")
                .build();
        AddConsultCommand addC1Command = new AddConsultCommand(c1);
        AddConsultCommand addC2Command = new AddConsultCommand(c2);

        // same object -> returns true
        assertTrue(addC1Command.equals(addC1Command));

        // same values -> returns true
        AddConsultCommand addSr1CommandCopy = new AddConsultCommand(c1);
        assertTrue(addC1Command.equals(addSr1CommandCopy));

        // different types -> returns false
        assertFalse(addC1Command.equals(1));

        // null -> returns false
        assertFalse(addC1Command.equals(null));

        // different timing -> returns false
        assertFalse(addC1Command.equals(addC2Command));
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getAddressBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addStudent(Student student) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBook(ReadOnlyAddressBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasStudent(Student student) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteStudent(Student target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setStudent(Student target, Student editedStudent) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Student> getFilteredStudentList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredStudentList(Predicate<Student> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasConsult(Consult consult) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addConsult(Consult consult) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteConsult(Consult target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setConsult(Consult consultToEdit, Consult editedConsult) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void clearConsults() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Consult> getFilteredConsultList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredConsultList(Predicate<Consult> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasSameTiming(Consult consult) {
            throw new AssertionError("This method should not be called");
        }

        @Override
        public ReadOnlyConsult getConsultTAble() {
            throw new AssertionError("This method should not be called");
        }

        @Override
        public boolean hasTutorial(Tutorial tutorial) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addTutorial(Tutorial tutorial) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteTutorial(Tutorial target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Tutorial> getFilteredTutorialList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredTutorialList(Predicate<Tutorial> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyTutorial getTutorialTAble() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasMod(Mod mod) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addMod(Mod mod) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteMod(Mod mod) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Mod> getFilteredModList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredModList(Predicate<Mod> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasReminder(Reminder reminder) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addReminder(Reminder reminder) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteReminder(Reminder target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setReminder(Reminder reminderToEdit, Reminder editedReminder) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Reminder doneReminder(Reminder target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Reminder> getFilteredReminderList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredReminderList(Predicate<Reminder> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyReminder getReminderTAble() {
            throw new AssertionError("This method should not be called.");
        }
    }

    /**
     * A Model stub that contains a single consult.
     */
    private class ModelStubWithConsult extends AddConsultCommandTest.ModelStub {
        private final Consult consult;

        ModelStubWithConsult(Consult consult) {
            requireNonNull(consult);
            this.consult = consult;
        }

        @Override
        public boolean hasConsult(Consult consult) {
            requireNonNull(consult);
            return this.consult.equals(consult);
        }
    }

    /**
     * A Model stub that always accept the consult being added.
     */
    private class ModelStubAcceptingConsultAdded extends AddConsultCommandTest.ModelStub {
        final ArrayList<Consult> consultsAdded = new ArrayList<>();

        @Override
        public boolean hasConsult(Consult consult) {
            requireNonNull(consult);
            return consultsAdded.stream().anyMatch(consult::equals);
        }

        @Override
        public void addConsult(Consult consult) {
            requireNonNull(consult);
            consultsAdded.add(consult);
        }

        @Override
        public boolean hasSameTiming(Consult consult) {
            return consultsAdded.stream().anyMatch(consult::timeClash);
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            return new AddressBook();
        }
    }
}
