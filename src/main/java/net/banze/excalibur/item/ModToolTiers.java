package net.banze.excalibur.item;

import net.banze.excalibur.ExcaliburMod;
import net.banze.excalibur.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier EXCALIBUR_TIER = TierSortingRegistry.registerTier(
            new ForgeTier(5, 15000, 10, 11.0F, 85,
                    ModTags.Blocks.NEEDS_EXCALIBUR_TOOL, ()-> Ingredient.of(ModItems.AVALONIAN_INGOT.get())),
            new ResourceLocation(ExcaliburMod.MOD_ID,"excalibur"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier EXCALIBUR_UNSOULED_TIER = TierSortingRegistry.registerTier(
            new ForgeTier(1, 15000, 1, 0F, 1,
                    ModTags.Blocks.NEEDS_EXCALIBUR_TOOL, ()-> Ingredient.of(ModItems.AVALONIAN_INGOT.get())),
            new ResourceLocation(ExcaliburMod.MOD_ID,"excalibur_unsouled"), List.of(Tiers.STONE), List.of());

    public static final Tier AVALONIAN_TIER = TierSortingRegistry.registerTier(
            new ForgeTier(5, 15000, 1, 1F, 50,
                    ModTags.Blocks.NEEDS_EXCALIBUR_TOOL, ()-> Ingredient.of(ModItems.AVALONIAN_INGOT.get())),
            new ResourceLocation(ExcaliburMod.MOD_ID,"avalonian_tools"), List.of(Tiers.NETHERITE), List.of());

}
