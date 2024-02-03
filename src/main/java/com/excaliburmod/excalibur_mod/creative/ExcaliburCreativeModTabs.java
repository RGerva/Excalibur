package com.excaliburmod.excalibur_mod.creative;

import com.excaliburmod.excalibur_mod.Excalibur_Mod;
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
                    .icon(() -> new ItemStack(ExcaliburItems.SAPPHIRE_SWORD.get()))
                    .title(Component.translatable("creativetab.excalibur_tab"))
                    .displayItems((pParameters,pOutput) -> {
                        pOutput.accept(ExcaliburItems.SAPPHIRE.get());


                        pOutput.accept(ExcaliburItems.SAPPHIRE_SWORD.get());
                        pOutput.accept(ExcaliburItems.SAPPHIRE_PICKAXE.get());
                        pOutput.accept(ExcaliburItems.SAPPHIRE_AXE.get());
                        pOutput.accept(ExcaliburItems.SAPPHIRE_PICKAXE.get());
                        pOutput.accept(ExcaliburItems.SAPPHIRE_SHOVEL.get());

                        pOutput.accept(ExcaliburItems.SAPPHIRE_SMITHING.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
