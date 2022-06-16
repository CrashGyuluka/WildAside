package net.crashgy.wildaside.world.feature;

import net.crashgy.wildaside.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeepingVinesFeature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class ModConfiguredFeatures {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> SUBSTILIUM_TREE =
            FeatureUtils.register("substilium", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.SUBSTILIUM_STEM.get()),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(ModBlocks.VIBRION_BLOCK.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final Holder<PlacedFeature> SUBSTILIUM_TREE_CHECKED = PlacementUtils.register("substilium_tree_checked", SUBSTILIUM_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.SPORE_GROWER.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> SUBSTILIUM_TREE_SPAWN =
            FeatureUtils.register("substilium_tree_checked", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(SUBSTILIUM_TREE_CHECKED,
                            0.5F)), SUBSTILIUM_TREE_CHECKED));

//    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> VIBRION_GROWTH_SPAWN =
//            FeatureUtils.register("vibrion_growth_checked", Feature.FLOWER,
//                    new RandomPatchConfiguration(32, 6, 6, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
//                            new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.VIBRION_GROWTH.get())))));

}