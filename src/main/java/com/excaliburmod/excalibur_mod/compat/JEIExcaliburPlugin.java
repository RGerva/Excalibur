package com.excaliburmod.excalibur_mod.compat;

import com.excaliburmod.excalibur_mod.Excalibur_Mod;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIExcaliburPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Excalibur_Mod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        //registration.addRecipeCategories(new GemInfusingCategory(registration.getJeiHelpers().getGuiHelper()));
    }
    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        //List<GemInfusingRecepie> polishingRecipes = recipeManager.getAllRecipesFor(GemInfusingRecepie.Type.INSTANCE);
        //registration.addRecipes(GemInfusingCategory.GEM_INFUSING_TYPE, polishingRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
//        registration.addRecipeClickArea(GemInfusingStationScreen.class, 60, 30, 20, 30,
//                GemInfusingCategory.GEM_INFUSING_TYPE);
    }
}
