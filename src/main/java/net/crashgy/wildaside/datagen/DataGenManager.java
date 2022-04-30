package net.crashgy.wildaside.datagen;

import net.crashgy.wildaside.WildAsideMod;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = WildAsideMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenManager {

    //-----------------------------------------------------------------------------------
    // BlocksGen is doubled because for some reason, BlockStates overwrites data made
    // by BlocksGen, but it also -requires- BlocksGen to be run correctly.
    // Therefore, we run BlocksGen again to overwrite badly written files with correct
    // references.
    //-----------------------------------------------------------------------------------
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if(event.includeServer()) {
            generator.addProvider(new LootTablesGen.LootTablesRedirector(generator));
            generator.addProvider(new BlocksGen(generator, event.getExistingFileHelper()));
            generator.addProvider(new BlockStatesGen(generator, event.getExistingFileHelper()));
            generator.addProvider(new BlocksGen(generator, event.getExistingFileHelper()));
            generator.addProvider(new ItemsGen(generator, event.getExistingFileHelper()));
        }
    }

}
