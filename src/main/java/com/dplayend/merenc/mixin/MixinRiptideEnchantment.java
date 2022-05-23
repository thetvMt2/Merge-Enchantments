package com.dplayend.merenc.mixin;

import com.dplayend.merenc.MergeEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.RiptideEnchantment;
import net.minecraft.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RiptideEnchantment.class)
public class MixinRiptideEnchantment extends Enchantment {
    public MixinRiptideEnchantment(Rarity weight, EquipmentSlot... slotTypes) {
        super(weight, EnchantmentTarget.TRIDENT, slotTypes);
    }
    @Inject(method = "canAccept", at = @At("HEAD"), cancellable = true)
    private void canAccept(Enchantment other, CallbackInfoReturnable<Boolean> info) {
        if (MergeEnchantments.CONFIG.trident) {
            info.cancel();
            info.setReturnValue(super.canAccept(other));
        }
    }
}
