package com.jarhax.naturalharvest;

import static com.jarhax.naturalharvest.NaturalHarvest.MODID;
import static com.jarhax.naturalharvest.NaturalHarvest.NAME;

import com.jarhax.naturalharvest.proxy.CommonProxy;
import com.jarhax.naturalharvest.registry.NaturalHarvestRegistries;

import net.darkhax.bookshelf.registry.RegistryHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MODID, name = NAME, version = "@VERSION@", certificateFingerprint = "@SHA1@")
public class NaturalHarvest {

    public static final String MODID = "naturalharvest";
    public static final String NAME = "Natural Harvest";

    @Mod.Instance(MODID)
    public static NaturalHarvest INSTANCE;

    @SidedProxy(clientSide = "com.jarhax.naturalharvest.proxy.ClientProxy", serverSide = "com.jarhax.naturalharvest.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static RegistryHelper registry = new RegistryHelper(MODID);

    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent event) {

        proxy.preInit(event);
        NaturalHarvestRegistries.init();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    public void init (FMLInitializationEvent event) {

        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit (FMLPostInitializationEvent event) {

        proxy.postInit(event);
    }
}
