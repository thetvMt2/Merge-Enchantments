package com.dplayend.merenc;

import com.dplayend.merenc.network.ServerNetworking;
import io.netty.buffer.Unpooled;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.network.PacketByteBuf;
import org.lwjgl.glfw.GLFW;

public class MergeEnchantmentsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyBinding TOGGLE_FROST_WALKER = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.merenc.frostWalker", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_K, "category.merenc.mergeEnchantments"));
        KeyBinding TOGGLE_SILK_TOUCH = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.merenc.silkTouch", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_J, "category.merenc.mergeEnchantments"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (TOGGLE_FROST_WALKER.wasPressed()) { ClientPlayNetworking.send(ServerNetworking.TOGGLE_FROST_WALKER, new PacketByteBuf(Unpooled.buffer())); }
            while (TOGGLE_SILK_TOUCH.wasPressed()) { ClientPlayNetworking.send(ServerNetworking.TOGGLE_SILK_TOUCH, new PacketByteBuf(Unpooled.buffer())); }
        });
    }
}
