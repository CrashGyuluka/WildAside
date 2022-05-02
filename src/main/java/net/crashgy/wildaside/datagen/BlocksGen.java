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
            else if(!(Helpers.manualJsons(block.get()))) {
                cubeAll(pathage, Helpers.BlockPathRef("", pathage));
                sign(pathage, Helpers.BlockPathRef("", pathage));
            }
            else {
                // This is meant to be empty, it is for all blocks listed in Helpers.manualJsons - add elements to
                // this list to exclude it from datagen and make .jsons manually
            }
        }
    }
}
