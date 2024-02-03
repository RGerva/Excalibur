package com.excaliburmod.excalibur_mod.datagen;

import com.excaliburmod.excalibur_mod.Excalibur_Mod;
import com.excaliburmod.excalibur_mod.block.ExcaliburBlocks;
import com.excaliburmod.excalibur_mod.item.ExcaliburItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecepieProvider extends RecipeProvider implements IConditionBuilder {
    public static final List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ExcaliburItems.RAW_SAPPHIRE.get(),
            ExcaliburBlocks.SAPPHIRE_ORE.get(),ExcaliburBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
            ExcaliburBlocks.NETHER_SAPPHIRE_ORE.get(),ExcaliburBlocks.END_SAPPHIRE_ORE.get());
     public ModRecepieProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ExcaliburItems.SAPPHIRE.get(), 0.25f, 200, "sapphire");
        oreBlasting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ExcaliburItems.SAPPHIRE.get(), 0.7f, 100, "sapphire");

        //SAPPHIRE BLOCK TO SAPPHIRE
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ExcaliburBlocks.SAPPHIRE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ExcaliburItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ExcaliburItems.SAPPHIRE.get()), has(ExcaliburItems.SAPPHIRE.get()))
                .save(pWriter);

        //SAPPHIRE TO SAPPHIRE BLOCK
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ExcaliburItems.SAPPHIRE.get(), 9)
                .requires(ExcaliburBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ExcaliburBlocks.SAPPHIRE_BLOCK.get()), has(ExcaliburBlocks.SAPPHIRE_BLOCK.get()))
                .save(pWriter);

        //RAW SAPPHIRE BLOCK TO RAW SAPPHIRE
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ExcaliburBlocks.RAW_SAPPHIRE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ExcaliburItems.RAW_SAPPHIRE.get())
                .unlockedBy(getHasName(ExcaliburItems.RAW_SAPPHIRE.get()), has(ExcaliburItems.RAW_SAPPHIRE.get()))
                .save(pWriter);

        //RAW SAPPHIRE TO RAW SAPPHIRE BLOCK
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ExcaliburItems.RAW_SAPPHIRE.get(), 9)
                .requires(ExcaliburBlocks.RAW_SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ExcaliburItems.RAW_SAPPHIRE.get()), has(ExcaliburItems.RAW_SAPPHIRE.get()))
                .save(pWriter);

        //SAPPHIRE PICKAXE
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(new ItemLike[]{ExcaliburItems.SAPPHIRE_SMITHING.get()}),
                        Ingredient.of(Items.NETHERITE_PICKAXE),
                        Ingredient.of(ExcaliburItems.SAPPHIRE.get()),
                        RecipeCategory.MISC,
                        ExcaliburItems.SAPPHIRE_PICKAXE.get())
                .unlocks(getHasName(ExcaliburItems.SAPPHIRE_PICKAXE.get()), has(ExcaliburItems.SAPPHIRE_PICKAXE.get()))
                .save(pWriter, getItemName(ExcaliburItems.SAPPHIRE_PICKAXE.get()));

        //SAPPHIRE SWORD
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(new ItemLike[]{ExcaliburItems.SAPPHIRE_SMITHING.get()}),
                        Ingredient.of(Items.NETHERITE_SWORD),
                        Ingredient.of(ExcaliburItems.SAPPHIRE.get()),
                        RecipeCategory.MISC,
                        ExcaliburItems.SAPPHIRE_SWORD.get())
                .unlocks(getHasName(ExcaliburItems.SAPPHIRE_SWORD.get()), has(ExcaliburItems.SAPPHIRE_SWORD.get()))
                .save(pWriter, getItemName(ExcaliburItems.SAPPHIRE_SWORD.get()));

        //SAPPHIRE AXE
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(new ItemLike[]{ExcaliburItems.SAPPHIRE_SMITHING.get()}),
                        Ingredient.of(Items.NETHERITE_AXE),
                        Ingredient.of(ExcaliburItems.SAPPHIRE.get()),
                        RecipeCategory.MISC,
                        ExcaliburItems.SAPPHIRE_AXE.get())
                .unlocks(getHasName(ExcaliburItems.SAPPHIRE_AXE.get()), has(ExcaliburItems.SAPPHIRE_AXE.get()))
                .save(pWriter, getItemName(ExcaliburItems.SAPPHIRE_AXE.get()));

        //SAPPHIRE SHOEVEL
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(new ItemLike[]{ExcaliburItems.SAPPHIRE_SMITHING.get()}),
                        Ingredient.of(Items.NETHERITE_SHOVEL),
                        Ingredient.of(ExcaliburItems.SAPPHIRE.get()),
                        RecipeCategory.MISC,
                        ExcaliburItems.SAPPHIRE_SHOVEL.get())
                .unlocks(getHasName(ExcaliburItems.SAPPHIRE_SHOVEL.get()), has(ExcaliburItems.SAPPHIRE_SHOVEL.get()))
                .save(pWriter, getItemName(ExcaliburItems.SAPPHIRE_SHOVEL.get()));

        //SAPPHIRE HOE
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(new ItemLike[]{ExcaliburItems.SAPPHIRE_SMITHING.get()}),
                        Ingredient.of(Items.NETHERITE_HOE),
                        Ingredient.of(ExcaliburItems.SAPPHIRE.get()),
                        RecipeCategory.MISC,
                        ExcaliburItems.SAPPHIRE_HOE.get())
                .unlocks(getHasName(ExcaliburItems.SAPPHIRE_HOE.get()), has(ExcaliburItems.SAPPHIRE_HOE.get()))
                .save(pWriter, getItemName(ExcaliburItems.SAPPHIRE_HOE.get()));

        //SAPPHIRE HELMET
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(new ItemLike[]{ExcaliburItems.SAPPHIRE_SMITHING.get()}),
                        Ingredient.of(Items.NETHERITE_HELMET),
                        Ingredient.of(ExcaliburItems.SAPPHIRE.get()),
                        RecipeCategory.MISC,
                        ExcaliburItems.SAPPHIRE_HELMET.get())
                .unlocks(getHasName(ExcaliburItems.SAPPHIRE_HELMET.get()), has(ExcaliburItems.SAPPHIRE_HELMET.get()))
                .save(pWriter, getItemName(ExcaliburItems.SAPPHIRE_HELMET.get()));

        //SAPPHIRE CHESTPLATE
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(new ItemLike[]{ExcaliburItems.SAPPHIRE_SMITHING.get()}),
                        Ingredient.of(Items.NETHERITE_CHESTPLATE),
                        Ingredient.of(ExcaliburItems.SAPPHIRE.get()),
                        RecipeCategory.MISC,
                        ExcaliburItems.SAPPHIRE_CHESTPLATE.get())
                .unlocks(getHasName(ExcaliburItems.SAPPHIRE_CHESTPLATE.get()), has(ExcaliburItems.SAPPHIRE_CHESTPLATE.get()))
                .save(pWriter, getItemName(ExcaliburItems.SAPPHIRE_CHESTPLATE.get()));

        //SAPPHIRE LEGGING
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(new ItemLike[]{ExcaliburItems.SAPPHIRE_SMITHING.get()}),
                        Ingredient.of(Items.NETHERITE_LEGGINGS),
                        Ingredient.of(ExcaliburItems.SAPPHIRE.get()),
                        RecipeCategory.MISC,
                        ExcaliburItems.SAPPHIRE_LEGGINGS.get())
                .unlocks(getHasName(ExcaliburItems.SAPPHIRE_LEGGINGS.get()), has(ExcaliburItems.SAPPHIRE_LEGGINGS.get()))
                .save(pWriter, getItemName(ExcaliburItems.SAPPHIRE_LEGGINGS.get()));

        //SAPPHIRE BOOTS
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(new ItemLike[]{ExcaliburItems.SAPPHIRE_SMITHING.get()}),
                        Ingredient.of(Items.NETHERITE_BOOTS),
                        Ingredient.of(ExcaliburItems.SAPPHIRE.get()),
                        RecipeCategory.MISC,
                        ExcaliburItems.SAPPHIRE_BOOTS.get())
                .unlocks(getHasName(ExcaliburItems.SAPPHIRE_BOOTS.get()), has(ExcaliburItems.SAPPHIRE_BOOTS.get()))
                .save(pWriter, getItemName(ExcaliburItems.SAPPHIRE_BOOTS.get()));
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {

        for (ItemLike itemlike : pIngredients){
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, Excalibur_Mod.MOD_ID + ":"+ getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
