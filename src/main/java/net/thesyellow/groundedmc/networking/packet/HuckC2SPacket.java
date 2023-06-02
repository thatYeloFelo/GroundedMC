package net.thesyellow.groundedmc.networking.packet;

import net.thesyellow.groundedmc.networking.ModMessages;
import net.thesyellow.groundedmc.stamina.PlayerStaminaProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class HuckC2SPacket {

    public HuckC2SPacket() {

    }

    public HuckC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE SERVER!
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();
            player.getCapability(PlayerStaminaProvider.PLAYER_STAMINA).ifPresent(stamina -> {
                stamina.subStamina(10);
                ModMessages.sendToPlayer(new StamDataSyncS2CPacket(stamina.getStamina()), player);
                player.sendSystemMessage(Component.literal("Threw something for 10% Stamina and hit yourself"));
                });
        });
        return true;
    }
}