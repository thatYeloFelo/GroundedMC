package net.thesyellow.groundedmc.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.network.NetworkEvent;
import net.thesyellow.groundedmc.networking.ModMessages;
import net.thesyellow.groundedmc.stamina.PlayerStamina;
import net.thesyellow.groundedmc.stamina.PlayerStaminaProvider;

import java.util.function.Supplier;

public class DecrStamC2SPacket {

    public DecrStamC2SPacket() {

    }

    public DecrStamC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();
            player.getCapability(PlayerStaminaProvider.PLAYER_STAMINA).ifPresent(stamina -> {
                stamina.subStamina(10);
                player.sendSystemMessage(Component.literal("Current Stamina " + stamina.getStamina()));
            });
        });
        return true;
    }
}