package com.dplayend.merenc.mixin;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Wearable;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

import java.util.List;

@Mixin(ArmorItem.class)
public class MixinArmorItem extends Item implements Wearable {
    public MixinArmorItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (stack.getOrCreateNbt().getList("Enchantments", 10).toString().contains("frost_walker")) {
            if (!stack.getOrCreateNbt().getBoolean("isFrostWalker")) {
                tooltip.add(new TranslatableText("text.merenc.enabledFrostWalker"));
            } else {
                tooltip.add(new TranslatableText("text.merenc.disabledFrostWalker"));
            }
        }
    }
}
