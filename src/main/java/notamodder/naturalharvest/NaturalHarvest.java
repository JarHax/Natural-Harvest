package notamodder.naturalharvest;

import static notamodder.naturalharvest.NaturalHarvest.MODID;
import static notamodder.naturalharvest.NaturalHarvest.NAME;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import notamodder.naturalharvest.proxy.CommonProxy;
import notamodder.notalib.utils.RegistryHelper;
import notamodder.notalib.world.loot.LootHelper;

@Mod(modid = MODID, name = NAME, version = "@VERSION@")
public class NaturalHarvest {

    public static final String MODID = "naturalharvest";
    public static final String NAME = "Natural Harvest";

    @Mod.Instance(MODID)
    public static NaturalHarvest INSTANCE;

    @SidedProxy(clientSide = "notamodder.naturalharvest.proxy.ClientProxy", serverSide = "notamodder.naturalharvest.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static RegistryHelper registry = new RegistryHelper(MODID);
    public static LootHelper lootReg = new LootHelper(MODID);

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
