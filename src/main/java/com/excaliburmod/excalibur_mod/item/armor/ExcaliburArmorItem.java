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
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(ExcaliburArmorMaterials.SAPPHIRE, new MobEffectInstance(MobEffects.NIGHT_VISION, 100, 0,
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

            List<ItemStack> armor = (List<ItemStack>) pEntity.getArmorSlots();
            if((armor.get(0).getItem() == narmor.get(0).getItem())&&(armor.get(1).getItem() == narmor.get(1).getItem())&&
                    (armor.get(2).getItem() == narmor.get(2).getItem())&&(armor.get(3).getItem() == narmor.get(3).getItem())) {

                for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
                    MobEffectInstance mapStatusEffect = entry.getValue();
                    ((LivingEntity) pEntity).addEffect(new MobEffectInstance(mapStatusEffect));
                }
            }

        }

        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

}
