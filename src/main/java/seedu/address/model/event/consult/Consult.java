package seedu.address.model.event.consult;

import java.time.LocalDateTime;

import seedu.address.model.event.Event;
import seedu.address.model.event.EventLocation;
import seedu.address.model.event.EventName;
//import seedu.address.model.person.Person;

/**
 * Represents a Consultation in TAble. Consultations extends from the abstract class Event.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Consult extends Event {

    //private Person student;

    public Consult(EventName eventName, LocalDateTime eventStartTime, LocalDateTime eventEndTime,
                   EventLocation location) {
        super(eventName, eventStartTime, eventEndTime, location);
        //this.student = student;
    }
}
