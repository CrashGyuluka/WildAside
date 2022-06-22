package net.crashgy.wildaside.block.custom;

import net.crashgy.wildaside.block.ModBlocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.WeepingVinesPlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraftforge.common.extensions.IForgeBlockState;

import java.util.ArrayList;
import java.util.List;

public class HangingVibrionVinesPlant extends WeepingVinesPlantBlock {

    public HangingVibrionVinesPlant(Properties properties) {
        super(properties);
    }

    @Override
    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock)ModBlocks.HANGING_VIBRION_VINES.get();
    }

    @Override
    public List<ItemStack> getDrops(BlockState pState, LootContext.Builder pBuilder) {
        List<ItemStack> out = new ArrayList<>();
        final IForgeBlockState state = ModBlocks.HANGING_VIBRION_VINES.get().defaultBlockState();
        return out;
    }
}