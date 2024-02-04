package com.excaliburmod.excalibur_mod.datagen;

import com.excaliburmod.excalibur_mod.Excalibur_Mod;
import com.excaliburmod.excalibur_mod.block.ExcaliburBlocks;
import com.excaliburmod.excalibur_mod.util.ExcaliburTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Excalibur_Mod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //CUSTOM TAGS E FORGE ORE TAGS
        this.tag(ExcaliburTags.Blocks.METAL_DETECTOR_VALUABELS)
                .add(ExcaliburBlocks.SAPPHIRE_ORE.get())
                .add(ExcaliburBlocks.SAPPHIRE_ORE.get())
                .addTags(Tags.Blocks.ORES_NETHERITE_SCRAP)
                .addTags(Tags.Blocks.ORES_DIAMOND)
                .addTags(Tags.Blocks.ORES_IRON);

        this.tag(ExcaliburTags.Blocks.IRON_METAL_DETECTOR_VALUABELS)
                .add(ExcaliburBlocks.SAPPHIRE_ORE.get()).addTags(Tags.Blocks.ORES_IRON);

        this.tag(ExcaliburTags.Blocks.DIAMOND_METAL_DETECTOR_VALUABELS)
                .add(ExcaliburBlocks.SAPPHIRE_ORE.get())
                .addTags(Tags.Blocks.ORES_IRON)
                .addTags(Tags.Blocks.ORES_DIAMOND);

        this.tag(ExcaliburTags.Blocks.NETHERITE_METAL_DETECTOR_VALUABELS)
                .add(ExcaliburBlocks.SAPPHIRE_ORE.get())
                .addTags(Tags.Blocks.ORES_IRON)
                .addTags(Tags.Blocks.ORES_DIAMOND)
                .addTags(Tags.Blocks.ORES_NETHERITE_SCRAP);

        this.tag(ExcaliburTags.Blocks.SAPPHIRE_METAL_DETECTOR_VALUABELS)
                .add(ExcaliburBlocks.SAPPHIRE_ORE.get())
                .addTags(Tags.Blocks.ORES_NETHERITE_SCRAP)
                .addTags(Tags.Blocks.ORES_DIAMOND)
                .addTags(Tags.Blocks.ORES_IRON);

//        this.tag(ExcaliburTags.Blocks.METAL_DETECTOR_VALUABELS)
//                .add(ExcaliburBlocks.SAPPHIRE_ORE.get()).addTag(Tags.Blocks.ORES);

        //VANILLA TOOLS
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ExcaliburBlocks.RAW_SAPPHIRE_BLOCK.get(),
                        ExcaliburBlocks.SAPPHIRE_ORE.get(),
                        ExcaliburBlocks.SAPPHIRE_BLOCK.get(),
                        ExcaliburBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
                        ExcaliburBlocks.END_SAPPHIRE_ORE.get(),
                        ExcaliburBlocks.NETHER_SAPPHIRE_ORE.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE);

        this.tag(BlockTags.MINEABLE_WITH_HOE);

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL);


        //VANILLA TOOLS TYPE
        this.tag(BlockTags.NEEDS_STONE_TOOL);

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ExcaliburBlocks.RAW_SAPPHIRE_BLOCK.get(),
                        ExcaliburBlocks.SAPPHIRE_ORE.get(),
                        ExcaliburBlocks.DEEPSLATE_SAPPHIRE_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ExcaliburBlocks.SAPPHIRE_BLOCK.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ExcaliburBlocks.NETHER_SAPPHIRE_ORE.get(),
                        ExcaliburBlocks.END_SAPPHIRE_ORE.get());

        this.tag(ExcaliburTags.Blocks.NEEDS_SAPPHIRE_TOOL);

        this.tag(BlockTags.FENCES);

        this.tag(BlockTags.FENCE_GATES);

        this.tag(BlockTags.WALLS);

    }
}
