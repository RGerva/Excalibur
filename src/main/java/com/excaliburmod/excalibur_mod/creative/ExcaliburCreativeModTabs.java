package com.excaliburmod.excalibur_mod.creative;

import com.excaliburmod.excalibur_mod.Excalibur_Mod;
import com.excaliburmod.excalibur_mod.block.ExcaliburBlocks;
import com.excaliburmod.excalibur_mod.item.ExcaliburItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ExcaliburCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Excalibur_Mod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EXCALIBUR_TAB = CREATIVE_MODE_TABS.register("excalibur_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ExcaliburItems.EXCALIBUR_SWORD.get()))
                    .title(Component.translatable("creativetab.excalibur_tab"))
                    .displayItems((pParameters,pOutput) -> {
                        pOutput.accept(ExcaliburItems.SAPPHIRE.get());
                        pOutput.accept(ExcaliburItems.RUBY.get());
                        pOutput.accept(ExcaliburItems.ZIRCON.get());
                        pOutput.accept(ExcaliburItems.MYTHRIL.get());

                        pOutput.accept(ExcaliburItems.RAW_SAPPHIRE.get());
                        pOutput.accept(ExcaliburItems.RAW_RUBY.get());
                        pOutput.accept(ExcaliburItems.RAW_ZIRCON.get());
                        pOutput.accept(ExcaliburItems.RAW_MYTHRIL.get());

                        pOutput.accept(ExcaliburItems.MYTHRIL_NUGGUET.get());

                        pOutput.accept(ExcaliburItems.IRON_METAL_DETECTOR.get());
                        pOutput.accept(ExcaliburItems.DIAMOND_METAL_DETECTOR.get());
                        pOutput.accept(ExcaliburItems.NETEHRITE_METAL_DETECTOR.get());
                        pOutput.accept(ExcaliburItems.SAPPHIRE_METAL_DETECTOR.get());

                        pOutput.accept(ExcaliburBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(ExcaliburBlocks.ZIRCON_BLOCK.get());
                        pOutput.accept(ExcaliburBlocks.MYTHRIL_BLOCK.get());
                        pOutput.accept(ExcaliburBlocks.RAW_SAPPHIRE_BLOCK.get());
                        pOutput.accept(ExcaliburBlocks.RAW_MYTHRIL_BLOCK.get());

                        pOutput.accept(ExcaliburBlocks.SAPPHIRE_ORE.get());
                        pOutput.accept(ExcaliburBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                        pOutput.accept(ExcaliburBlocks.NETHER_SAPPHIRE_ORE.get());
                        pOutput.accept(ExcaliburBlocks.END_SAPPHIRE_ORE.get());

                        pOutput.accept(ExcaliburBlocks.ZIRCON_ORE.get());
                        pOutput.accept(ExcaliburBlocks.DEEPSLATE_ZIRCON_ORE.get());
                        pOutput.accept(ExcaliburBlocks.NETHER_ZIRCON_ORE.get());
                        pOutput.accept(ExcaliburBlocks.END_ZIRCON_ORE.get());

                        pOutput.accept(ExcaliburBlocks.MYTHRIL_ORE.get());
                        pOutput.accept(ExcaliburBlocks.DEEPSLATE_MYTHRIL_ORE.get());

                        pOutput.accept(ExcaliburItems.STRAWBERRY.get());
                        pOutput.accept(ExcaliburItems.STRAWBERRY_SEEDS.get());

                        pOutput.accept(ExcaliburItems.SAPPHIRE_SWORD.get());
                        pOutput.accept(ExcaliburItems.SAPPHIRE_PICKAXE.get());
                        pOutput.accept(ExcaliburItems.SAPPHIRE_AXE.get());
                        pOutput.accept(ExcaliburItems.SAPPHIRE_PICKAXE.get());
                        pOutput.accept(ExcaliburItems.SAPPHIRE_SHOVEL.get());
                        pOutput.accept(ExcaliburItems.SAPPHIRE_HOE.get());

                        pOutput.accept(ExcaliburItems.RUBY_SWORD.get());
                        pOutput.accept(ExcaliburItems.RUBY_PICKAXE.get());
                        pOutput.accept(ExcaliburItems.RUBY_AXE.get());
                        pOutput.accept(ExcaliburItems.RUBY_PICKAXE.get());
                        pOutput.accept(ExcaliburItems.RUBY_SHOVEL.get());
                        pOutput.accept(ExcaliburItems.RUBY_HOE.get());

                        pOutput.accept(ExcaliburItems.SAPPHIRE_HELMET.get());
                        pOutput.accept(ExcaliburItems.SAPPHIRE_CHESTPLATE.get());
                        pOutput.accept(ExcaliburItems.SAPPHIRE_LEGGINGS.get());
                        pOutput.accept(ExcaliburItems.SAPPHIRE_BOOTS.get());

                        pOutput.accept(ExcaliburItems.RUBY_HELMET.get());
                        pOutput.accept(ExcaliburItems.RUBY_CHESTPLATE.get());
                        pOutput.accept(ExcaliburItems.RUBY_LEGGINGS.get());
                        pOutput.accept(ExcaliburItems.RUBY_BOOTS.get());

                        pOutput.accept(ExcaliburItems.MYTHRIL_HELMET.get());
                        pOutput.accept(ExcaliburItems.MYTHRIL_CHESTPLATE.get());
                        pOutput.accept(ExcaliburItems.MYTHRIL_LEGGINGS.get());
                        pOutput.accept(ExcaliburItems.MYTHRIL_BOOTS.get());

                        pOutput.accept(ExcaliburItems.SAPPHIRE_SMITHING.get());

                        pOutput.accept(ExcaliburItems.EXCALIBUR_SWORD.get());

                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
