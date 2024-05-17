package net.banze.excalibur.datagen;

import net.banze.excalibur.ExcaliburMod;
import net.banze.excalibur.block.ModBlocks;
import net.banze.excalibur.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> AVALONIAN_SMELTABLES =
            List.of(ModBlocks.AVALONIAN_ORE.get(),
                        ModBlocks.DEEPSLATE_AVALONIAN_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, AVALONIAN_SMELTABLES, RecipeCategory.MISC, ModItems.AVALONIAN_NUGGET.get(), 0.25f, 200, "excalibur");
        oreBlasting(pWriter, AVALONIAN_SMELTABLES, RecipeCategory.MISC, ModItems.AVALONIAN_NUGGET.get(), 0.25f, 100, "excalibur");

        nineBlockStorageRecipes(pWriter,RecipeCategory.MISC,ModItems.AVALONIAN_NUGGET.get(), RecipeCategory.MISC,ModItems.AVALONIAN_INGOT.get(),
                "excalibur:avalonian_nugget", "excalibur","excalibur:avalonian_ingot", "excalibur");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EXCALIBUR_SWORD_UNSOULED.get())
                .pattern("  A")
                .pattern(" A ")
                .pattern("S  ")
                .define('A', ModItems.AVALONIAN_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_excalibur", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.AVALONIAN_INGOT.get()).build()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
                                     List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime,
                            pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, ExcaliburMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
