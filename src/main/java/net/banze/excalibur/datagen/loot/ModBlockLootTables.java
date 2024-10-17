package net.banze.excalibur.datagen.loot;

import net.banze.excalibur.block.ModBlocks;
import net.banze.excalibur.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.AVALONIAN_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_AVALONIAN_BLOCK.get());
        this.dropSelf(ModBlocks.AVALONIAN_FURNACE.get());

        this.add(ModBlocks.AVALONIAN_ORE.get(),
                block -> createOreDrop(ModBlocks.AVALONIAN_ORE.get(), ModItems.RAW_AVALONIAN.get()));

        this.add(ModBlocks.DEEPSLATE_AVALONIAN_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_AVALONIAN_ORE.get(), ModItems.RAW_AVALONIAN.get()));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
