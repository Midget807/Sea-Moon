package net.midget807.seamoon.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.midget807.seamoon.SeaMoonMain;
import net.midget807.seamoon.network.S2C.AffectionParticlePacket;
import net.minecraft.util.Identifier;

public class ModMessages {
    public static Identifier AFFECTION_SPAWN_ID = SeaMoonMain.id("affection_spawn");
    public static void registerC2SPackets() {

    }
    public static void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(AFFECTION_SPAWN_ID, AffectionParticlePacket::receive);
    }

}
