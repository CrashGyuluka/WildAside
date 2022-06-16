package net.crashgy.wildaside.world.feature.tree;

import net.crashgy.wildaside.world.feature.ModConfiguredFeatures;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class SubstiliumTreeGrower extends AbstractTreeGrower {


    @Nullable
    @Override
    protected Holder <? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random pRandom, boolean pLargeHive) {
        return ModConfiguredFeatures.SUBSTILIUM_TREE;
    }
}
