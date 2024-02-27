package com.excaliburmod.excalibur_mod.item.armor;

import com.excaliburmod.excalibur_mod.Excalibur_Mod;
import com.excaliburmod.excalibur_mod.item.ExcaliburItems;
import com.google.common.collect.ImmutableMap;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.server.dedicated.Settings;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcaliburArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP_SAPPHIRE =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(ExcaliburArmorMaterials.SAPPHIRE, new MobEffectInstance(MobEffects.NIGHT_VISION, 100, 0,
                            false,false, true)).build();

    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP_RUBY =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(ExcaliburArmorMaterials.RUBY, new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100, 3,
                            false,false, true)).build();

    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP_MYTHRIL =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(ExcaliburArmorMaterials.MYTHRIL, new MobEffectInstance(MobEffects.LUCK, 100, 4,
                            false,false, true)).build();

    public ExcaliburArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if(!pLevel.isClientSide()){


            List<ItemStack> narmor = new ArrayList<ItemStack>();
            narmor.add(new ItemStack(ExcaliburItems.SAPPHIRE_BOOTS.get()));
            narmor.add(new ItemStack(ExcaliburItems.SAPPHIRE_LEGGINGS.get()));
            narmor.add(new ItemStack(ExcaliburItems.SAPPHIRE_CHESTPLATE.get()));
            narmor.add(new ItemStack(ExcaliburItems.SAPPHIRE_HELMET.get()));

            narmor.add(new ItemStack(ExcaliburItems.RUBY_BOOTS.get()));
            narmor.add(new ItemStack(ExcaliburItems.RUBY_LEGGINGS.get()));
            narmor.add(new ItemStack(ExcaliburItems.RUBY_CHESTPLATE.get()));
            narmor.add(new ItemStack(ExcaliburItems.RUBY_HELMET.get()));

            narmor.add(new ItemStack(ExcaliburItems.MYTHRIL_BOOTS.get()));
            narmor.add(new ItemStack(ExcaliburItems.MYTHRIL_LEGGINGS.get()));
            narmor.add(new ItemStack(ExcaliburItems.MYTHRIL_CHESTPLATE.get()));
            narmor.add(new ItemStack(ExcaliburItems.MYTHRIL_HELMET.get()));


            List<ItemStack> armor = (List<ItemStack>) pEntity.getArmorSlots();
            if((armor.get(0).getItem() == narmor.get(0).getItem())&&(armor.get(1).getItem() == narmor.get(1).getItem())&&
                    (armor.get(2).getItem() == narmor.get(2).getItem())&&(armor.get(3).getItem() == narmor.get(3).getItem())) {

                for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP_SAPPHIRE.entrySet()) {
                    MobEffectInstance mapStatusEffect = entry.getValue();
                    ((LivingEntity) pEntity).addEffect(new MobEffectInstance(mapStatusEffect));
                }
            }else if((armor.get(0).getItem() == narmor.get(4).getItem())&&(armor.get(1).getItem() == narmor.get(5).getItem())&&
                    (armor.get(2).getItem() == narmor.get(6).getItem())&&(armor.get(3).getItem() == narmor.get(7).getItem())) {

                for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP_RUBY.entrySet()) {
                    MobEffectInstance mapStatusEffect = entry.getValue();
                    ((LivingEntity) pEntity).addEffect(new MobEffectInstance(mapStatusEffect));
                }
            }else if((armor.get(0).getItem() == narmor.get(8).getItem())&&(armor.get(1).getItem() == narmor.get(9).getItem())&&
                    (armor.get(2).getItem() == narmor.get(10).getItem())&&(armor.get(3).getItem() == narmor.get(11).getItem())) {

                for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP_MYTHRIL.entrySet()) {
                    MobEffectInstance mapStatusEffect = entry.getValue();
                    ((LivingEntity) pEntity).addEffect(new MobEffectInstance(mapStatusEffect));
                }
            }

        }

        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

}
