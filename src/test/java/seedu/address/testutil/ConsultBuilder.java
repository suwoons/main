package seedu.address.testutil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.event.Location;
import seedu.address.model.event.consult.Consult;

/**
 * A utility class to help with building Consult objects.
*/
public class ConsultBuilder {
    public static final String DEFAULT_BEGIN_DATE_TIME = "2020-03-03 15:00";
    public static final String DEFAULT_END_DATE_TIME = "2020-03-03 17:00";
    public static final String DEFAULT_LOCATION = "SR1";

    private LocalDateTime beginDateTime;
    private LocalDateTime endDateTime;
    private Location location;

    public ConsultBuilder() throws ParseException {
        beginDateTime = ParserUtil.parseDateTime(DEFAULT_BEGIN_DATE_TIME);
        endDateTime = ParserUtil.parseDateTime(DEFAULT_END_DATE_TIME);
        location = new Location(DEFAULT_LOCATION);
    }

    /**
     * Initializes the ConsultBuilder with the data of {@code consultToCopy}.
     */
    public ConsultBuilder(Consult consultToCopy) {
        beginDateTime = consultToCopy.getBeginDateTime();
        endDateTime = consultToCopy.getEndDateTime();
        location = consultToCopy.getLocation();
    }

    /**
     * Sets the {@code BeginDateTime} of the {@code Consult} that we are building.
     */
    public ConsultBuilder withBeginDateTime(String beginDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.beginDateTime = LocalDateTime.parse(beginDateTime, formatter);
        return this;
    }

    /**
     * Sets the {@code EndDateTime} of the {@code Consult} that we are building.
     */
    public ConsultBuilder withEndDateTime(String endDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.endDateTime = LocalDateTime.parse(endDateTime, formatter);
        return this;
    }

    /**
     * Sets the {@code Location} of the {@code Consult} that we are building.
     */
    public ConsultBuilder withLocation(String location) {
        this.location = new Location(location);
        return this;
    }


    public Consult build() {
        return new Consult(beginDateTime, endDateTime, location);
    }
}
