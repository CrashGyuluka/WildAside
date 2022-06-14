package net.crashgy.wildaside.block.custom;

import com.mojang.math.Vector3d;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.lwjgl.system.CallbackI;

import java.awt.*;
import java.util.stream.Stream;

// Change 1: Extended to BushBlock instead of just Block.
public class VibrionGrowth extends BushBlock {
    public VibrionGrowth(Properties properties) {
        super(properties);
    }

    // Change 2: uncommented the SHAPE variable.
    private static final VoxelShape SHAPE = Block.box(0, 0, 0, 14, 10, 14);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Vec3 offset = pState.getOffset(pLevel, pPos);

        // Change 3: used the SHAPE variable and offsetted it with the "offset" variable above.
        return SHAPE.move(offset.x, offset.y, offset.z);
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
        return pLevel.getBlockState(pPos.below()).canOcclude();
    }
}
