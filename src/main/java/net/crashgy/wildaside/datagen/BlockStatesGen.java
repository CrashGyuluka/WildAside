package net.crashgy.wildaside.datagen;

import net.crashgy.wildaside.WildAsideMod;
import net.crashgy.wildaside.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;

public class BlockStatesGen extends BlockStateProvider {

    public BlockStatesGen(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, WildAsideMod.MOD_ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        iterator(ModBlocks.BLOCKS.getEntries());
    }

    public void iterator(Collection<RegistryObject<Block>> blocks) {
        for (RegistryObject<Block> block : blocks) {
            String pathage = block.get().getRegistryName().getPath();

            // LOG-LIKE
            if(block.get() instanceof RotatedPillarBlock) {
                axisBlock((RotatedPillarBlock) block.get(), modelProvider(block.get(), ""), modelProvider(block.get(), "_horizontal"));
            }
            else if(block.get() instanceof StairBlock) {
                stairsBlock((StairBlock) block.get(), modelProvider(block.get(), ""), modelProvider(block.get(), "_inner"), modelProvider(block.get(), "_outer"));
            }
            else if(block.get() instanceof SlabBlock) {
                String doubleVariant = Helpers.slabDoubleVariant(block.get());
                slabBlock((SlabBlock) block.get(), modelProvider(block.get(), ""), modelProvider(block.get(), "_top"), customModelProvider(block.get(), doubleVariant));
            }
            else if(block.get() instanceof TrapDoorBlock) {
                trapdoorBlock((TrapDoorBlock) block.get(), modelProvider(block.get(), "_bottom"), modelProvider(block.get(), "_top"), modelProvider(block.get(), "_open"), true);
            }
            else if(block.get() instanceof DoorBlock) {
                doorBlock((DoorBlock) block.get(), modelProvider(block.get(), "_bottom"), modelProvider(block.get(), "_bottom_hinge"), modelProvider(block.get(), "_top"), modelProvider(block.get(), "_top_hinge"));
            }
            else if(!(Helpers.manualJsons(block.get()))) {
                simpleBlock(block.get(), modelProvider(block.get(), ""));
            }
            else {
                // This is meant to be empty, it is for all blocks listed in Helpers.manualJsons - add elements to
                // this list to exclude it from datagen and make .jsons manually
            }
        }
    }

    public ModelFile modelProvider (Block resourceGiven, String modelVariant) {
        //----------------------------------------------------------------------------------------------------------------------
        // modelVariant should be default as "", as it directs us precisely to file named after block
        // though if we want to add some variation (for example "_horizontal" suffix), it will be used under that string
        //----------------------------------------------------------------------------------------------------------------------
        ResourceLocation locationWorkedOn = new ResourceLocation(WildAsideMod.MOD_ID + ":block/" + resourceGiven.getRegistryName().getPath() + modelVariant);
        ModelFile modelWorkedOn = models().withExistingParent(resourceGiven.getRegistryName().getPath(), locationWorkedOn);
        return modelWorkedOn;
    }
    public ModelFile customModelProvider (Block resourceGiven, String modelVariant) {
        //----------------------------------------------------------------------------------------------------------------------
        // modelVariant should be default as "", as it directs us precisely to file named after block
        // though if we want to add some variation (for example "_horizontal" suffix), it will be used under that string
        //----------------------------------------------------------------------------------------------------------------------
        ResourceLocation locationWorkedOn = new ResourceLocation(WildAsideMod.MOD_ID + ":block/" + modelVariant);
        ModelFile modelWorkedOn = models().withExistingParent(modelVariant, locationWorkedOn);
        return modelWorkedOn;
    }

}
