package com.excaliburmod.excalibur_mod.util;

import com.excaliburmod.excalibur_mod.Excalibur_Mod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ExcaliburTags {
    public static class Blocks{
        public static final TagKey<Block> NEEDS_SAPPHIRE_TOOL = tag("needs_sapphire_tool");

        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(Excalibur_Mod.MOD_ID, name));
        }
    }

    public static class Items{
        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(Excalibur_Mod.MOD_ID, name));
        }
    }
}
