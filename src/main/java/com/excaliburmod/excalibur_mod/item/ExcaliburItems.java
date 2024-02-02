package com.excaliburmod.excalibur_mod.item;

import com.excaliburmod.excalibur_mod.Excalibur_Mod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ExcaliburItems {
    //REGISTER
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Excalibur_Mod.MOD_ID);
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword",
            () -> new SwordItem(ExcaliburToolTiers.SAPPHIRE, 8,1, new Item.Properties()));
}
