package com.excaliburmod.excalibur_mod.compat;

import com.excaliburmod.excalibur_mod.Excalibur_Mod;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

@JeiPlugin
public class JEIExcaliburPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Excalibur_Mod.MOD_ID, "jei_plugin");
    }


}
