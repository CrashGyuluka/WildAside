package net.crashgy.wildaside.datagen;

import net.crashgy.wildaside.WildAsideMod;
import net.crashgy.wildaside.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;

public class BlocksGen extends BlockModelProvider {

    public BlocksGen(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, WildAsideMod.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        iterator(ModBlocks.BLOCKS.getEntries());
    }

    public void iterator(Collection<RegistryObject<Block>> blocks) {
        for (RegistryObject<Block> block : blocks) {
            String pathage = block.get().getRegistryName().getPath();

            // LOG-LIKE BLOCKS
            if(block.get() instanceof RotatedPillarBlock){
                String pathage2 = pathage;
                if(pathage.contains("wood")) {
                    pathage2 = pathage.replace("wood", "log");
                }
                cubeColumn(pathage,
                        Helpers.BlockPathRef("", pathage2 + "_side"),
                        Helpers.BlockPathRef("", pathage2 + "_top"));
                cubeColumnHorizontal(pathage + "_horizontal",
                        Helpers.BlockPathRef("", pathage2 + "_side"),
                        Helpers.BlockPathRef("", pathage2 + "_top"));
                sign(pathage, Helpers.BlockPathRef("", pathage2 + "_side"));
            }
            else {
                cubeAll(pathage, Helpers.BlockPathRef("", pathage));
                sign(pathage, Helpers.BlockPathRef("", pathage));
            }
            //---------------------------------------------------------------------
            // SKIPPED
            // Here are all blockstates that are added manually.
            // If placed in case I will change my mind and switch them to datagen.
            //---------------------------------------------------------------------
        }
    }
}
