package net.thesyellow.groundedmc;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.EventBus;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.thesyellow.groundedmc.block.modBlocks;
import net.thesyellow.groundedmc.entity.client.silkSpinnerRenderer;
import net.thesyellow.groundedmc.entity.modEntities;
import net.thesyellow.groundedmc.item.modCreativeModeTabs;
import net.thesyellow.groundedmc.item.modItems;
import net.thesyellow.groundedmc.networking.ModMessages;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GroundedMC.MOD_ID)
public class GroundedMC
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "groundedmc";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public GroundedMC()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modItems.register(modEventBus);
        modBlocks.register(modEventBus);

        modEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        ModMessages.register();
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == CreativeModeTabs.INGREDIENTS){
            event.accept(modItems.TEALWIDOW_FANG);
            event.accept(modItems.TEALWIDOW_VENOM);
        }
        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(modBlocks.TIGHTLYWOVENWEB);
            event.accept(modBlocks.LOOSELYWOVENWEB);
        }
        if (event.getTab() == modCreativeModeTabs.GROUNDEDMC_TAB){
            event.accept(modItems.TEALWIDOW_FANG);
            event.accept(modItems.TEALWIDOW_VENOM);
            event.accept(modBlocks.TIGHTLYWOVENWEB);
            event.accept(modBlocks.LOOSELYWOVENWEB);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(modEntities.SILKSPINNER.get(), silkSpinnerRenderer::new);
        }
    }
}
