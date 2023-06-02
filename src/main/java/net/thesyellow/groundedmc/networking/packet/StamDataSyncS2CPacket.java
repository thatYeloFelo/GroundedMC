package net.thesyellow.groundedmc.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.thesyellow.groundedmc.client.ClientStaminaData;

import java.util.function.Supplier;

public class StamDataSyncS2CPacket {
    private final int stamina;

    public StamDataSyncS2CPacket(int stamina) {
        this.stamina = stamina;
    }

    public StamDataSyncS2CPacket(FriendlyByteBuf buf) {
        this.stamina = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(stamina);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE CLIENT!
            ClientStaminaData.set(stamina);
        });

        return true;
    }

}