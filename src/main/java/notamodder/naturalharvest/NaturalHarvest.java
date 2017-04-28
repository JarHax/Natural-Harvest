package notamodder.naturalharvest;

import net.minecraftforge.fml.common.*;
import net.minecraftforge.fml.common.event.*;
import notamodder.naturalharvest.proxy.CommonProxy;

import static notamodder.naturalharvest.NaturalHarvest.*;

@Mod(modid = MODID, name = NAME, version = VERSION)
public class NaturalHarvest {
    
    public static final String MODID = "naturalharvest";
    public static final String NAME = "Natural Harvest";
    public static final String VERSION = "1.0.0.0";
    
    @Mod.Instance(MODID)
    public static NaturalHarvest INSTANCE;
    
    @SidedProxy(clientSide = "notamodder.naturalharvest.proxy.ClientProxy", serverSide = "notamodder.naturalharvest.proxy.CommonProxy")
    public static CommonProxy PROXY;
    
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    
    }
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    
    }
}
