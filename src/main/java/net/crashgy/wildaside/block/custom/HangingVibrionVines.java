package net.crashgy.wildaside.block.custom;

import net.crashgy.wildaside.block.ModBlocks;
import net.minecraft.world.level.block.*;


public class HangingVibrionVines extends WeepingVinesBlock {

    public HangingVibrionVines(Properties properties) {
        super(properties);
    }

    @Override
    protected Block getBodyBlock() {
        return ModBlocks.HANGING_VIBRION_VINES_PLANT.get();
    }
}