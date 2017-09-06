package com.jarhax.naturalharvest.proxy;

import com.jarhax.naturalharvest.NaturalHarvest;
import com.jarhax.naturalharvest.data.HarvestItems;

import net.darkhax.bookshelf.data.ColorHandlers;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * This class handles all the client side only loading for the mod.
 */
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit (FMLPreInitializationEvent event) {

        super.preInit(event);
    }

    @Override
    public void init (FMLInitializationEvent event) {

        super.init(event);

        // Item Color Handlers
        NaturalHarvest.registry.registerColorHandler(HarvestItems.JELLYFISH, ColorHandlers.ITEM_MCCOLOR);
    }

    @Override
    public void postInit (FMLPostInitializationEvent event) {

        super.postInit(event);
    }
}