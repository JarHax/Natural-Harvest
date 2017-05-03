package notamodder.naturalharvest.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import notamodder.notalib.lib.MCColor;
import notamodder.notalib.utils.StackUtils;

public class ItemJellyfish extends Item {

    public ItemJellyfish () {

        this.setHasSubtypes(true);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems (Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {

        for (MCColor color : MCColor.VANILLA_COLORS) {
            
            final ItemStack stack = StackUtils.prepareStack(new ItemStack(itemIn));    
            color.writeToStack(stack);
            subItems.add(stack);
        }
    }
}
