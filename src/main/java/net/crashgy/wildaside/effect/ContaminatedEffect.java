package net.crashgy.wildaside.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.Random;

public class ContaminatedEffect extends MobEffect {

    protected ContaminatedEffect(MobEffectCategory p_19451_, int p_19452_) {
        super(p_19451_, p_19452_);
    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity.isUsingItem()) {
            ItemStack item = pLivingEntity.getUseItem();
//            item.hurtAndBreak(1, pLivingEntity, (user)
//                    -> user.broadcastBreakEvent(pLivingEntity.getUsedItemHand()));
//            item.hurt(1, new Random(), null);
//            item.shrink(1);
//            item.setDamageValue(0);*/
//            item.setDamageValue(item.getDamageValue() + 1);
        }
    }
}