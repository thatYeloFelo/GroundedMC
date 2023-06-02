package net.thesyellow.groundedmc.networking;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
import net.thesyellow.groundedmc.GroundedMC;
import net.thesyellow.groundedmc.networking.packet.*;

public class ModMessages {
    private static SimpleChannel INSTANCE;

    private static int packetID = 0;
    private static int id() {
        return packetID++;
    }

    public static void register(){
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(GroundedMC.MOD_ID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(ExampleC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(ExampleC2SPacket::new)
                .encoder(ExampleC2SPacket::toBytes)
                .consumerMainThread(ExampleC2SPacket::handle)
                .add();
        net.messageBuilder(StamDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(StamDataSyncS2CPacket::new)
                .encoder(StamDataSyncS2CPacket::toBytes)
                .consumerMainThread(StamDataSyncS2CPacket::handle)
                .add();
        net.messageBuilder(HuckC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(HuckC2SPacket::new)
                .encoder(HuckC2SPacket::toBytes)
                .consumerMainThread(HuckC2SPacket::handle)
                .add();
        net.messageBuilder(IncStamC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(IncStamC2SPacket::new)
                .encoder(IncStamC2SPacket::toBytes)
                .consumerMainThread(IncStamC2SPacket::handle)
                .add();
        net.messageBuilder(DecrStamC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(DecrStamC2SPacket::new)
                .encoder(DecrStamC2SPacket::toBytes)
                .consumerMainThread(DecrStamC2SPacket::handle)
                .add();
    }

    public static <MSG> void sendToServer(MSG message)  {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}
