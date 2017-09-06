package com.jarhax.naturalharvest.registry;

import com.jarhax.naturalharvest.api.treetap.ITreeTapRecipe;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryBuilder;

public class NaturalHarvestRegistries {

	public static IForgeRegistry<ITreeTapRecipe> treeTapRecipes;
		
	public static void init() {
		
		treeTapRecipes = makeRegistry("tree_tap_recipes", ITreeTapRecipe.class);
	}
	
    private static <T extends IForgeRegistryEntry<T>> IForgeRegistry<T> makeRegistry(String regName, Class<T> type) {
    	
        return new RegistryBuilder<T>().setName(new ResourceLocation("naturalharvest", regName)).setType(type).setMaxID(Integer.MAX_VALUE >> 5).create();
    }
}