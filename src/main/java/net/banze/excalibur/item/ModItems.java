package net.banze.excalibur.item;

import net.banze.excalibur.ExcaliburMod;
import net.banze.excalibur.item.custom.ExcaliburSwordItem;
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

    public static final RegistryObject<Item> NIMUE_HEART = ITEMS.register("nimue_heart",
            () -> new Item(new Item.Properties().food(ModFoodProperties.NIMUE_HEART)));

    public static final RegistryObject<Item> NIMUE_SOUL = ITEMS.register("nimue_soul",
            () -> new Item(new Item.Properties().food(ModFoodProperties.NIMUE_SOUL)));

    //SWORD

    public static final RegistryObject<Item> EXCALIBUR_SWORD = ITEMS.register("excalibur_sword",
            () -> new ExcaliburSwordItem(ModToolTiers.EXCALIBUR_TIER, 4, 1.5F,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> EXCALIBUR_SWORD_UNSOULED = ITEMS.register("excalibur_sword_unsouled",
            () -> new SwordItem(ModToolTiers.EXCALIBUR_UNSOULED_TIER, 0, 1,
                    new Item.Properties().fireResistant().durability(4)));
}
