package notamodder.naturalharvest.api;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;

import java.util.*;

public class Registry {
    
    private static final Map<IBlockState, ItemStack> TREE_TAPPING_REGISTRY = new HashMap<>();
    
    public static void registerTreeTapping(IBlockState state, ItemStack result) {
        getTreeTappingRegistry().put(state, result);
    }
    
    public static boolean canTap(IBlockState state) {
        return getTreeTappingRegistry().containsKey(state);
    }
    
    public static boolean removeTreeTapping(IBlockState state) {
        return getTreeTappingRegistry().remove(state) != null;
    }
    
    public static Map<IBlockState, ItemStack> getTreeTappingRegistry() {
        return TREE_TAPPING_REGISTRY;
    }
}
