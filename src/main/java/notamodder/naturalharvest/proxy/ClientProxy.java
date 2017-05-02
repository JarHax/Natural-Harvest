package notamodder.naturalharvest.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import notamodder.naturalharvest.NaturalHarvest;
import notamodder.naturalharvest.data.HarvestItems;
import notamodder.notalib.client.render.color.ItemColorNBT;

/**
 * This class handles all the client side only loading for the mod.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit (FMLPreInitializationEvent event) {

        super.preInit(event);

        // Item Models
        NaturalHarvest.registry.registerInventoryModel(HarvestItems.JELLYFISH);
    }

    @Override
    public void init (FMLInitializationEvent event) {

        super.init(event);

        // Item Color Handlers
        System.out.println("Client");
        NaturalHarvest.registry.registerColorHandler(HarvestItems.JELLYFISH, ItemColorNBT.INSTANCE);
    }

    @Override
    public void postInit (FMLPostInitializationEvent event) {

        super.postInit(event);
    }
}
