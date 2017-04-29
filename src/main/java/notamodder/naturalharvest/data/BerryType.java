package notamodder.naturalharvest.data;

public enum BerryType {

    BLACKBERRY("blackberry"),
    BLUEBERRY("blueberry"),
    ELDERBERRY("elderberry"),
    POKEBERRY("pokeberry", true),
    RASPBERRY("raspberry"),
    SALMONBERRY("salmonberry"),
    STRAWBERRY("strawberry"),
    WINTERGREEN("wintergreen"),
    NIGHTSHADE("nightshade", true);

    /**
     * A short name for the type. Used internally for unlocalized names, ids and variant names.
     * These should be all lower case and use underscores for spacing if needed.
     */
    private final String name;

    /**
     * Whether or not the berry type is toxic.
     */
    private final boolean toxic;

    /**
     * Constructor for BerryType. Defaults to non toxic.
     *
     * @param name A short name for the type. Should be all lower case and use underscores for
     *        spacing if needed.
     */
    BerryType (String name) {

        this(name, false);
    }

    /**
     * Constructor for BerryType. Nothing is defaulted.
     *
     * @param name A short name for the type. Should be all lower case and use underscores for
     *        spacing if needed.
     * @param toxic Whether or not the berry is toxic.
     */
    BerryType (String name, boolean toxic) {

        this.name = name;
        this.toxic = toxic;
    }

    /**
     * Gets the internal name for the type.
     *
     * @return The internal name for the type.
     */
    public String getName () {

        return this.name;
    }

    /**
     * Checks if the berry type is toxic.
     *
     * @return Whether or not the berry type is toxic.
     */
    public boolean isToxic () {

        return this.toxic;
    }
}
