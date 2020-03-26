package seedu.address.model.mod;

/**
 * Data structure of module link together with its descriptor.
 */
public class ModLinkPair {
    private ModLink modLink;
    private String name;

    public ModLinkPair(String name, ModLink modLink) {
        this.modLink = modLink;
        this.name = name;
    }

    public String getKey() {
        return name;
    }

    public ModLink getValue() {
        return modLink;
    }
}
