package com.excaliburmod.excalibur_mod.datagen;

import com.excaliburmod.excalibur_mod.Excalibur_Mod;
import com.excaliburmod.excalibur_mod.item.ExcaliburItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, Excalibur_Mod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ExcaliburItems.SAPPHIRE_HELMET.get())
                .add(ExcaliburItems.SAPPHIRE_CHESTPLATE.get())
                .add(ExcaliburItems.SAPPHIRE_LEGGINGS.get())
                .add(ExcaliburItems.SAPPHIRE_BOOTS.get())
                .add(ExcaliburItems.RUBY_HELMET.get())
                .add(ExcaliburItems.RUBY_CHESTPLATE.get())
                .add(ExcaliburItems.RUBY_LEGGINGS.get())
                .add(ExcaliburItems.RUBY_BOOTS.get());

        this.tag(ItemTags.MUSIC_DISCS);

        this.tag(ItemTags.MUSIC_DISCS);

        this.tag(ItemTags.CREEPER_DROP_MUSIC_DISCS);
    }
}
