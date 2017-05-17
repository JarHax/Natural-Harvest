package com.jarhax.naturalharvest;

import static com.jarhax.naturalharvest.NaturalHarvest.MODID;
import static com.jarhax.naturalharvest.NaturalHarvest.NAME;

import com.jarhax.naturalharvest.proxy.CommonProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import notamodder.notalib.utils.RegistryHelper;

@Mod(modid = MODID, name = NAME, version = "@VERSION@")
public class NaturalHarvest {

    public static final String MODID = "naturalharvest";
    public static final String NAME = "Natural Harvest";

    @Mod.Instance(MODID)
    public static NaturalHarvest INSTANCE;

    @SidedProxy(clientSide = "com.jarhax.naturalharvest.proxy.ClientProxy", serverSide = "com.jarhax.naturalharvest.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static RegistryHelper registry = new RegistryHelper(MODID).setTab(new CreativeTabs(MODID) {

        // TODO make a proper creative tab
        @Override
        public ItemStack getTabIconItem () {

            return new ItemStack(Items.SUGAR);
        }

    });

    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent event) {

        proxy.preInit(event);
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
