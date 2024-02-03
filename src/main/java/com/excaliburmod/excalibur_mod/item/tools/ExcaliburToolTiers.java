package com.excaliburmod.excalibur_mod.item.tools;

import com.excaliburmod.excalibur_mod.Excalibur_Mod;
import com.excaliburmod.excalibur_mod.item.ExcaliburItems;
import com.excaliburmod.excalibur_mod.util.ExcaliburTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ExcaliburToolTiers {
    public static final Tier SAPPHIRE = TierSortingRegistry.registerTier(
            new ForgeTier(5,3000,9f,4f,25,
                    ExcaliburTags.Blocks.NEEDS_SAPPHIRE_TOOL, () -> Ingredient.of(ExcaliburItems.SAPPHIRE.get())),
            new ResourceLocation(Excalibur_Mod.MOD_ID, "sapphire"), List.of(Tiers.NETHERITE), List.of());
}
