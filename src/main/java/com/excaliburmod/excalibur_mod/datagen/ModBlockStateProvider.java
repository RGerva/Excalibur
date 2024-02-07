package com.excaliburmod.excalibur_mod.datagen;

import com.excaliburmod.excalibur_mod.Excalibur_Mod;
import com.excaliburmod.excalibur_mod.block.ExcaliburBlocks;
import com.excaliburmod.excalibur_mod.block.custom.crops.StrawberryCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Excalibur_Mod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ExcaliburBlocks.SAPPHIRE_BLOCK);
        blockWithItem(ExcaliburBlocks.ZIRCON_BLOCK);
        blockWithItem(ExcaliburBlocks.RAW_SAPPHIRE_BLOCK);

        blockWithItem(ExcaliburBlocks.SAPPHIRE_ORE);
        blockWithItem(ExcaliburBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockWithItem(ExcaliburBlocks.NETHER_SAPPHIRE_ORE);
        blockWithItem(ExcaliburBlocks.END_SAPPHIRE_ORE);

        blockWithItem(ExcaliburBlocks.ZIRCON_ORE);
        blockWithItem(ExcaliburBlocks.DEEPSLATE_ZIRCON_ORE);
        blockWithItem(ExcaliburBlocks.NETHER_ZIRCON_ORE);
        blockWithItem(ExcaliburBlocks.END_ZIRCON_ORE);

        makeStrawberryCrop((CropBlock) ExcaliburBlocks.STRAWBERRY_CROP.get(), "strawberry_stage", "strawberry_stage");
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    public void makeStrawberryCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> strawberryStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] strawberryStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()),
                new ResourceLocation(Excalibur_Mod.MOD_ID, "block/" + textureName + state.getValue(((StrawberryCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
}
