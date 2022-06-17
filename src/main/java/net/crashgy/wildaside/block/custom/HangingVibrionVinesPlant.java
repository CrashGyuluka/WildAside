package net.crashgy.wildaside.block.custom;

import net.crashgy.wildaside.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.WeepingVinesPlantBlock;
import net.minecraft.world.level.block.state.BlockState;

public class HangingVibrionVinesPlant extends WeepingVinesPlantBlock {

    public HangingVibrionVinesPlant(Properties properties) {
        super(properties);
    }

    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock)ModBlocks.HANGING_VIBRION_VINES.get();
    }
}