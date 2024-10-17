package net.banze.excalibur.item;

import net.banze.excalibur.ExcaliburMod;
import net.banze.excalibur.item.custom.ExcaliburSmithingItem;
import net.banze.excalibur.item.custom.ExcaliburSwordItem;
import net.banze.excalibur.item.custom.HammerItem;
import net.banze.excalibur.item.custom.PaxelItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExcaliburMod.MOD_ID);

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> AVALONIAN_INGOT = ITEMS.register("avalonian_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> AVALONIAN_NUGGET = ITEMS.register("avalonian_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_AVALONIAN = ITEMS.register("raw_avalonian",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> NIMUE_HEART = ITEMS.register("nimue_heart",
            () -> new Item(new Item.Properties().food(ModFoodProperties.NIMUE_HEART)));

    public static final RegistryObject<Item> NIMUE_SOUL = ITEMS.register("nimue_soul",
            () -> new Item(new Item.Properties().food(ModFoodProperties.NIMUE_SOUL)));

    public static final RegistryObject<Item> AVALONIAN_SMITHING = ITEMS.register("avalonian_upgrade_smithing_template",
            ExcaliburSmithingItem::createAvalonianUpgradeTemplate);

    public static final RegistryObject<Item> AVALONIAN_AXE = ITEMS.register("avalonian_axe",
            () -> new AxeItem(ModToolTiers.AVALONIAN_TIER, 6, 1,
                    new Item.Properties().fireResistant().rarity(Rarity.RARE)));

    public static final RegistryObject<Item> AVALONIAN_HOE = ITEMS.register("avalonian_hoe",
            () -> new HoeItem(ModToolTiers.AVALONIAN_TIER, 0, 0,
                    new Item.Properties().fireResistant().rarity(Rarity.RARE)));

    public static final RegistryObject<Item> AVALONIAN_PICKAXE = ITEMS.register("avalonian_pickaxe",
            () -> new PickaxeItem(ModToolTiers.AVALONIAN_TIER, 3, 0.25F,
                    new Item.Properties().fireResistant().rarity(Rarity.RARE)));

    public static final RegistryObject<Item> AVALONIAN_SHOVEL = ITEMS.register("avalonian_shovel",
            () -> new ShovelItem(ModToolTiers.AVALONIAN_TIER, 2, 0,
                    new Item.Properties().fireResistant().rarity(Rarity.RARE)));

    public static final RegistryObject<Item> AVALONIAN_HAMMER = ITEMS.register("avalonian_hammer",
            () -> new HammerItem(ModToolTiers.AVALONIAN_TIER, 7, 0.25F,
                    new Item.Properties().fireResistant().rarity(Rarity.RARE).durability(256)));

    public static final RegistryObject<Item> AVALONIAN_PAXEL = ITEMS.register("avalonian_paxel",
            () -> new PaxelItem(ModToolTiers.AVALONIAN_TIER, 4, 1,
                    new Item.Properties().fireResistant().rarity(Rarity.RARE)));

    //SWORD

    public static final RegistryObject<Item> EXCALIBUR_SWORD = ITEMS.register("excalibur_sword",
            () -> new ExcaliburSwordItem(ModToolTiers.EXCALIBUR_TIER, 4, 1.5F,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> EXCALIBUR_SWORD_UNSOULED = ITEMS.register("excalibur_sword_unsouled",
            () -> new SwordItem(ModToolTiers.EXCALIBUR_UNSOULED_TIER, 0, 1,
                    new Item.Properties().fireResistant().durability(4).rarity(Rarity.RARE)));
}
