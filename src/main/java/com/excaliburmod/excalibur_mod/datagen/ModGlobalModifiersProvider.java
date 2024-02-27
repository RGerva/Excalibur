package com.excaliburmod.excalibur_mod.datagen;

import com.excaliburmod.excalibur_mod.Excalibur_Mod;
import com.excaliburmod.excalibur_mod.item.ExcaliburItems;
import com.excaliburmod.excalibur_mod.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalModifiersProvider(PackOutput output) {
        super(output, Excalibur_Mod.MOD_ID);
    }

    @Override
    protected void start() {
        add("strawberry_seeds_form_grass", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.1f).build()}, ExcaliburItems.STRAWBERRY_SEEDS.get()));

    }
}
