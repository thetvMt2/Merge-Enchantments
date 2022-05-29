package com.dplayend.merenc.mixin;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

import java.util.List;

@Mixin(MiningToolItem.class)
public class MixinMiningToolItem extends ToolItem implements Vanishable {
    public MixinMiningToolItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (stack.getOrCreateNbt().getList("Enchantments", 10).toString().contains("silk_touch")) {
            int index = (stack.getOrCreateNbt().getList("Enchantments", 10).toString().lastIndexOf("silk_touch")) / 33;
            if (stack.getOrCreateNbt().getList("Enchantments", 10).getCompound(index).getInt("lvl") != 1) {
                tooltip.add(new TranslatableText("text.merenc.disabledSilkTouch"));
            } else {
                tooltip.add(new TranslatableText("text.merenc.enabledSilkTouch"));
            }
        }
    }
}
