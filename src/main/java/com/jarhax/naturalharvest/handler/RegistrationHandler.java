package com.jarhax.naturalharvest.handler;

import com.jarhax.naturalharvest.NaturalHarvest;
import com.jarhax.naturalharvest.api.treetap.ITreeTapRecipe;
import com.jarhax.naturalharvest.api.treetap.TreeTapRecipe;
import com.jarhax.naturalharvest.data.HarvestItems;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class RegistrationHandler {

    @SubscribeEvent
    public void registerBlocks (RegistryEvent.Register<Block> event) {

        for (final Block block : NaturalHarvest.registry.getBlocks()) {

            event.getRegistry().register(block);
        }
    }

    @SubscribeEvent
    public void registerItems (RegistryEvent.Register<Item> event) {

        for (final Item item : NaturalHarvest.registry.getItems()) {

            event.getRegistry().register(item);
        }
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void modelRegistryEvent (ModelRegistryEvent event) {

        for (final Item item : NaturalHarvest.registry.getItems()) {

            NaturalHarvest.registry.registerInventoryModel(item);
        }
    }
    
	@SubscribeEvent
	public void registerTreeTapRecipes(RegistryEvent.Register<ITreeTapRecipe> event) {
		
       register("tap_oak", new TreeTapRecipe(new ItemStack(Blocks.LOG, 1, 0), new ItemStack(HarvestItems.JELLYFISH), 100), event);
       register("tap_spruce", new TreeTapRecipe(new ItemStack(Blocks.LOG, 1, 1), new ItemStack(HarvestItems.JELLYFISH), 100), event);
       register("tap_birch", new TreeTapRecipe(new ItemStack(Blocks.LOG, 1, 2), new ItemStack(HarvestItems.JELLYFISH), 100), event);
       register("tap_jungle", new TreeTapRecipe(new ItemStack(Blocks.LOG, 1, 3), new ItemStack(HarvestItems.JELLYFISH), 100), event);
       register("tap_acacia", new TreeTapRecipe(new ItemStack(Blocks.LOG2, 1, 0), new ItemStack(HarvestItems.JELLYFISH), 100), event);
       register("tap_dark_oak", new TreeTapRecipe(new ItemStack(Blocks.LOG2, 1, 1), new ItemStack(HarvestItems.JELLYFISH), 100), event);
	}
	
	private static <T extends IForgeRegistryEntry<T>> T register(String id, T entry, RegistryEvent.Register<T> event) {
		
		entry.setRegistryName(new ResourceLocation("naturalharvest", id));
		event.getRegistry().register(entry);
		return entry;
	}
}