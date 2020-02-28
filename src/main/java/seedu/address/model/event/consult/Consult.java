package seedu.address.model.event.consult;

import seedu.address.model.event.Event;
import seedu.address.model.person.Person;

import java.time.LocalDateTime;


/**
 * Represents a Consultation in TAble. Consultations extends from the abstract class Event.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Consult extends Event {

    private Person student;

    public Consult(String eventName, LocalDateTime eventStartTime, LocalDateTime eventEndTime, String location, Person student) {
        super(eventName, eventStartTime, eventEndTime, location);
        this.student = student;
    }
}
