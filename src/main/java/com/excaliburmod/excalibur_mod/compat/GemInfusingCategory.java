package com.excaliburmod.excalibur_mod.compat;

import com.excaliburmod.excalibur_mod.Excalibur_Mod;
import com.excaliburmod.excalibur_mod.block.ExcaliburBlocks;
import com.excaliburmod.excalibur_mod.recepie.GemInfusingRecepie;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class GemInfusingCategory implements IRecipeCategory<GemInfusingRecepie> {
    public static final ResourceLocation UID = new ResourceLocation(Excalibur_Mod.MOD_ID, "gem_infusing");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Excalibur_Mod.MOD_ID,
            "textures/gui/gem_infusing_station_gui.png");
    public static final RecipeType<GemInfusingRecepie> GEM_INFUSING_TYPE =
            new RecipeType<>(UID, GemInfusingRecepie.class);

    private final IDrawable background;
    private final IDrawable icon;

    public GemInfusingCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 80);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ExcaliburBlocks.GEM_INFUSING_STATION.get()));
    }

    @Override
    public RecipeType<GemInfusingRecepie> getRecipeType() {
        return GEM_INFUSING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.excalibur_mod.gem_infusing_station");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, GemInfusingRecepie recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 86, 15).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 86, 60).addItemStack(recipe.getResultItem(null));

    }
}
