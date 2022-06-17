package net.crashgy.wildaside.block;

import net.crashgy.wildaside.WildAsideMod;
import net.crashgy.wildaside.block.custom.*;
import net.crashgy.wildaside.elements.blocks.templated.FlammableBlocks;
import net.crashgy.wildaside.item.ModCreativeModeTab;
import net.crashgy.wildaside.item.ModItems;
import net.crashgy.wildaside.world.feature.tree.SubstiliumTreeGrower;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, WildAsideMod.MOD_ID);


    //SUBSTILIUM BLOCKS

    public static final RegistryObject<Block> SUBSTILIUM_STEM = registerBlock("substilium_stem",
            () -> new RotatedPillarBlock(
                    BlockBehaviour.Properties
                            .of(Material.VEGETABLE)
                            .strength(3f)
                            .explosionResistance(2f)
                            .sound(SoundType.STEM)), ModCreativeModeTab.WILDASIDE_TAB);

    public static final RegistryObject<Block> SUBSTILIUM_PLANKS = registerBlock("substilium_planks",
            () -> new FlammableBlocks.Planks(
                    BlockBehaviour.Properties
                            .of(Material.WOOD)
                            .strength(2f)
                            .explosionResistance(1.5f)
                            .sound(SoundType.WOOD)), ModCreativeModeTab.WILDASIDE_TAB);

    public static final RegistryObject<Block> SUBSTILIUM_STAIRS = registerBlock("substilium_stairs",
            () -> new FlammableBlocks.Stairs(() -> ModBlocks.SUBSTILIUM_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties
                            .of(Material.WOOD)
                            .strength(2f)
                            .explosionResistance(1.5f)
                            .sound(SoundType.WOOD)), ModCreativeModeTab.WILDASIDE_TAB);

    public static final RegistryObject<Block> SUBSTILIUM_SLAB = registerBlock("substilium_slab",
            () -> new FlammableBlocks.Slab(
                    BlockBehaviour.Properties
                            .of(Material.WOOD)
                            .strength(2f)
                            .explosionResistance(1.5f)
                            .sound(SoundType.WOOD)), ModCreativeModeTab.WILDASIDE_TAB);

    public static final RegistryObject<Block> SUBSTILIUM_DOOR = registerBlock("substilium_door",
            () -> new FlammableBlocks.Door(
                    BlockBehaviour.Properties
                            .of(Material.WOOD)
                            .strength(2f)
                            .explosionResistance(1.5f)
                            .sound(SoundType.WOOD)
                            .noOcclusion()), ModCreativeModeTab.WILDASIDE_TAB);

    public static final RegistryObject<Block> SUBSTILIUM_TRAPDOOR = registerBlock("substilium_trapdoor",
            () -> new FlammableBlocks.Trapdoor(
                    BlockBehaviour.Properties
                            .of(Material.WOOD)
                            .strength(2f)
                            .explosionResistance(1.5f)
                            .sound(SoundType.WOOD)
                            .noOcclusion()), ModCreativeModeTab.WILDASIDE_TAB);


    //NO DATAGEN:
//    public static final RegistryObject<Block> SUBSTILIUM_FENCE = registerBlock("substilium_fence",
//            () -> new FenceBlock(
//                    BlockBehaviour.Properties
//                            .of(Material.WOOD)
//                            .strength(2f)
//                            .explosionResistance(1.5f)
//                            .sound(SoundType.WOOD)), ModCreativeModeTab.WILDASIDE_TAB);
//
//    public static final RegistryObject<Block> SUBSTILIUM_FENCE_GATE = registerBlock("substilium_fence_gate",
//            () -> new FenceGateBlock(
//                    BlockBehaviour.Properties
//                            .of(Material.WOOD)
//                            .strength(2f)
//                            .explosionResistance(1.5f)
//                            .sound(SoundType.WOOD)), ModCreativeModeTab.WILDASIDE_TAB);
//
//    public static final RegistryObject<Block> SUBSTILIUM_BUTTON = registerBlock("substilium_button",
//            () -> new WoodButtonBlock(
//                    BlockBehaviour.Properties
//                            .of(Material.WOOD)
//                            .strength(2f)
//                            .explosionResistance(1.5f)
//                            .sound(SoundType.WOOD)
//                            .requiresCorrectToolForDrops()
//                            .noCollission()), ModCreativeModeTab.WILDASIDE_TAB);
//
//    public static final RegistryObject<Block> SUBSTILIUM_PRESSURE_PLATE = registerBlock("substilium_pressure_plate",
//            () -> new PressurePlateBlock(
//                    PressurePlateBlock.Sensitivity.EVERYTHING,
//                    BlockBehaviour.Properties
//                            .of(Material.WOOD)
//                            .strength(2f)
//                            .explosionResistance(1.5f)
//                            .sound(SoundType.WOOD)
//                            .requiresCorrectToolForDrops()), ModCreativeModeTab.WILDASIDE_TAB);


    // NO TEXTURES AT ALL
