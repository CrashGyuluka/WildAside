package net.crashgy.wildaside.datagen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.crashgy.wildaside.WildAsideMod;
import net.crashgy.wildaside.block.ModBlocks;
import net.crashgy.wildaside.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer.simpleBuilder;

public class LootTablesGen {

    public static class LootTablesRedirector extends LootTableProvider {
        public LootTablesRedirector(DataGenerator pGenerator) {
            super(pGenerator);
        }

        @Override
        protected @NotNull List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
            return ImmutableList.of(
                    Pair.of(BlockLootTables::new, LootContextParamSets.BLOCK)
            );
        }

        @Override
        protected void validate(@NotNull Map<ResourceLocation, LootTable> map, @NotNull ValidationContext validationContext) {
        }
    }

    //-----------------------------------------------------
    // BLOCK LOOT TABLES
    //-----------------------------------------------------

    public static class BlockLootTables extends BlockLoot {

        @Override
        protected void addTables() {
            blockIterator(ModBlocks.BLOCKS.getEntries());
        }

        public void blockIterator(Collection<RegistryObject<Block>> blocks) {
            for (RegistryObject<Block> block : blocks) {

                //-------------------------------------------------
                // ORE DROPS
                //-------------------------------------------------
                if (Helpers.modOres(block.get())) {
                    String namingConvention = block.get().getRegistryName().getPath();
                    Item itemProvided = block.get().asItem();
                    Integer chances = 100; // <- base chance for drop (set
                    // to lower if you don't want guaranteed drop)
                    Integer amount = 1; // <- change this within "if" part
                    // if you want to have bigger drops of items than 1
                    // ---------------------------------------------------
                    // CUSTOM ORE DROPS
                    // If custom drop is not chosen, block will get
                    // silk-touched anyway (like pre-1.17 iron ore)
                    // ---------------------------------------------------
                    if (namingConvention.contains("vibrion_block")) {
                        itemProvided = ModItems.VIBRION.get();
                    }
                    else if (namingConvention.contains("entorium_ore")) {
                        itemProvided = ModItems.ENTORIUM.get();
                        amount = 2;
                    }
                    //---------------------------------------------------
                    oresGen(block.get(), itemProvided, amount, chances);
                }
                //-------------------------------------------------
                // DOORS
                //-------------------------------------------------
                else if (block.get() instanceof DoorBlock) {
                    add(block.get(), BlockLootTables::createDoorTable);
                }
                else {
                //-------------------------------------------------
                // REGULAR BLOCKS (DROP ITSELF)
                //-------------------------------------------------
                    dropSelf(block.get());
                }
            }
        }

        //--------------------------------------------------------------------------------------------------------
        // GENERATION ACTORS
        // Used to simplify some unnecessary code spaghetti in methods above
        //--------------------------------------------------------------------------------------------------------
        public void oresGen(Block blockProvided, Item itemProvided, Integer amount, Integer chances) {
            this.add(blockProvided, (sTouch) -> {
                return createBiggerOreDrop(blockProvided, itemProvided, amount, chances);});}

        protected static LootTable.Builder createBiggerOreDrop(Block pBlock, Item pItem, Integer amount, Integer chances) {
            // variables for specific type of multipliers
            LootItemConditionalFunction.Builder<?> fortune_use = ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE);
            return createSilkTouchDispatchTable(pBlock, applyExplosionDecay(pBlock, LootItem.lootTableItem(pItem).setWeight(chances)
                    .apply(fortune_use)));
        }

        @Override
        protected @NotNull Iterable<Block> getKnownBlocks() {
            return ForgeRegistries.BLOCKS.getValues().stream().filter(b -> Objects.requireNonNull(b.getRegistryName()).getNamespace().equals(WildAsideMod.MOD_ID)).collect(Collectors.toList());
        }
    }
}