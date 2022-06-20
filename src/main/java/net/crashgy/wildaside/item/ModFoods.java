package net.crashgy.wildaside.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static final FoodProperties VIBRION =
            (new FoodProperties.Builder())
                    .nutrition(4)
                    .saturationMod(0.6F)
                    .effect(new MobEffectInstance(MobEffects.POISON, 100, 0), 0.5F)
                    .alwaysEat()
                    .build();
}