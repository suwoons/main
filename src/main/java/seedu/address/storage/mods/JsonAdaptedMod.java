package seedu.address.storage.mods;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.mod.Mod;
import seedu.address.model.mod.ModCode;

/**
 * Jackson-friendly version of {@link Mod}.
 */

public class JsonAdaptedMod {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Module's %s field is missing!";

    private final String modCode;
    private final String modName;

    /**
     * Constructs a {@code JsonAdaptedMod} with the given module details.
     */
    @JsonCreator
    public JsonAdaptedMod(@JsonProperty("modCode") String modCode,
                          @JsonProperty("modName") String modName) {
        this.modCode = modCode;
        this.modName = modName;
    }

    /**
     * Converts a given {@code Mod} into this class for Jackson use.
     */
    public JsonAdaptedMod(Mod source) {
        modCode = source.getModCode().toString();
        modName = source.getName();
    }

    /**
     * Converts this Jackson-friendly adapted module object into the model's {@code Mod} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted module.
     */
    public Mod toModelType() throws IllegalValueException {

        if (modCode == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "MOD_CODE"));
        }

        if (modName == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, "MOD_NAME"));
        }

        ModCode modelModCode;
        String modelModName;

        modelModCode = new ModCode(modCode);
        modelModName = modName;

        return new Mod(modelModCode, modelModName);
    }
}

