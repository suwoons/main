package seedu.address.model.mod;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 * Represents a Module in TAble.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Mod {

    // Identity fields
    private final ModCode modCode;
    private final String name;

    // Data fields
    private String description; //TODO update description
    private final Map<String, ModLink> links = new HashMap<>();

    /**
     * Every field must be present and not null.
     */
    public Mod(ModCode modCode, String name) {
        requireAllNonNull(modCode, name);
        this.modCode = modCode;
        this.name = name;
    }

    public ModCode getModCode() {
        return modCode;
    }

    public String getName() {
        return name;
    }

    /**
     * Returns an immutable map of description and links, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Map<String, ModLink> getLinks() {
        return Collections.unmodifiableMap(links);
    }

    /**
     * Returns true if both modules have the same module code.
     * This defines a weaker notion of equality between two modules.
     */
    public boolean isSameMod(seedu.address.model.mod.Mod otherMod) {
        if (otherMod == this) {
            return true;
        }

        return otherMod != null
                && otherMod.getModCode().equals(getModCode());
    }

    /**
     * Returns true if both persons have the same module code, description and tags.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof seedu.address.model.mod.Mod)) {
            return false;
        }

        seedu.address.model.mod.Mod otherMod = (seedu.address.model.mod.Mod) other;
        return otherMod.getModCode().equals(getModCode())
            && otherMod.getName().equals(getName())
            && otherMod.getLinks().equals(getLinks());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(modCode, name, links);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getModCode())
            .append(" Description: ")
            .append(getName())
                .append(" Links: ");
        getLinks().forEach((desc, link) -> builder.append(desc).append(" ").append(link).append("\n"));
        return builder.toString();
    }

}
