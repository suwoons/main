package seedu.address.model.mod;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;

/**
 * Wraps all module data at the ModTAble level
 * Duplicates are not allowed
 */

public class ModTAble implements ReadOnlyMod {

    private final UniqueModList mods;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        mods = new UniqueModList();
    }

    public ModTAble() {}

    /**
     * Creates a ModTAble using the modules in the {@code toBeCopied}
     */
    public ModTAble(ReadOnlyMod toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    /**
     * Creates a ModTAble using the tutorials in the {@code modList}
     */
    public ModTAble(List<Mod> modList) {
        this.mods.setMods(modList);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the module list with {@code mods}.
     * {@code tutorials} must not contain duplicate modules.
     */
    public void setMods(List<Mod> mods) {
        this.mods.setMods(mods);
    }

    /**
     * Resets the existing data of this {@code ModTAble} with {@code newData}.
     */
    public void resetData(ReadOnlyMod newData) {
        requireNonNull(newData);
        setMods(newData.getAllMods());
    }

    //// Mod-level operations

    /**
     * Returns true if a module with the same identity as {@code module} exists in TAble.
     */
    public boolean hasMod(Mod module) {
        requireNonNull(module);
        return mods.contains(module);
    }

    /**
     * Adds a module to TAble.
     * The module must not already exist in TAble.
     */
    public void addMod(Mod module) {
        mods.add(module);
    }


    /**
     * Removes {@code key} from this {@code ModTAble}.
     * {@code key} must exist in the ModTAble.
     */
    public void removeMod(Mod key) {
        mods.remove(key);
    }


    /**
     * Returns {@code mod} from {@code TAble}.
     * {@code module} must exist in the address book.
     */
    public Mod getMod(int index) {
        return mods.getMod(index);
    }

    //// util methods

    @Override
    public String toString() {
        return mods.asUnmodifiableObservableList().size() + " modules";
        // TODO: refine later
    }

    @Override
    public ObservableList<Mod> getAllMods() {
        return mods.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof seedu.address.model.mod.ModTAble // instanceof handles nulls
                && mods.equals(((seedu.address.model.mod.ModTAble) other).mods));
    }

    @Override
    public int hashCode() {
        return mods.hashCode();
    }
}
