package net.crashgy.wildaside.particle;

import net.crashgy.wildaside.WildAsideMod;
import net.minecraft.client.particle.SimpleAnimatedParticle;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, WildAsideMod.MOD_ID);

    public static final RegistryObject<SimpleParticleType> ENTORIUM_PARTICLE =
            PARTICLE_TYPES.register("entorium_particle", () -> new SimpleAnimatedParticle(true));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}