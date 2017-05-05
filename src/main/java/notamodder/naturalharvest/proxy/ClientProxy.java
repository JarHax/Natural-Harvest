package notamodder.naturalharvest.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import notamodder.naturalharvest.NaturalHarvest;
import notamodder.naturalharvest.data.HarvestBlocks;
import notamodder.naturalharvest.data.HarvestItems;
import notamodder.notalib.lib.ColorHandlers;

/**
 * This class handles all the client side only loading for the mod.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit (FMLPreInitializationEvent event) {

        super.preInit(event);

        // Item Models
        NaturalHarvest.registry.registerInventoryModel(HarvestItems.JELLYFISH);
        NaturalHarvest.registry.registerInventoryModel(HarvestItems.FISH);

        // Block Models
        NaturalHarvest.registry.registerInventoryModel(HarvestBlocks.TREE_TAP);
    }

    @Override
    public void init (FMLInitializationEvent event) {

        super.init(event);

        // Item Color Handlers
        NaturalHarvest.registry.registerColorHandler(HarvestItems.JELLYFISH, ColorHandlers.ITEM_NBT);
    }

    @Override
    public void postInit (FMLPostInitializationEvent event) {

        super.postInit(event);
    }
}
