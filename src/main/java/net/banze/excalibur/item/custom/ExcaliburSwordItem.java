package net.banze.excalibur.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.server.command.TextComponentHelper;

import java.util.List;

public class ExcaliburSwordItem extends SwordItem {

    public ExcaliburSwordItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean isEnchantable(ItemStack pStack) {
        return true;
    }
    @Override
    public boolean canBeDepleted() {
        return false;
    }
    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn){
        tooltip.add(TextComponentHelper.createComponentTranslation(null,"indestructible" ,
                new Object()).withStyle(ChatFormatting.GOLD));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}
