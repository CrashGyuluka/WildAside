package net.crashgy.wildaside.block.custom;

import com.mojang.math.Vector3d;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.awt.*;
import java.util.stream.Stream;

public class VibrionGrowth extends Block {
    public VibrionGrowth(Properties properties) {
        super(properties);
    }

//    private static final VoxelShape SHAPE =
//            Block.box(0, 0, 0, 14, 10, 14).withOffset(offset.x, offset.y ,offset.z;

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Vec3 offset = pState.getOffset(pLevel, pPos);
        return Block.box(0, 0, 0, 10, 9, 10);
    }

    @Override
    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    @Override
    public float getJumpFactor() {
        return 0.9f;
    }

    @Override
    public float getSpeedFactor() {
        return 0.9f;
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        boolean canSurvive = pLevel.getBlockState(new BlockPos(pPos.getX(), pPos.getY() - 1, pPos.getZ())).canOcclude();
        return canSurvive;
    }

    @Override
    public void onNeighborChange(BlockState state, LevelReader level, BlockPos pos, BlockPos neighbor) {
        super.onNeighborChange(state, level, pos, neighbor);
    }

    @Override
    public boolean canBeReplaced(BlockState pState, BlockPlaceContext pUseContext) {
        return pUseContext.getItemInHand().getItem() != this.asItem();
    }
}
