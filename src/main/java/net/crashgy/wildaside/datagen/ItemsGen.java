package net.crashgy.wildaside.datagen;

import net.crashgy.wildaside.WildAsideMod;
import net.crashgy.wildaside.block.ModBlocks;
import net.crashgy.wildaside.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.Collection;

public class ItemsGen extends ItemModelProvider {

    public ItemsGen(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, WildAsideMod.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        ItemRegistrar(ModItems.ITEMS.getEntries());
    }

    //--------------------------------------------------------------------
    // ITEM MODELS REGISTRY
    //--------------------------------------------------------------------
    public void ItemRegistrar(Collection<RegistryObject<Item>> items) {
        //--------------------------------------------------------
        // LISTER
        //--------------------------------------------------------
        // This arraylist serves as a list of block items that
        // will have their custom textures - this means, for
        // example, doors
        // It requires texture called the same name as block has
        // as an ID, but be placed in textures/item folder
        //--------------------------------------------------------
        ArrayList<Block> lister = new ArrayList<>();
        for (RegistryObject<Block> block_iterated : ModBlocks.BLOCKS.getEntries()) {
            if (block_iterated.get() instanceof DoorBlock) {
                lister.add(block_iterated.get());
            }
        }
        //--------------------------------------------------------
        for (RegistryObject<Item> item : items) {
            String name = item.getId().getPath();
            if (!(item.get() instanceof BlockItem)) { // delegates all possible blockItems to another builder
                ModelFile modelType = getExistingFile(mcLoc("item/generated"));
                if (item.get() instanceof TieredItem) {
                    modelType = getExistingFile(mcLoc("item/handheld"));
                }
                this.getBuilder(name).parent(modelType).texture("layer0", ITEM_FOLDER + "/" + name);
            }
            else { // blocks handling
                if (Helpers.manualJsons(Block.byItem(item.get()))) {
                    // This is meant to be empty, it is for all blocks listed in Helpers.manualJsons - add elements to
                    // this list to exclude it from datagen and make .jsons manually
                }
                else if (lister.contains(((BlockItem) item.get()).getBlock())) { // checks if items are in lister ArrayList (look comments above)
                    this.getBuilder(name).parent(getExistingFile(mcLoc("item/generated"))).texture("layer0", ITEM_FOLDER + "/" + name);
                }
                else {
                    withExistingParent(name, new ResourceLocation(WildAsideMod.MOD_ID, "block/" + name));
                }
            }
        }
    }
}
