package com.jarhax.naturalharvest.registry;

import com.jarhax.naturalharvest.api.treetap.ITreeTapRecipe;
import com.jarhax.naturalharvest.api.treetap.TreeTapRecipe;
import com.jarhax.naturalharvest.data.HarvestItems;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class RegistryHandler {

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