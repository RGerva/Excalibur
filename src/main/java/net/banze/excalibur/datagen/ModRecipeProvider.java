package net.banze.excalibur.datagen;

import net.banze.excalibur.ExcaliburMod;
import net.banze.excalibur.block.ModBlocks;
import net.banze.excalibur.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> EXCALIBUR_SMELTABLES =
            List.of(ModBlocks.AVALONIAN_ORE.get(),
                        ModBlocks.DEEPSLATE_AVALONIAN_ORE.get(),
                        ModItems.RAW_AVALONIAN.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, EXCALIBUR_SMELTABLES, RecipeCategory.MISC, ModItems.AVALONIAN_NUGGET.get(), 0.25f, 200, "excalibur");
        oreBlasting(pWriter, EXCALIBUR_SMELTABLES, RecipeCategory.MISC, ModItems.AVALONIAN_NUGGET.get(), 0.25f, 100, "excalibur");

        nineBlockStorageRecipes(pWriter,RecipeCategory.MISC,ModItems.AVALONIAN_NUGGET.get(), RecipeCategory.MISC,ModItems.AVALONIAN_INGOT.get(),
                "excalibur:avalonian_nugget", "excalibur","excalibur:avalonian_ingot", "excalibur");

        nineBlockStorageRecipes(pWriter,RecipeCategory.MISC,ModItems.RAW_AVALONIAN.get(), RecipeCategory.MISC,ModBlocks.RAW_AVALONIAN_BLOCK.get(),
                        "excalibur:raw_avalonian", "excalibur","excalibur:raww_avalonian_block", "excalibur");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.EXCALIBUR_SWORD_UNSOULED.get())
                .pattern("  A")
                .pattern(" A ")
                .pattern("S  ")
                .define('A', ModItems.AVALONIAN_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_excalibur", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.AVALONIAN_INGOT.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AVALONIAN_AXE.get())
                .pattern(" AA")
                .pattern(" SA")
                .pattern(" S ")
                .define('A', ModItems.AVALONIAN_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_excalibur", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.AVALONIAN_INGOT.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AVALONIAN_HOE.get())
                .pattern(" AA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.AVALONIAN_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_excalibur", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.AVALONIAN_INGOT.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AVALONIAN_PICKAXE.get())
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.AVALONIAN_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_excalibur", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.AVALONIAN_INGOT.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AVALONIAN_SHOVEL.get())
                .pattern(" A ")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.AVALONIAN_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_excalibur", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.AVALONIAN_INGOT.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AVALONIAN_HAMMER.get())
                .pattern("AAA")
                .pattern("ASA")
                .pattern(" S ")
                .define('A', ModItems.AVALONIAN_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_excalibur", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.AVALONIAN_INGOT.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AVALONIAN_PAXEL.get())
                .pattern("PAH")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.AVALONIAN_AXE.get())
                .define('P', ModItems.AVALONIAN_PICKAXE.get())
                .define('H', ModItems.AVALONIAN_HOE.get())
                .define('S', Items.STICK)
                .unlockedBy("has_excalibur", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.AVALONIAN_INGOT.get()).build()))
                .save(pWriter);

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(new ItemLike[] {ModItems.AVALONIAN_SMITHING.get()}),
                Ingredient.of(ModItems.EXCALIBUR_SWORD_UNSOULED.get()),
                Ingredient.of(ModItems.NIMUE_SOUL.get()),
                RecipeCategory.MISC,
                ModItems.EXCALIBUR_SWORD.get())
                .unlocks("has_excalibur",inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.AVALONIAN_SMITHING.get()).build()))
                .save(pWriter, getItemName(ModItems.EXCALIBUR_SWORD.get()));

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
