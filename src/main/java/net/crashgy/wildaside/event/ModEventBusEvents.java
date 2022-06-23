package net.crashgy.wildaside.event;

import net.crashgy.wildaside.WildAsideMod;
import net.crashgy.wildaside.particle.ModParticles;
import net.crashgy.wildaside.particle.custom.EntoriumParticle;
import net.crashgy.wildaside.particle.custom.VibrionParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = WildAsideMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                           event) {
        event.getRegistry().registerAll(
//                new CucumberSeedsFromGrassAdditionModifier.Serializer().setRegistryName
//                        (new ResourceLocation(TutorialMod.MOD_ID,"cucumber_seeds_from_grass")),
//                new DowsingRodInIglooAdditionModifier.Serializer().setRegistryName
//                        (new ResourceLocation(TutorialMod.MOD_ID,"dowsing_rod_in_igloo")),
//                new CoalCokeFromCreeperAdditionModifier.Serializer().setRegistryName
//                        (new ResourceLocation(TutorialMod.MOD_ID,"coal_coke_from_creeper"))
        );
    }

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
//        Registry.register(Registry.RECIPE_TYPE, GemCuttingStationRecipe.Type.ID, GemCuttingStationRecipe.Type.INSTANCE);
    }

    @SubscribeEvent
    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        Minecraft.getInstance().particleEngine.register(ModParticles.ENTORIUM_PARTICLE.get(),
                EntoriumParticle.Provider::new);
        Minecraft.getInstance().particleEngine.register(ModParticles.VIBRION_PARTICLE.get(),
                VibrionParticle.Provider::new);
    }
}