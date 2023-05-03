package net.thesyellow.groundedmc.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.thesyellow.groundedmc.GroundedMC;

@Mod.EventBusSubscriber(modid = GroundedMC.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class modCreativeModeTabs {
    public static CreativeModeTab GROUNDEDMC_TAB;

    @SubscribeEvent
    public static void registerCreativeModTabs(CreativeModeTabEvent.Register event) {
        GROUNDEDMC_TAB = event.registerCreativeModeTab(new ResourceLocation(GroundedMC.MOD_ID, "groundedmc_tab"),
                builder -> builder.icon(() -> new ItemStack(modItems.TEALWIDOW_VENOM.get())).title(Component.translatable("creativemodetab.groundedmc_tab")));
    }
}
