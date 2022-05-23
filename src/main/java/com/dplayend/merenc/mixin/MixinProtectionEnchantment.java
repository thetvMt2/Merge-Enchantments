package com.dplayend.merenc.mixin;

import com.dplayend.merenc.MergeEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.enchantment.ProtectionEnchantment.Type;
import net.minecraft.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ProtectionEnchantment.class)
public class MixinProtectionEnchantment extends Enchantment {
    public final ProtectionEnchantment.Type protectionType;

    public MixinProtectionEnchantment(Rarity weight, Type protectionType, EquipmentSlot... slotTypes) {
        super(weight, protectionType == Type.FALL ? EnchantmentTarget.ARMOR_FEET : EnchantmentTarget.ARMOR, slotTypes);
        this.protectionType = protectionType;
    }

    @Inject(method = "canAccept", at = @At("HEAD"), cancellable = true)
    private void canAccept(Enchantment other, CallbackInfoReturnable<Boolean> info) {
        if (MergeEnchantments.CONFIG.protection) {
            info.cancel();
            info.setReturnValue(super.canAccept(other));
        }
    }
}
