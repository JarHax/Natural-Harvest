package notamodder.naturalharvest.api.treetap;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;
import notamodder.notalib.utils.StackUtils;

/**
 * A default implementation of {@link notamodder.naturalharvest.api.treetap.ITreeTapRecipe}
 * which can use IBlockState, Item, Block, ItemStack, Ore Dict names and more as inputs.
 */
public class TreeTapRecipe implements ITreeTapRecipe {

    /**
     * A list of ItemStack that are accepted as inputs.
     */
    private final NonNullList<ItemStack> inputs;

    /**
     * The ItemStack for this recipe to output.
     */
    private final ItemStack output;

    /**
     * The amount of time (in ticks) for the recipe to complete.
     */
    private final int duration;

    /**
     * Constructs a TreeTapRecipe which uses as an oredict String input.
     *
     * @param input The input for the recipe.
     * @param output The output for the recipe.
     * @param duration The amount of time (in ticks) for the recipe to complete.
     */
    public TreeTapRecipe (String input, ItemStack output, int duration) {

        this(OreDictionary.getOres(input), output, duration);
    }

    /**
     * Constructs a TreeTapRecipe which uses as a Block input.
     *
     * @param input The input for the recipe.
     * @param output The output for the recipe.
     * @param duration The amount of time (in ticks) for the recipe to complete.
     */
    public TreeTapRecipe (Block input, ItemStack output, int duration) {

        this(new ItemStack(input), output, duration);
    }

    /**
     * Constructs a TreeTapRecipe which uses as an Item input.
     *
     * @param input The input for the recipe.
     * @param output The output for the recipe.
     * @param duration The amount of time (in ticks) for the recipe to complete.
     */
    public TreeTapRecipe (Item input, ItemStack output, int duration) {

        this(new ItemStack(input), output, duration);
    }

    /**
     * Constructs a TreeTapRecipe which uses as an ItemStack input.
     *
     * @param input The input for the recipe.
     * @param output The output for the recipe.
     * @param duration The amount of time (in ticks) for the recipe to complete.
     */
    public TreeTapRecipe (ItemStack input, ItemStack output, int duration) {

        this(NonNullList.withSize(1, input), output, duration);
    }

    /**
     * Constructs a TreeTapRecipe which uses as an ItemStack list input.
     *
     * @param inputs The input for the recipe.
     * @param output The output for the recipe.
     * @param duration The amount of time (in ticks) for the recipe to complete.
     */
    public TreeTapRecipe (NonNullList<ItemStack> inputs, ItemStack output, int duration) {

        this.inputs = inputs;
        this.output = output;
        this.duration = duration;
    }

    @Override
    public NonNullList<ItemStack> getInputs () {

        return this.inputs;
    }

    @Override
    public boolean isValidInput (ItemStack stack) {

        for (final ItemStack validInput : this.inputs) {
            if (StackUtils.areStacksSimilar(validInput, stack)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public ItemStack getOutput () {

        return this.output;
    }

    @Override
    public int getDuration () {

        return this.duration;
    }
}
