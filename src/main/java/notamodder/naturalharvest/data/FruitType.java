package notamodder.naturalharvest.data;

public enum FruitType {

    APPLE("apple"),
    BANANA("banana"),
    ORANGE("orange"),
    GRAPE("grape"),
    PEACH("peach"),
    PEAR("pear"),
    CHERRY("cherry"),
    PINEAPPLE("pineapple"),
    GRAPEFRUIT("grapefruit"),
    MANGO("mango"),
    AVOCADO("avocado"),
    KIWI("kiwi"),
    LEMON("lemon"),
    CANTALOUPE("cantaloupe"),
    APRICOT("apricot"),
    FIG("fig"),
    POMEGRANATE("pomegranate"),
    COCONUT("coconut"),
    DURIAN("durian"),
    OLIVE("olive"),
    QUINCE("quince"),
    PITAYA("pitaya"),
    LIME("lime"),
    GUAVA("guava");

    /**
     * A short name for the type. Used internally for unlocalized names, ids and variant names.
     * These should be all lower case and use underscores for spacing if needed.
     */
    private final String name;

    /**
     * Constructor for FruitType. Nothing is defaulted.
     *
     * @param name A short name for the type. Should be all lower case and use underscores for
     *        spacing if needed.
     */
    FruitType (String name) {

        this.name = name;
    }

    /**
     * Gets the internal name for the type.
     *
     * @return The internal name for the type.
     */
    public String getName () {

        return this.name;
    }
}