package notamodder.naturalharvest.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
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

        for (final EnumFacing facing : FACING.getAllowedValues())
            if (Registry.canTap(worldIn.getBlockState(pos.offset(facing))))
                return true;
        return false;
    }

    @Override
    public BlockStateContainer createBlockState () {

        return new BlockStateContainer(this, FACING);
    }

    @Override
    public IBlockState getStateForPlacement (World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {

        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing());
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
