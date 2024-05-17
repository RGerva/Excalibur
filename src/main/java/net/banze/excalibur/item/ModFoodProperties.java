package net.banze.excalibur.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties NIMUE_HEART = new FoodProperties.Builder()
            .nutrition(50)
            .saturationMod(50f)
            .effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 200), 0.1f)
            .build();

    public static final FoodProperties NIMUE_SOUL = new FoodProperties.Builder()
            .nutrition(25)
            .saturationMod(75f)
            .effect(() -> new MobEffectInstance(MobEffects.INVISIBILITY, 200), 0.1f)
            .build();
}
