package seedu.address.model.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.event.Location;
import seedu.address.model.event.consult.Consult;
import seedu.address.model.event.consult.ConsultTAble;
import seedu.address.model.event.consult.ReadOnlyConsult;
import seedu.address.model.event.tutorial.ReadOnlyTutorial;
import seedu.address.model.event.tutorial.Tutorial;
import seedu.address.model.event.tutorial.TutorialName;
import seedu.address.model.event.tutorial.TutorialTAble;
import seedu.address.model.mod.Mod;
import seedu.address.model.mod.ModCode;
import seedu.address.model.mod.ModTAble;
import seedu.address.model.mod.ReadOnlyMod;
import seedu.address.model.reminder.ReadOnlyReminder;
import seedu.address.model.reminder.Reminder;
import seedu.address.model.reminder.ReminderTAble;
import seedu.address.model.student.Email;
import seedu.address.model.student.MatricNumber;
import seedu.address.model.student.Name;
import seedu.address.model.student.Remark;
import seedu.address.model.student.Student;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Student[] getSampleStudents() {
        return new Student[] {
            new Student(new Name("Alex Yeoh"), new MatricNumber("87438807"), new Email("alexyeoh@example.com"),
                getTagSet("friends"), new Remark("Nice")),
            new Student(new Name("Bernice Yu"), new MatricNumber("99272758"), new Email("berniceyu@example.com"),
                getTagSet("colleagues", "friends"), new Remark("Pretty")),
            new Student(new Name("Charlotte Oliveiro"), new MatricNumber("93210283"),
                    new Email("charlotte@example.com"), getTagSet("neighbours"), new Remark("Italian")),
            new Student(new Name("David Li"), new MatricNumber("91031282"), new Email("lidavid@example.com"),
                getTagSet("family"), new Remark("Handsome")),
            new Student(new Name("Irfan Ibrahim"), new MatricNumber("92492021"), new Email("irfan@example.com"),
                getTagSet("classmates"), new Remark("Kind")),
            new Student(new Name("Roy Balakrishnan"), new MatricNumber("92624417"), new Email("royb@example.com"),
                getTagSet("colleagues"), new Remark("Fake"))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Student sampleStudent : getSampleStudents()) {
            sampleAb.addStudent(sampleStudent);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    public static ReadOnlyConsult getSampleConsults() {
        LocalDateTime startDateTime = LocalDateTime.now();
        LocalDateTime endDateTime = LocalDateTime.now().plusHours(3);
        Location location = new Location("SR1");
        Consult consult = new Consult(startDateTime, endDateTime, location);
        ArrayList<Consult> consultList = new ArrayList<>();
        consultList.add(consult);
        ConsultTAble sampleConsultTAble = new ConsultTAble(consultList);
        return sampleConsultTAble;
    }

    public static ReadOnlyTutorial getSampleTutorials() {
        ModCode modCode = new ModCode("CS2103");
        TutorialName tutorialName = new TutorialName("T03");
        DayOfWeek weekday = DayOfWeek.WEDNESDAY;
        LocalTime startTime = LocalTime.now();
        LocalTime endTime = LocalTime.now().plusHours(2);
        Location location = new Location("SR1");
        Tutorial tutorial = new Tutorial(modCode, tutorialName, weekday, startTime, endTime, location);
        ArrayList<Tutorial> tutorialList = new ArrayList<>();
        tutorialList.add(tutorial);
        TutorialTAble sampleTutorialTAble = new TutorialTAble(tutorialList);
        return sampleTutorialTAble;
    }

    public static ReadOnlyMod getSampleMods() {
        ModCode modCode = new ModCode("CS2103");
        String modName = "Software Engineering";
        Mod mod = new Mod(modCode, modName);
        ArrayList<Mod> modList = new ArrayList<>();
        modList.add(mod);
        ModTAble sampleModTAble = new ModTAble(modList);
        return sampleModTAble;
    }

    public static ReadOnlyReminder getSampleReminders() {
        String description = "Mark T02 midterms papers.";
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.parse("15:00", DateTimeFormatter.ofPattern("HH:mm"));
        Reminder reminder = new Reminder(description, date, time, false);
        ArrayList<Reminder> reminderList = new ArrayList<>();
        reminderList.add(reminder);
        ReminderTAble sampleReminderTAble = new ReminderTAble(reminderList);
        return sampleReminderTAble;
    }

}
