package net.thesyellow.groundedmc.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.thesyellow.groundedmc.GroundedMC;
import net.thesyellow.groundedmc.client.StaminaHudOverlay;
import net.thesyellow.groundedmc.networking.ModMessages;
import net.thesyellow.groundedmc.networking.packet.HuckC2SPacket;
import net.thesyellow.groundedmc.networking.packet.IncStamC2SPacket;
import net.thesyellow.groundedmc.util.KeyBinding;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = GroundedMC.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents{
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if(KeyBinding.HUCK_KEY.consumeClick()) {
                ModMessages.sendToServer(new HuckC2SPacket());
            }
            if(KeyBinding.INCSTAM_KEY.consumeClick()) {
                ModMessages.sendToServer(new IncStamC2SPacket());
            }
            if(KeyBinding.DECRSTAM_KEY.consumeClick()) {
                ModMessages.sendToServer(new HuckC2SPacket());
            }
        }
    }
    @Mod.EventBusSubscriber(modid = GroundedMC.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event){
            event.register(KeyBinding.HUCK_KEY);
            event.register(KeyBinding.DECRSTAM_KEY);
            event.register(KeyBinding.INCSTAM_KEY);
        }

        @SubscribeEvent
        public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
            event.registerAboveAll("stamina", StaminaHudOverlay.HUD_STAMINA);
        }
    }
}
