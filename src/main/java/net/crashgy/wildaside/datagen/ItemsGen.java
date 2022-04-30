package net.crashgy.wildaside.datagen;

import net.crashgy.wildaside.WildAsideMod;
import net.crashgy.wildaside.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collection;
import java.util.Collections;

public class ItemsGen extends ItemModelProvider {

    public ItemsGen(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, WildAsideMod.MOD_ID, helper);
    }

    @Override
    protected void registerModels() {
        ItemRegistrar(ModItems.ITEMS.getEntries());
        //BlockRegistrar(CobrBlocks.BLOCKS.getEntries());
    }

    //--------------------------------------------------------------------
    // ITEM MODELS REGISTRY
    //--------------------------------------------------------------------
    public void ItemRegistrar(Collection<RegistryObject<Item>> items) {
        for (RegistryObject<Item> item : items) {
            if (!(item.get() instanceof BlockItem)) { // delegates all possible blockItems to another builder
                String name = item.getId().getPath();
                ModelFile modelType = getExistingFile(mcLoc("item/generated"));
                if (item.get() instanceof TieredItem) {
                    modelType = getExistingFile(mcLoc("item/handheld"));
                }
                this.getBuilder(name).parent(modelType).texture("layer0", ITEM_FOLDER + "/" + name);
            }
        }
    }

    //--------------------------------------------------------------------
    // BLOCK ITEM MODELS REGISTRY
    //--------------------------------------------------------------------
    public void BlockRegistrar(Collection<RegistryObject<Block>> blocks) {
        for (RegistryObject<Block> block : blocks) {
            String name = block.getId().getPath();
            //--------------------------------------------------------
            Collection<Block> lister = Collections.EMPTY_LIST;
            //--------------------------------------------------------
            // DEFAULT VALUE
            // Default value is 'else', 'if' using items from `lister`
            // Collection above (if you want to append new items,
            // remove emptyList() and replace with some sort of list
            //--------------------------------------------------------
            if (lister.contains(block.get())) {
                withExistingParent(name, new ResourceLocation(WildAsideMod.MOD_ID, "block/" + name));
            } else {
                withExistingParent(name, new ResourceLocation(WildAsideMod.MOD_ID, "block/" + name));
            }
        }
    }
}
