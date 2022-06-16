package net.crashgy.wildaside.world;

import net.crashgy.wildaside.WildAsideMod;
import net.crashgy.wildaside.world.gen.ModFlowerGeneration;
import net.crashgy.wildaside.world.gen.ModTreeGeneration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WildAsideMod.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModTreeGeneration.generateTrees(event);
//        ModFlowerGeneration.generateFlowers(event);
    }
}