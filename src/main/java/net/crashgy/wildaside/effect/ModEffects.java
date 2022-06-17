package net.crashgy.wildaside.effect;

import net.crashgy.wildaside.WildAsideMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, WildAsideMod.MOD_ID);

    public static final RegistryObject<MobEffect> CONTAMINATED = MOB_EFFECTS.register("contaminated",
            () -> new ContaminatedEffect(MobEffectCategory.HARMFUL, 3124687));

    public static void  register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}