package com.dplayend.merenc.network;

import com.dplayend.merenc.MergeEnchantments;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

public class ServerNetworking {
    public static Identifier TOGGLE_FROST_WALKER = new Identifier(MergeEnchantments.MOD_ID,"toggle_frost_walker");
    public static Identifier TOGGLE_SILK_TOUCH = new Identifier(MergeEnchantments.MOD_ID,"toggle_silk_touch");
    public static boolean isFrostWalker = true;
    public static boolean isSilkTouch = true;

    public static void init() {
        registerFrostWalkerKey();
        //registerSilkTouchKey();
    }

    private static void registerFrostWalkerKey() {
        ServerPlayNetworking.registerGlobalReceiver(TOGGLE_FROST_WALKER, ServerNetworking::toggleFrostWalker);
    }
    private static void registerSilkTouchKey() {
        ServerPlayNetworking.registerGlobalReceiver(TOGGLE_SILK_TOUCH, ServerNetworking::toggleSilkTouch);
    }

    private static void toggleFrostWalker(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        isFrostWalker = !isFrostWalker;
        if (isFrostWalker) {
            player.sendMessage(new TranslatableText("text.merenc.enabledFrostWalker"), true);
        } else {
            player.sendMessage(new TranslatableText("text.merenc.disabledFrostWalker"), true);
        }
    }

    private static void toggleSilkTouch(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        isSilkTouch = !isSilkTouch;
        if (isSilkTouch) {
            player.sendMessage(new TranslatableText("text.merenc.enabledSilkTouch"), true);
        } else {
            player.sendMessage(new TranslatableText("text.merenc.disabledSilkTouch"), true);
        }
    }
}
