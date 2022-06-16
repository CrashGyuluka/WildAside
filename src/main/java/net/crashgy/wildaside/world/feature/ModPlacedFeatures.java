package net.crashgy.wildaside.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class ModPlacedFeatures {
    public static final Holder<PlacedFeature> SUBSTILIUM_TREE_PLACED = PlacementUtils.register("substilium_tree_placed",
            ModConfiguredFeatures.SUBSTILIUM_TREE_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(3, 0.2f, 3)));

//    public static final Holder<PlacedFeature> VIBRION_GROWTH_PLACED = PlacementUtils.register("vibrion_growth_placed",
//            ModConfiguredFeatures.VIBRION_GROWTH_SPAWN, RarityFilter.onAverageOnceEvery(1),
//            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
}