//    public static final RegistryObject<Block> SUBSTILIUM_SHROOM = registerBlock("substilium_shroom",
//            () -> new Block(
//                    BlockBehaviour.Properties
//                            .of(Material.VEGETABLE)
//                            .strength(0.3f)
//                            .explosionResistance(1f)
//                            .sound(SoundType.WART_BLOCK)), ModCreativeModeTab.WILDASIDE_TAB);
//
//    public static final RegistryObject<Block> SUBSTILIUM_SOIL = registerBlock("substilium_soil",
//            () -> new RotatedPillarBlock(
//                    BlockBehaviour.Properties
//                            .of(Material.DIRT)
//                            .strength(0.5f)
//                            .explosionResistance(1f)
//                            .sound(SoundType.NYLIUM)
//                            .requiresCorrectToolForDrops()), ModCreativeModeTab.WILDASIDE_TAB);

    public static final RegistryObject<Block> VIBRION_BLOCK = registerBlock("vibrion_block",
            () -> new OreBlock(
                    BlockBehaviour.Properties
                            .of(Material.VEGETABLE)
                            .strength(2.3f)
                            .explosionResistance(1f)
                            .lightLevel(s -> 4)
                            .sound(SoundType.SHROOMLIGHT)), ModCreativeModeTab.WILDASIDE_TAB);

    public static final RegistryObject<Block> VIBRION_GROWTH = registerBlock("vibrion_growth",
            () -> new VibrionGrowth(BlockBehaviour.Properties
                            .of(Material.REPLACEABLE_PLANT)
                            .strength(0.5f)
                            .explosionResistance(0.1f)
                            .lightLevel(s -> 1)
                            .sound(SoundType.SHROOMLIGHT)
                            .noCollission()), ModCreativeModeTab.WILDASIDE_TAB);

    public static final RegistryObject<Block> HANGING_VIBRION_VINES = registerBlock("hanging_vibrion_vines",
            () -> new HangingVibrionVines(
                    BlockBehaviour.Properties
                            .of(Material.REPLACEABLE_PLANT)
                            .strength(0.2f)
                            .explosionResistance(0f)
                            .lightLevel(s -> 1)
                            .sound(SoundType.SHROOMLIGHT)
                            .noOcclusion()
                            .noCollission()
                            .dynamicShape()), ModCreativeModeTab.WILDASIDE_TAB);

    public static final RegistryObject<Block> HANGING_VIBRION_VINES_PLANT = registerBlock("hanging_vibrion_vines_plant",
            () -> new HangingVibrionVinesPlant(
                    BlockBehaviour.Properties
                            .of(Material.REPLACEABLE_PLANT)
                            .strength(0.3f)
                            .explosionResistance(0.5f)
                            .lightLevel(s -> 1)
                            .sound(SoundType.SHROOMLIGHT)
                            .noOcclusion()
                            .noCollission()
                            .dynamicShape()), CreativeModeTab.TAB_SEARCH);

    public static final RegistryObject<Block> VIBRION_SPOREHOLDER = registerBlock("vibrion_sporeholder",
            () -> new VibrionSporeholder(
                    BlockBehaviour.Properties
                            .of(Material.PLANT)
                            .strength(2f)
                            .explosionResistance(4f)
                            .lightLevel(s -> 5)
                            .sound(SoundType.SHROOMLIGHT)
                            .noOcclusion()
                            .noCollission()), ModCreativeModeTab.WILDASIDE_TAB);

    public static final RegistryObject<Block> SPORE_GROWER = registerBlock("spore_grower",
            () -> new SporeGrower(
                    new SubstiliumTreeGrower(),
                    BlockBehaviour.Properties
                            .of(Material.PLANT)
                            .strength(0f)
                            .explosionResistance(0f)
                            .sound(SoundType.SHROOMLIGHT)
                            .noOcclusion()
                            .noCollission()
                            .dynamicShape()), ModCreativeModeTab.WILDASIDE_TAB);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends  Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
