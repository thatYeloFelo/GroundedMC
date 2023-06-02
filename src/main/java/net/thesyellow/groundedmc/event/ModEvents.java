package net.thesyellow.groundedmc.event;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.thesyellow.groundedmc.GroundedMC;
import net.thesyellow.groundedmc.networking.ModMessages;
import net.thesyellow.groundedmc.networking.packet.StamDataSyncS2CPacket;
import net.thesyellow.groundedmc.stamina.PlayerStamina;
import net.thesyellow.groundedmc.stamina.PlayerStaminaProvider;

public class ModEvents {
    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player) {
            if(!event.getObject().getCapability(PlayerStaminaProvider.PLAYER_STAMINA).isPresent()) {
                event.addCapability(new ResourceLocation(GroundedMC.MOD_ID, "properties"), new PlayerStaminaProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerStaminaProvider.PLAYER_STAMINA).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerStaminaProvider.PLAYER_STAMINA).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerStamina.class);
    }
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.side == LogicalSide.SERVER) {
            event.player.getCapability(PlayerStaminaProvider.PLAYER_STAMINA).ifPresent(stamina -> {
                if(stamina.getStamina() > 0 && event.player.getRandom().nextFloat() < 0.01f) { // Once Every 5 Seconds on Avg
                    stamina.addStamina(5);
                    event.player.sendSystemMessage(Component.literal("Restored Stamina"));
                }

            });
        }
    }
    public static void onPlayerJoin(EntityJoinLevelEvent event){
        if (!event.getLevel().isClientSide()){
            if (event.getEntity()instanceof ServerPlayer player){
                player.getCapability(PlayerStaminaProvider.PLAYER_STAMINA).ifPresent(stamina -> {
                    ModMessages.sendToPlayer(new StamDataSyncS2CPacket(stamina.getStamina()), player);
                });
            }
        }
    }
}
