package notamodder.naturalharvest.api;

import java.util.List;

import javax.annotation.Nonnull;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;
import notamodder.naturalharvest.api.treetap.ITreeTapRecipe;
import notamodder.naturalharvest.api.treetap.TreeTapRecipe;

public class Registry {

    /**
     * A list of all registered tree tapping recipes.
     */
    private static final List<ITreeTapRecipe> treeTapRecipes = NonNullList.create();

    /**
     * Checks if an ItemStack is a valid input for tree tapping.
     *
     * @param stack The ItemStack to check.
     * @return Whether or not the ItemStack is valid for tree tapping.
     */
    public static boolean hasTreeTapRecipe (@Nonnull ItemStack stack) {

        for (final ITreeTapRecipe recipe : treeTapRecipes) {
            if (recipe.isValidInput(stack)) {
                return true;
            }
        }
        
        return false;
    }

    /**
     * Adds a new tree tap recipe to the game.
     *
     * @param input The input for the recipe.
     * @param output The output for the recipe.
     * @param duration The amount of time (in ticks) for the recipe to complete.
     */
    public static void addTreeTapRecipe (String input, ItemStack output, int duration) {

        addTreeTapRecipe(new TreeTapRecipe(input, output, duration));
    }

    /**
     * Adds a new tree tap recipe to the game.
     *
     * @param input The input for the recipe.
     * @param output The output for the recipe.
     * @param duration The amount of time (in ticks) for the recipe to complete.
     */
    public static void addTreeTapRecipe (Block input, ItemStack output, int duration) {

        addTreeTapRecipe(new TreeTapRecipe(input, output, duration));
    }

    /**
     * Adds a new tree tap recipe to the game.
     *
     * @param input The input for the recipe.
     * @param output The output for the recipe.
     * @param duration The amount of time (in ticks) for the recipe to complete.
     */
    public static void addTreeTapRecipe (Item input, ItemStack output, int duration) {

        addTreeTapRecipe(new TreeTapRecipe(input, output, duration));
    }

    /**
     * Adds a new tree tap recipe to the game.
     *
     * @param input The input for the recipe.
     * @param output The output for the recipe.
     * @param duration The amount of time (in ticks) for the recipe to complete.
     */
    public static void addTreeTapRecipe (ItemStack input, ItemStack output, int duration) {

        addTreeTapRecipe(new TreeTapRecipe(input, output, duration));
    }

    /**
     * Adds a new tree tap recipe to the game.
     *
     * @param inputs The accepted inputs for the recipe.
     * @param output The output for the recipe.
     * @param duration The amount of time (in ticks) for the recipe to complete.
     */
    public static void addTreeTapRecipe (NonNullList<ItemStack> inputs, ItemStack output, int duration) {

        addTreeTapRecipe(new TreeTapRecipe(inputs, output, duration));
    }

    /**
     * Adds a new tree tap recipe to the game.
     *
     * @param recipe The recipe to add.
     */
    public static void addTreeTapRecipe (ITreeTapRecipe recipe) {

        treeTapRecipes.add(recipe);
    }

    /**
     * Attempts to remove a tree tap recipe.
     *
     * @param recipe The recipe to remove.
     * @return Whether or not the recipe was removed.
     */
    public static boolean removeTreeTapRecipe (ITreeTapRecipe recipe) {

        return treeTapRecipes.remove(recipe);
    }

    /**
     * Attempts to remove all tree tap recipes which accept the ore dict name passed as an
     * entry.
     *
     * @param input The input ore dictionary string.
     */
    public static void removeTreeTapRecipe (String input) {

        for (final ItemStack stack : OreDictionary.getOres(input)) {
            removeTreeTapRecipe(stack);
        }
    }

    /**
     * Attempts to remove all tree tap recipes which accept the passed ItemStack as an input.
     *
     * @param input The input to remove.
     * @return Whether or not recipes were removed.
     */
    public static boolean removeTreeTapRecipe (ItemStack input) {

        return treeTapRecipes.removeIf(recipe -> recipe.isValidInput(input));
    }
}
