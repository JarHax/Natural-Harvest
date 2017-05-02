package notamodder.naturalharvest.proxy;

import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
        NaturalHarvest.lootReg.addLoot(LootTableList.GAMEPLAY_FISHING_FISH, "jellyfish", "main", 2, HarvestItems.JELLYFISH);
    }

    public void init (FMLInitializationEvent event) {

    }

    public void postInit (FMLPostInitializationEvent event) {

        // TreeTap Registry
        // TODO make this actually work for all the woods, it messes up when the log is placed
        // on a different axis, would possibly be better moving to ItemStacks to hold the info
        // or just the plain old Block
        for (final BlockPlanks.EnumType type : BlockPlanks.EnumType.values()) {
            IBlockState state;
            if (type.getMetadata() < 4)
                state = Blocks.LOG.getStateFromMeta(type.getMetadata());
            else
                state = Blocks.LOG2.getStateFromMeta(type.getMetadata());
            Registry.registerTreeTapping(state, new ItemStack(Items.SLIME_BALL));
        }
        System.out.println(Registry.getTreeTappingRegistry());
    }
}
