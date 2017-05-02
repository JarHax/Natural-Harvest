package notamodder.naturalharvest.proxy;

import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.*;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.oredict.OreDictionary;
import notamodder.naturalharvest.NaturalHarvest;
import notamodder.naturalharvest.api.Registry;
import notamodder.naturalharvest.data.*;
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
    
    
    }

    public void init (FMLInitializationEvent event) {
    
    }

    public void postInit (FMLPostInitializationEvent event) {
        // TreeTap Registry
        // TODO make this actually work for all the woods, it messes up when the log is placed on a different axis, would possibly be better moving to ItemStacks to hold the info or just the plain old Block
        for(BlockPlanks.EnumType type : BlockPlanks.EnumType.values()) {
            IBlockState state;
            if(type.getMetadata() < 4) {
                state = Blocks.LOG.getStateFromMeta(type.getMetadata());
            } else {
                state = Blocks.LOG2.getStateFromMeta(type.getMetadata());
            }
            Registry.registerTreeTapping(state, new ItemStack(Items.SLIME_BALL));
        }
        System.out.println(Registry.getTreeTappingRegistry());
    }
}
