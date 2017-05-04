package notamodder.naturalharvest.item;

import notamodder.notalib.item.ItemSubType;

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
