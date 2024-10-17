package net.banze.excalibur.datagen;

import net.banze.excalibur.ExcaliburMod;
import net.banze.excalibur.block.ModBlocks;
import net.banze.excalibur.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                                @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ExcaliburMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.AVALONIAN_BLOCK.get(),
                        ModBlocks.AVALONIAN_ORE.get(),
                        ModBlocks.DEEPSLATE_AVALONIAN_ORE.get(),
                        ModBlocks.RAW_AVALONIAN_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.AVALONIAN_BLOCK.get(),
                        ModBlocks.AVALONIAN_ORE.get(),
                        ModBlocks.DEEPSLATE_AVALONIAN_ORE.get(),
                        ModBlocks.RAW_AVALONIAN_BLOCK.get());

        this.tag(ModTags.Blocks.PAXEL_MINEABLE)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL)
                .addTag(BlockTags.MINEABLE_WITH_AXE);
    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
