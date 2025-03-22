package net.wise.drstonemod.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraftforge.event.entity.living.MobEffectEvent;

public class ModFoods
{
    public static final FoodProperties SULFA_DRUG = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).effect(()-> new MobEffectInstance(MobEffects.HEALTH_BOOST, 200),1.0f).effect(()-> new MobEffectInstance(MobEffects.HEAL, 200),1.0f).build();
}
