package net.thesyellow.groundedmc.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.thesyellow.groundedmc.networking.ModMessages;
import net.thesyellow.groundedmc.stamina.PlayerStaminaProvider;

import java.util.function.Supplier;

public class IncStamC2SPacket {

    public IncStamC2SPacket() {

    }

    public IncStamC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();
            player.getCapability(PlayerStaminaProvider.PLAYER_STAMINA).ifPresent(stamina -> {
                stamina.addStamina(10);
                player.sendSystemMessage(Component.literal("Current Stamina " + stamina.getStamina()));
            });
        });

        return true;
    }
}