package net.crashgy.wildaside;

import com.mojang.logging.LogUtils;
import net.crashgy.wildaside.block.ModBlocks;
import net.crashgy.wildaside.effect.ModEffects;
import net.crashgy.wildaside.item.ModItems;
import net.crashgy.wildaside.potion.ModPotion;
import net.crashgy.wildaside.util.BetterBrewingRecipe;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(WildAsideMod.MOD_ID)
public class WildAsideMod
{
    // Directly reference a slf4j logger
    public static final String MOD_ID = "wildaside";
    private static final Logger LOGGER = LogUtils.getLogger();

    public WildAsideMod()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModEffects.register(eventBus);
        ModPotion.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SUBSTILIUM_DOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SUBSTILIUM_TRAPDOOR.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.VIBRION_GROWTH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.HANGING_VIBRION_VINES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.HANGING_VIBRION_VINES_PLANT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SPORE_GROWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.VIBRION_SPOREHOLDER.get(), RenderType.cutout());
    }

    private void setup(final FMLCommonSetupEvent event)
    {
         event.enqueueWork(() -> {

             BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.WEAKNESS,
                             ModItems.VIBRION.get(), ModPotion.CONTAMINATED_POTION.get()));
         });
    }
}
