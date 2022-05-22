package net.crashgy.wildaside.datagen;

import net.crashgy.wildaside.WildAsideMod;
import net.crashgy.wildaside.block.ModBlocks;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;

public class Helpers {

    // --------------------------------------------
    // LISTS
    // --------------------------------------------
    // Class used for blocks that will have manually handled blockstates and models
    public static Boolean manualJsons(Block block) {
        ArrayList<Block> manual_jsons_list = new ArrayList<>();
        //manual_jsons_list.add(ModBlocks.SUBSTILIUM_STEM.get());
        //manual_jsons_list.add(ModBlocks.SUBSTILIUM_SHROOM.get());
        //manual_jsons_list.add(ModBlocks.SUBSTILIUM_SOIL.get());
        return (manual_jsons_list.contains(block));
    }
    public static Boolean modOres(Block block) {
        ArrayList<Block> ores_list = new ArrayList<>();
        for (RegistryObject<Block> block_iterated : ModBlocks.BLOCKS.getEntries()) {
            if (block_iterated.get() instanceof OreBlock) {
                ores_list.add(block_iterated.get());
            }
        }
        ores_list.add(ModBlocks.TESTBLOCK.get());
        return (ores_list.contains(block));
    }

    //ITEM GENERATION
    public static final ResourceLocation ItemPathRef(String namespace, String item) {
        ResourceLocation Item = new ResourceLocation(WildAsideMod.MOD_ID + ":item/" + item);
        if (namespace != "" && namespace != "mod") {
            Item = new ResourceLocation(namespace + ":item/" + item);
        }
        return Item;
    }
    //BLOCK GENERATION
    public static final ResourceLocation BlockPathRef(String namespace, String item) {
        ResourceLocation Block = new ResourceLocation(WildAsideMod.MOD_ID + ":block/" + item);
        if (namespace != "" && namespace != "mod") {
            Block = new ResourceLocation(namespace + ":block/" + item);
        }
        return Block;
    }
}
