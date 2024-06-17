package net.midget807.seamoon.network.S2C;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.ParticleTypes;

public class AffectionParticlePacket {
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler,
                        PacketByteBuf buf, PacketSender responseSender) {
        client.particleManager.addParticle(ParticleTypes.HEART, client.player.getParticleX(1.0), client.player.getRandomBodyY(), client.player.getParticleZ(1.0), 1, 1, 1);
    }
}
