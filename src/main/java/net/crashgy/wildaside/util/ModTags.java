package net.crashgy.wildaside.util;

import net.crashgy.wildaside.WildAsideMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> ALL_WILDASIDE_BLOCKS = tag("all_wildaside_blocks");
        public static final TagKey<Block> VIBRION_BLOCKS = tag("vibrion_blocks");
        public static final TagKey<Block> SUBSTILIUM_BLOCKS = tag("substilium_blocks");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(WildAsideMod.MOD_ID, name));
        }

        private static TagKey<Block> ForgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }

    }

    public static class Items {
        public static final TagKey<Item> ALL_WILDASIDE_ITEMS = tag("all_wildaside_items");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(WildAsideMod.MOD_ID, name));
        }

        private static TagKey<Item> ForgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
