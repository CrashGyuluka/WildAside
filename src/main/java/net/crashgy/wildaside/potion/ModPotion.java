package net.crashgy.wildaside.potion;

import net.crashgy.wildaside.WildAsideMod;
import net.crashgy.wildaside.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotion {
    public static final DeferredRegister<Potion> POTIONS
            = DeferredRegister.create(ForgeRegistries.POTIONS, WildAsideMod.MOD_ID);

    public static final RegistryObject<Potion> CONTAMINATED_POTION = POTIONS.register("contaminated_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.CONTAMINATED.get(), 200, 0)));

    public static void register(IEventBus eventBus)
    {
        POTIONS.register(eventBus);
    }
}
