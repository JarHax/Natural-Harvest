package com.jarhax.naturalharvest.item;

import net.darkhax.bookshelf.item.ItemSubType;

public class ItemHarvestFish extends ItemSubType {

    public static final String[] VARIANTS = { "bass", "red_snapper", "trout" };

    @Override
    public String[] getVariant () {

        return VARIANTS;
    }

    @Override
    public String getPrefix () {

        return "";
    }
}
