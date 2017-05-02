package notamodder.naturalharvest;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.event.*;
import notamodder.naturalharvest.data.HarvestEvents;
import notamodder.naturalharvest.proxy.CommonProxy;
import notamodder.notalib.utils.RegistryHelper;

import static notamodder.naturalharvest.NaturalHarvest.*;

@Mod(modid = MODID, name = NAME, version = "@VERSION@")
public class NaturalHarvest {

    public static final String MODID = "naturalharvest";
    public static final String NAME = "Natural Harvest";

    @Mod.Instance(MODID)
    public static NaturalHarvest INSTANCE;

    @SidedProxy(clientSide = "notamodder.naturalharvest.proxy.ClientProxy", serverSide = "notamodder.naturalharvest.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static RegistryHelper registry = new RegistryHelper(MODID);

    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent event) {

        proxy.preInit(event);
        MinecraftForge.EVENT_BUS.register(new HarvestEvents());
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
