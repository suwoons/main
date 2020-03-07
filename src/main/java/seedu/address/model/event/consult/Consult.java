package seedu.address.model.event.consult;

import java.time.LocalDateTime;

import seedu.address.model.event.Event;
import seedu.address.model.event.Location;
//import seedu.address.model.person.Person;

/**
 * Represents a Consultation in TAble. Consultations extends from the abstract class Event.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Consult extends Event {

    //private Person student;

    public Consult(LocalDateTime eventStartTime, LocalDateTime eventEndTime,
                   Location location) {
        super(eventStartTime, eventEndTime, location);
        //this.student = student;
    }
}
