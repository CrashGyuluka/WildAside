package net.crashgy.wildaside.item;

import net.crashgy.wildaside.WildAsideMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WildAsideMod.MOD_ID);

    public static final RegistryObject<Item> TESTITEM = ITEMS.register("testitem",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.WILDASIDE_TAB)));

    public static final RegistryObject<Item> TESTITEM2 = ITEMS.register("testitem2",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.WILDASIDE_TAB)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
