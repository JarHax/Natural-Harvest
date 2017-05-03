package notamodder.naturalharvest.proxy;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import notamodder.naturalharvest.NaturalHarvest;
import notamodder.naturalharvest.api.Registry;
import notamodder.naturalharvest.data.HarvestBlocks;
import notamodder.naturalharvest.data.HarvestItems;
import notamodder.notalib.utils.OreDictEntries;

/**
 * This class contains code which is meant to be executed on both the client and server. Any
 * overriden methods should super call back to this one.
 */
public class CommonProxy {

    public void preInit (FMLPreInitializationEvent event) {

        // Item Registry
        NaturalHarvest.registry.registerItem(HarvestItems.JELLYFISH, "jellyfish");

        // Block Registry
        NaturalHarvest.registry.registerBlock(HarvestBlocks.TREE_TAP, "tree_tap");

        // OreDict
        OreDictionary.registerOre(OreDictEntries.SLIMEBALL, HarvestItems.JELLYFISH);

        // Loot
        NaturalHarvest.registry.addLoot(LootTableList.GAMEPLAY_FISHING_FISH, "jellyfish", "main", 2, HarvestItems.JELLYFISH);
    }

    public void init (FMLInitializationEvent event) {

    }

    public void postInit (FMLPostInitializationEvent event) {

        // TreeTap Registry
        Registry.addTreeTapRecipe(new ItemStack(Blocks.LOG, 1, 0), new ItemStack(HarvestItems.JELLYFISH), 100);
        Registry.addTreeTapRecipe(new ItemStack(Blocks.LOG, 1, 1), new ItemStack(HarvestItems.JELLYFISH), 100);
        Registry.addTreeTapRecipe(new ItemStack(Blocks.LOG, 1, 2), new ItemStack(HarvestItems.JELLYFISH), 100);
        Registry.addTreeTapRecipe(new ItemStack(Blocks.LOG, 1, 3), new ItemStack(HarvestItems.JELLYFISH), 100);
        Registry.addTreeTapRecipe(new ItemStack(Blocks.LOG2, 1, 0), new ItemStack(HarvestItems.JELLYFISH), 100);
        Registry.addTreeTapRecipe(new ItemStack(Blocks.LOG2, 1, 1), new ItemStack(HarvestItems.JELLYFISH), 100);
    }
}
