package net.crashgy.wildaside.block;

import net.crashgy.wildaside.WildAsideMod;
import net.crashgy.wildaside.item.ModCreativeModeTab;
import net.crashgy.wildaside.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, WildAsideMod.MOD_ID);


    //TEST BLOCKS!
    public static final RegistryObject<Block> TESTBLOCK = registerBlock("testblock",
            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(9f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.WILDASIDE_TAB);

    public static final RegistryObject<Block> LOGBLOCK = registerBlock("logblock",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(9f)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.WILDASIDE_TAB);


//    SUBSTILIUM & VIRBION (Vibrion Vines, Vibrion Growths and Sporeholders are not implemented)
//    public static final RegistryObject<Block> SUBSTILIUM_STEM = registerBlock("substilium_stem",
//            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD)
//                    .strength(3f)
//                    .requiresCorrectToolForDrops()), ModCreativeModeTab.WILDASIDE_TAB);
//
//    public static final RegistryObject<Block> SUBSTILIUM_SHROOM = registerBlock("substilium_shroom",
//            () -> new Block(BlockBehaviour.Properties.of(Material.WOOD)
//                    .strength(0.3f)
//                    .requiresCorrectToolForDrops()), ModCreativeModeTab.WILDASIDE_TAB);
//
//    public static final RegistryObject<Block> SUBSTILIUM_SOIL = registerBlock("substilium_soil",
//            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD)
//                    .strength(0.6f)
//                    .requiresCorrectToolForDrops()), ModCreativeModeTab.WILDASIDE_TAB);

    public static final RegistryObject<Block> VIBRION_BLOCK = registerBlock("vibrion_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.VEGETABLE)
                    .strength(2.2f)
                    .explosionResistance(1f)
                    .lightLevel(s -> 6)
                    .sound(SoundType.SHROOMLIGHT)
                    //.emissiveRendering((a, b, c) -> true)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.WILDASIDE_TAB);


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
