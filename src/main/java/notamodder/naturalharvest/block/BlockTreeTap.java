package notamodder.naturalharvest.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.*;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.*;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import notamodder.naturalharvest.api.Registry;

public class BlockTreeTap extends Block {

    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    public BlockTreeTap () {
        super(Material.WOOD, MapColor.WOOD);
    }
    
    @Override
    public boolean canPlaceBlockAt (World worldIn, BlockPos pos) {
        
        for(final EnumFacing side : EnumFacing.Plane.HORIZONTAL)
            if(this.canPlaceAt(worldIn, pos, side))
                return true;
        
        return false;
    }
    
    private boolean canPlaceAt(World world, BlockPos pos, EnumFacing side) {
        
        final BlockPos offset = pos.offset(side.getOpposite());
        final IBlockState state = world.getBlockState(offset);
        final ItemStack stack = state.getBlock().getItem(world, pos, state);
        return side.getAxis().isHorizontal() && Registry.hasTreeTapRecipe(stack);
    }
    
    @Override
    public IBlockState getStateForPlacement (World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        
        if(this.canPlaceAt(world, pos, facing))
            return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing());
        else
            for(final EnumFacing side : EnumFacing.Plane.HORIZONTAL)
                if(this.canPlaceAt(world, pos, side))
                    return this.getDefaultState().withProperty(FACING, side.getOpposite());
        
        return this.getDefaultState();
    }
    
    @Override
    public BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING);
    }
    @Override
    public boolean isOpaqueCube (IBlockState state) {

        return false;
    }

    @Override
    public boolean isFullCube (IBlockState state) {

        return false;
    }

    @Override
    public IBlockState getStateFromMeta (int meta) {

        return this.getDefaultState().withProperty(FACING, EnumFacing.values()[meta]);
    }

    @Override
    public int getMetaFromState (IBlockState state) {

        return state.getValue(FACING).ordinal();
    }
}
