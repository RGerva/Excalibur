package net.banze.excalibur.datagen;

import net.banze.excalibur.ExcaliburMod;
import net.banze.excalibur.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ExcaliburMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.AVALONIAN_BLOCK);
        blockWithItem(ModBlocks.AVALONIAN_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_AVALONIAN_ORE);
        blockWithItem(ModBlocks.RAW_AVALONIAN_BLOCK);
        //blockWithItem(ModBlocks.AVALONIAN_FURNACE);
    }

//    public void makeCrop(CropBlock block, String modelName, String textureName) {
//        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);
//
//        getVariantBuilder(block).forAllStates(function);
//    }

//    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
//        ConfiguredModel[] models = new ConfiguredModel[1];
//        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((KohlrabiCropBlock) block).getAgeProperty()),
//                new ResourceLocation(ExcaliburMod.MOD_ID, "block/" + textureName + state.getValue(((KohlrabiCropBlock) block).getAgeProperty()))).renderType("cutout"));
//
//        return models;
//    }

//    private void customLamp() {
//        getVariantBuilder(ModBlocks.ALEXANDRITE_LAMP.get()).forAllStates(state -> {
//            if(state.getValue(AlexandriteLampBlock.CLICKED)) {
//                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("alexandrite_lamp_on",
//                        new ResourceLocation(ExcaliburMod.MOD_ID, "block/" + "alexandrite_lamp_on")))};
//            } else {
//                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("alexandrite_lamp_off",
//                        new ResourceLocation(ExcaliburMod.MOD_ID, "block/" +"alexandrite_lamp_off")))};
//            }
//        });
//        simpleBlockItem(ModBlocks.ALEXANDRITE_LAMP.get(), models().cubeAll("alexandrite_lamp_on",
//                new ResourceLocation(ExcaliburMod.MOD_ID, "block/" +"alexandrite_lamp_on")));
//    }

    private void blockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("excalibur:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("excalibur:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

}
