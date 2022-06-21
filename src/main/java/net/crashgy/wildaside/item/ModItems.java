package net.crashgy.wildaside.item;

import net.crashgy.wildaside.WildAsideMod;
import net.crashgy.wildaside.item.custom.Entorium;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WildAsideMod.MOD_ID);

    public static final RegistryObject<Item> VIBRION = ITEMS.register("vibrion",
            () -> new Item(new Item.Properties()
                    .stacksTo(64)
                    .fireResistant()
                    .tab(ModCreativeModeTab.WILDASIDE_TAB).food(ModFoods.VIBRION)));

    public static final RegistryObject<Item> ENTORIUM = ITEMS.register("entorium",
            () -> new Entorium(new Item.Properties()
                    .stacksTo(64)
                    .tab(ModCreativeModeTab.WILDASIDE_TAB)));

//    public static final RegistryObject<Item> SPORE = ITEMS.register("spore",
//            () -> new Item(new Item.Properties()
//                    .fireResistant()
//                    .stacksTo(16)
//                    .tab(ModCreativeModeTab.WILDASIDE_TAB)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
