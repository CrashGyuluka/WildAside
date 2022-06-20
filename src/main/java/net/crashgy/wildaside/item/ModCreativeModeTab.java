package net.crashgy.wildaside.item;

import net.crashgy.wildaside.block.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab WILDASIDE_TAB = new CreativeModeTab("wildaside_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.VIBRION_BLOCK.get());
        }
    };
}