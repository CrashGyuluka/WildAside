package net.crashgy.wildaside.datagen;

import net.crashgy.wildaside.WildAsideMod;
import net.crashgy.wildaside.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
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
            String pathage = block.get().getLootTable().getPath();

            // LOG-LIKE BLOCKS
            if(block.get() instanceof RotatedPillarBlock){
                String pathage_side = pathage + "_side";
                String pathage_top = pathage + "_top";
                if(pathage.contains("wood")) {
                    pathage_side = pathage_side.replace("wood", "log");
                    pathage_top = pathage_side;
                }
                cubeColumn(pathage,
                        Helpers.BlockPathRef("", pathage_side),
                        Helpers.BlockPathRef("", pathage_top));
                cubeColumnHorizontal(pathage + "_horizontal",
                        Helpers.BlockPathRef("", pathage_side),
                        Helpers.BlockPathRef("", pathage_top));
                sign(pathage, Helpers.BlockPathRef("", pathage_side));
            }
            else if(block.get() instanceof StairBlock) {
                String pathage2 = Helpers.stairNamingModifier(block.get(), pathage);
                stairs(pathage,
                        Helpers.BlockPathRef("", pathage2),
                        Helpers.BlockPathRef("", pathage2),
                        Helpers.BlockPathRef("", pathage2));
                stairsInner(pathage + "_inner",
                        Helpers.BlockPathRef("", pathage2),
                        Helpers.BlockPathRef("", pathage2),
                        Helpers.BlockPathRef("", pathage2));
                stairsOuter(pathage + "_outer",
                        Helpers.BlockPathRef("", pathage2),
                        Helpers.BlockPathRef("", pathage2),
                        Helpers.BlockPathRef("", pathage2));
            }
            else if(block.get() instanceof SlabBlock) {
                String pathage2 = Helpers.slabNamingModifier(block.get(), pathage);
                slab(pathage,
                        Helpers.BlockPathRef("", pathage2),
                        Helpers.BlockPathRef("", pathage2),
                        Helpers.BlockPathRef("", pathage2));
                slabTop(pathage + "_top",
                        Helpers.BlockPathRef("", pathage2),
                        Helpers.BlockPathRef("", pathage2),
                        Helpers.BlockPathRef("", pathage2));
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
