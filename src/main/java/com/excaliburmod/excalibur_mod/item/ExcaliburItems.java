package com.excaliburmod.excalibur_mod.item;

import com.excaliburmod.excalibur_mod.Excalibur_Mod;
import com.excaliburmod.excalibur_mod.item.armor.ExcaliburArmorMaterials;
import com.excaliburmod.excalibur_mod.item.templates.ExcaliburSmithingItem;
import com.excaliburmod.excalibur_mod.item.tools.ExcaliburToolTiers;
import net.minecraft.world.item.*;
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

    //SAPPHIRE ITEMS
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
            () -> new Item(new Item.Properties()));

    //TOOLS
    public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword",
            () -> new SwordItem(ExcaliburToolTiers.SAPPHIRE, 8,1, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe",
            () -> new PickaxeItem(ExcaliburToolTiers.SAPPHIRE, 4,0.9f, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe",
            () -> new AxeItem(ExcaliburToolTiers.SAPPHIRE, 7,0.8f, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel",
            () -> new ShovelItem(ExcaliburToolTiers.SAPPHIRE, 1,0, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe",
            () -> new HoeItem(ExcaliburToolTiers.SAPPHIRE, 0,0, new Item.Properties()));

    //TEMPLATE
    public static final RegistryObject<Item> SAPPHIRE_SMITHING = ITEMS.register("sapphire_upgrade_smithing_template", () -> ExcaliburSmithingItem.createSapphireUpgradeTemplate());

    //ARMOR
    public static final RegistryObject<Item> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet",
            () -> new ArmorItem(ExcaliburArmorMaterials.SAPPHIRE_HELMET, ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate",
            () -> new ArmorItem(ExcaliburArmorMaterials.SAPPHIRE_CHESTPLATE, ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings",
            () -> new ArmorItem(ExcaliburArmorMaterials.SAPPHIRE_LEGGING, ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots",
            () -> new ArmorItem(ExcaliburArmorMaterials.SAPPHIRE_BOOT, ArmorItem.Type.BOOTS,new Item.Properties()));
}
