package notamodder.naturalharvest.api.treetap;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

/**
 * The backing interface for tree tapping recipes. This can be used to make new recipe types.
 */
public interface ITreeTapRecipe {

    /**
     * Gets a list of inputs for this recipe.
     *
     * @return The list of inputs for this recipe.
     */
    @Nonnull
    NonNullList<ItemStack> getInputs ();

    /**
     * Checks if an ItemStack is valid for this recipe.
     *
     * @param stack The ItemStack to check.
     * @return Whether or not the passed ItemStack is valid.
     */
    boolean isValidInput (@Nonnull ItemStack stack);

    /**
     * Gets the output ItemStack for this recipe.
     *
     * @return The ItemStack for this recipe to output.
     */
    @Nonnull
    ItemStack getOutput ();

    /**
     * The amount of time (in ticks) it takes this recipe to complete.
     *
     * @return The amount of time (in ticks) it takes for the recipe to complete.
     */
    int getDuration ();
}