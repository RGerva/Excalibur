package com.excaliburmod.excalibur_mod.item.armor;

import com.excaliburmod.excalibur_mod.Excalibur_Mod;
import com.excaliburmod.excalibur_mod.item.ExcaliburItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ExcaliburArmorMaterials implements ArmorMaterial {
    SAPPHIRE_HELMET("sapphire", 1, new int[]{5, 0, 0, 0}, 25,
    SoundEvents.ARMOR_EQUIP_CHAIN, 4f,0.3f, () -> Ingredient.of(ExcaliburItems.SAPPHIRE.get())),
    SAPPHIRE_CHESTPLATE("sapphire", 2, new int[]{0, 10, 0 , 0}, 30,
    SoundEvents.ARMOR_EQUIP_CHAIN, 8f, 1f, () -> Ingredient.of(ExcaliburItems.SAPPHIRE.get())),
    SAPPHIRE_LEGGING("sapphire", 1, new int[]{0, 0, 8 , 0}, 25,
    SoundEvents.ARMOR_EQUIP_CHAIN, 4f, 0.2f, () -> Ingredient.of(ExcaliburItems.SAPPHIRE.get())),
    SAPPHIRE_BOOT("sapphire", 1, new int[]{0, 0, 0 , 5}, 25,
    SoundEvents.ARMOR_EQUIP_CHAIN, 3f, 0.1f, () -> Ingredient.of(ExcaliburItems.SAPPHIRE.get()));
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistence;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = {11 , 16, 15, 13};

    ExcaliburArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistence, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistence = knockbackResistence;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal() * this.durabilityMultiplier];
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return Excalibur_Mod.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistence;
    }
}
