package net.crashgy.wildaside.block.custom;

import net.crashgy.wildaside.WildAsideMod;
import net.crashgy.wildaside.block.ModBlocks;
import net.crashgy.wildaside.util.ModTags;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.WeepingVinesBlock;
import net.minecraft.world.level.block.WeepingVinesPlantBlock;
import net.minecraft.world.level.levelgen.feature.WeepingVinesFeature;

public class HangingVibrionVinesPlant extends WeepingVinesPlantBlock {

    public HangingVibrionVinesPlant(Properties properties) {
        super(properties);
    }

    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock)ModBlocks.HANGING_VIBRION_VINES.get();
    }
}
