package notamodder.naturalharvest;

import static notamodder.naturalharvest.NaturalHarvest.MODID;
import static notamodder.naturalharvest.NaturalHarvest.NAME;
import static notamodder.naturalharvest.NaturalHarvest.VERSION;

import net.minecraft.item.Item;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import notamodder.naturalharvest.proxy.CommonProxy;
import notamodder.notalib.client.render.color.ItemColorNBT;
import notamodder.notalib.utils.RegistryHelper;
import notamodder.notalib.world.loot.functions.SetColor;

@Mod(modid = MODID, name = NAME, version = VERSION)
public class NaturalHarvest {

    public static final String MODID = "naturalharvest";
    public static final String NAME = "Natural Harvest";
    public static final String VERSION = "1.0.0.0";

    @Mod.Instance(MODID)
    public static NaturalHarvest INSTANCE;

    @SidedProxy(clientSide = "notamodder.naturalharvest.proxy.ClientProxy", serverSide = "notamodder.naturalharvest.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static RegistryHelper registry = new RegistryHelper(MODID);
    public static Item itemJellyfish;

    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent event) {

        itemJellyfish = registry.registerItem(new Item(), "jellyfish");
        registry.registerInventoryModel(itemJellyfish);

        // TODO make better loot system
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onTableLoad (LootTableLoadEvent event) {

        if (event.getName().equals(LootTableList.GAMEPLAY_FISHING_FISH)) {

            final LootPool pool = event.getTable().getPool("main");

            if (pool != null) {

                pool.removeEntry("minecraft:fish");
                pool.removeEntry("minecraft:fish#0");
                pool.removeEntry("minecraft:fish#1");
                pool.removeEntry("minecraft:fish#2");
                pool.addEntry(new LootEntryItem(itemJellyfish, 100, 0, new LootFunction[] { new SetColor(new LootCondition[] {}) }, new LootCondition[] {}, "modid:jellyfish"));
            }
        }
    }

    @Mod.EventHandler
    public void init (FMLInitializationEvent event) {

        registry.registerColorHandler(itemJellyfish, ItemColorNBT.INSTANCE);
    }

    @Mod.EventHandler
    public void postInit (FMLPostInitializationEvent event) {

    }
}
