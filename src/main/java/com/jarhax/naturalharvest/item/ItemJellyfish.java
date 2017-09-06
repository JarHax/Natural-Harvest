package com.jarhax.naturalharvest.item;

import net.darkhax.bookshelf.data.ColorHandlers;
import net.darkhax.bookshelf.item.IColorfulItem;
import net.darkhax.bookshelf.lib.MCColor;
import net.darkhax.bookshelf.util.StackUtils;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemJellyfish extends Item implements IColorfulItem {

    public ItemJellyfish () {

        this.setHasSubtypes(true);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems (CreativeTabs tab, NonNullList<ItemStack> subItems) {

    	if (this.isInCreativeTab(tab)) {
    		
            for (final MCColor color : MCColor.VANILLA_COLORS) {

                final ItemStack stack = StackUtils.prepareStack(new ItemStack(this));
                color.writeToStack(stack);
                subItems.add(stack);
            }
    	}
    }

	@Override
	@SideOnly(Side.CLIENT)
	public IItemColor getColorHandler() {
		
		return ColorHandlers.ITEM_MCCOLOR;
	}
}
