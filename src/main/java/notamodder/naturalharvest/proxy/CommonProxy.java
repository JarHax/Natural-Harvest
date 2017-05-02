package notamodder.naturalharvest.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import notamodder.naturalharvest.NaturalHarvest;
import notamodder.naturalharvest.data.HarvestItems;

/**
 * This class contains code which is meant to be executed on both the client and server. Any
 * overriden methods should super call back to this one.
 */
public class CommonProxy {

    public void preInit (FMLPreInitializationEvent event) {

        NaturalHarvest.registry.registerItem(HarvestItems.JELLYFISH, "jellyfish");

        // OreDictionary.registerOre("", ore);
    }

    public void init (FMLInitializationEvent event) {

    }

    public void postInit (FMLPostInitializationEvent event) {

    }
}
