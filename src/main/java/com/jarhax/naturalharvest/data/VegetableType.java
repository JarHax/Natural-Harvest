package com.jarhax.naturalharvest.data;

public enum VegetableType {

    SPINACH("spinach"),
    ONION("onion"),
    BROCCOLI("broccoli"),
    TOMATO("tomato"),
    CABBAGE("cabbage"),
    PEA("pea"),
    CAULIFLOWER("cauliflower"),
    LETTUCE("lettuce"),
    CORN("corn"),
    CUCUMBER("cucumber"),
    TURNIP("turnip"),
    EGGPLANT("eggplant"),
    RADISH("radish"),
    ZUCCHINI("zucchini"),
    GARLIC("garlic"),
    LEEK("leek"),
    BELLPEPPER("bellpepper"),
    CHILIPEPPER("chilipepper"),
    SCALLION("scallion"),
    RHUBARB("rhubarb"),
    DAIKON("daikon");

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
    VegetableType (String name) {

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
