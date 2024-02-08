package com.excaliburmod.excalibur_mod.item;

import com.excaliburmod.excalibur_mod.Excalibur_Mod;
import com.excaliburmod.excalibur_mod.block.ExcaliburBlocks;
import com.excaliburmod.excalibur_mod.item.armor.ExcaliburArmorItem;
import com.excaliburmod.excalibur_mod.item.armor.ExcaliburArmorMaterials;
import com.excaliburmod.excalibur_mod.item.detector.MetalDetectorItem;
import com.excaliburmod.excalibur_mod.item.foods.ExcaliburFoods;
import com.excaliburmod.excalibur_mod.item.templates.ExcaliburSmithingItem;
import com.excaliburmod.excalibur_mod.item.tools.ExcaliburToolTiers;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.server.command.TextComponentHelper;

import java.util.List;

public class ExcaliburItems {
    //REGISTER
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Excalibur_Mod.MOD_ID);
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

    //ITEMS
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_RUBY = ITEMS.register("raw_ruby",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_ZIRCON = ITEMS.register("raw_zircon",
            () -> new Item(new Item.Properties()));

    //DETECTOR

    public static final RegistryObject<Item> IRON_METAL_DETECTOR = ITEMS.register("iron_metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(50)));
    public static final RegistryObject<Item> DIAMOND_METAL_DETECTOR = ITEMS.register("diamond_metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));
    public static final RegistryObject<Item> NETEHRITE_METAL_DETECTOR = ITEMS.register("netherite_metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(150)));
    public static final RegistryObject<Item> SAPPHIRE_METAL_DETECTOR = ITEMS.register("sapphire_metal_detector",
            () -> new MetalDetectorItem(new Item.Properties()));

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

    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(ExcaliburToolTiers.RUBY, 8,1, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ExcaliburToolTiers.RUBY, 4,0.9f, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ExcaliburToolTiers.RUBY, 7,0.8f, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ExcaliburToolTiers.RUBY, 1,0, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(ExcaliburToolTiers.RUBY, 0,0, new Item.Properties()));

    //TEMPLATE
    public static final RegistryObject<Item> SAPPHIRE_SMITHING = ITEMS.register("sapphire_upgrade_smithing_template", () -> ExcaliburSmithingItem.createSapphireUpgradeTemplate());

    //ARMOR
    public static final RegistryObject<Item> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet",
            () -> new ArmorItem(ExcaliburArmorMaterials.SAPPHIRE, ArmorItem.Type.HELMET,new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate",
            () -> new ExcaliburArmorItem(ExcaliburArmorMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE,new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings",
            () -> new ArmorItem(ExcaliburArmorMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS,new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots",
            () -> new ArmorItem(ExcaliburArmorMaterials.SAPPHIRE, ArmorItem.Type.BOOTS,new Item.Properties()));

    //FOODS
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(ExcaliburFoods.STRAWBERRY)));
    public static final RegistryObject<Item> STRAWBERRY_SEEDS = ITEMS.register("strawberry_seeds",
            () -> new ItemNameBlockItem(ExcaliburBlocks.STRAWBERRY_CROP.get(), new Item.Properties()));


    public static final RegistryObject<SwordItem> EXCALIBUR_SWORD = ITEMS.register("excalibur_sword",
            () -> new SwordItem(ExcaliburToolTiers.EXCALIBUR_TIER,20,8f,
                    new Item.Properties().fireResistant().rarity(Rarity.EPIC)) {
        @Override
        public boolean isEnchantable(ItemStack stack) {
            return true;
        }
        @Override
        public boolean canBeDepleted() {
            return false;
        }
        @Override
        public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn){
            tooltip.add(TextComponentHelper.createComponentTranslation(null,"indestructible" , new Object()).withStyle(ChatFormatting.BLUE));

            super.appendHoverText(stack, worldIn, tooltip, flagIn);
        }

    });
}
