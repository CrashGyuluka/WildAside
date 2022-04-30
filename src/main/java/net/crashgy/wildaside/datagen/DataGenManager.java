package net.crashgy.wildaside.datagen;

import net.crashgy.wildaside.WildAsideMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = WildAsideMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenManager {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if(event.includeServer()) {
            generator.addProvider(new ItemsGen(generator, event.getExistingFileHelper()));
        }
    }

}
