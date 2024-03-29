package com.excaliburmod.excalibur_mod.datagen.loot;

import com.excaliburmod.excalibur_mod.block.ExcaliburBlocks;
import com.excaliburmod.excalibur_mod.block.custom.crops.StrawberryCropBlock;
import com.excaliburmod.excalibur_mod.item.ExcaliburItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ExcaliburBlocks.SAPPHIRE_BLOCK.get());
        this.dropSelf(ExcaliburBlocks.ZIRCON_BLOCK.get());
        this.dropSelf(ExcaliburBlocks.MYTHRIL_BLOCK.get());
        this.dropSelf(ExcaliburBlocks.RAW_SAPPHIRE_BLOCK.get());
        this.dropSelf(ExcaliburBlocks.RAW_MYTHRIL_BLOCK.get());

        this.add(ExcaliburBlocks.SAPPHIRE_ORE.get(),
                block -> createCustomSapphireOreDrops(ExcaliburBlocks.SAPPHIRE_ORE.get(), ExcaliburItems.RAW_SAPPHIRE.get(), 2.0F,5.0F));

        this.add(ExcaliburBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                block -> createCustomSapphireOreDrops(ExcaliburBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ExcaliburItems.RAW_SAPPHIRE.get(), 2.0F, 5.0F));

        this.add(ExcaliburBlocks.NETHER_SAPPHIRE_ORE.get(),
                block -> createCustomSapphireOreDrops(ExcaliburBlocks.NETHER_SAPPHIRE_ORE.get(), ExcaliburItems.RAW_SAPPHIRE.get(), 0.3F, 0.7F));

        this.add(ExcaliburBlocks.END_SAPPHIRE_ORE.get(),
                block -> createCustomSapphireOreDrops(ExcaliburBlocks.END_SAPPHIRE_ORE.get(),ExcaliburItems.RAW_SAPPHIRE.get(), 0.5F, 10.0F));

        this.add(ExcaliburBlocks.ZIRCON_ORE.get(),
                block -> createCustomSapphireOreDrops(ExcaliburBlocks.ZIRCON_ORE.get(), ExcaliburItems.RAW_ZIRCON.get(), 2.0F,5.0F));

        this.add(ExcaliburBlocks.DEEPSLATE_ZIRCON_ORE.get(),
                block -> createCustomSapphireOreDrops(ExcaliburBlocks.DEEPSLATE_ZIRCON_ORE.get(), ExcaliburItems.RAW_ZIRCON.get(), 2.0F, 5.0F));

        this.add(ExcaliburBlocks.NETHER_ZIRCON_ORE.get(),
                block -> createCustomSapphireOreDrops(ExcaliburBlocks.NETHER_ZIRCON_ORE.get(), ExcaliburItems.RAW_ZIRCON.get(), 0.3F, 0.7F));

        this.add(ExcaliburBlocks.END_ZIRCON_ORE.get(),
                block -> createCustomSapphireOreDrops(ExcaliburBlocks.END_ZIRCON_ORE.get(),ExcaliburItems.RAW_ZIRCON.get(), 0.5F, 10.0F));

        this.add(ExcaliburBlocks.MYTHRIL_ORE.get(),
                block -> createCustomSapphireOreDrops(ExcaliburBlocks.MYTHRIL_ORE.get(), ExcaliburItems.RAW_MYTHRIL.get(), 2.0F,5.0F));

        this.add(ExcaliburBlocks.DEEPSLATE_MYTHRIL_ORE.get(),
                block -> createCustomSapphireOreDrops(ExcaliburBlocks.DEEPSLATE_MYTHRIL_ORE.get(), ExcaliburItems.RAW_MYTHRIL.get(), 2.0F, 5.0F));


        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ExcaliburBlocks.STRAWBERRY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(StrawberryCropBlock.AGE, 5));

        this.add(ExcaliburBlocks.STRAWBERRY_CROP.get(), createCropDrops(ExcaliburBlocks.STRAWBERRY_CROP.get(), ExcaliburItems.STRAWBERRY.get(),
                ExcaliburItems.STRAWBERRY_SEEDS.get(), lootitemcondition$builder));

    }

    //CUSTOM DROP SETTINGS
    protected LootTable.Builder createCustomSapphireOreDrops(Block pBlock, Item item, float ExpMin, float ExpMax) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(ExpMin, ExpMax)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ExcaliburBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
