package com.dplayend.merenc;

import com.dplayend.merenc.handler.HandlerClothConfig;
import com.dplayend.merenc.network.ServerNetworking;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class MergeEnchantments implements ModInitializer {
    public static final String MOD_ID = "merenc";
    public static HandlerClothConfig CONFIG = new HandlerClothConfig();

    @Override
    public void onInitialize() {
        AutoConfig.register(HandlerClothConfig.class, GsonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(HandlerClothConfig.class).getConfig();

        ServerNetworking.init();
    }
}
