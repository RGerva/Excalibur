package net.banze.excalibur.creative;

import net.banze.excalibur.ExcaliburMod;
import net.banze.excalibur.block.ModBlocks;
import net.banze.excalibur.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExcaliburMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EXCALIBUR_TAB = CREATIVE_MODE_TABS.register("excalibur_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.EXCALIBUR_SWORD.get()))
                    .title(Component.translatable("creativetab.excalibur_tab"))
                    .displayItems((displayParameters, output) -> {

                        output.accept(ModItems.AVALONIAN_INGOT.get());
                        output.accept(ModItems.AVALONIAN_NUGGET.get());
                        output.accept(ModItems.RAW_AVALONIAN.get());

                        output.accept(ModBlocks.AVALONIAN_BLOCK.get());
                        output.accept(ModBlocks.AVALONIAN_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_AVALONIAN_ORE.get());
                        output.accept(ModBlocks.RAW_AVALONIAN_BLOCK.get());

                        output.accept(ModItems.NIMUE_HEART.get());
                        output.accept(ModItems.NIMUE_SOUL.get());

                        output.accept(ModItems.AVALONIAN_SMITHING.get());

                        output.accept(ModItems.AVALONIAN_AXE.get());
                        output.accept(ModItems.AVALONIAN_HOE.get());
                        output.accept(ModItems.AVALONIAN_PICKAXE.get());
                        output.accept(ModItems.AVALONIAN_SHOVEL.get());

                        output.accept(ModItems.AVALONIAN_HAMMER.get());
                        output.accept(ModItems.AVALONIAN_PAXEL.get());

                        output.accept(ModBlocks.AVALONIAN_FURNACE.get());

                        output.accept(ModItems.EXCALIBUR_SWORD_UNSOULED.get());
                        output.accept(ModItems.EXCALIBUR_SWORD.get());

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
