package com.excaliburmod.excalibur_mod.item.detector;

import com.excaliburmod.excalibur_mod.item.ExcaliburItems;
import com.excaliburmod.excalibur_mod.util.ExcaliburTags;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(pContext.getLevel().isClientSide()){
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;
            int count = 0;

            int radius;
            int posY;

            if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ExcaliburItems.SAPPHIRE_METAL_DETECTOR.get())){
                radius = 5;
                posY = -128;
            }else if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ExcaliburItems.NETEHRITE_METAL_DETECTOR.get())){
                radius = 4;
                posY = -64;
            } else if (player.getItemInHand(InteractionHand.MAIN_HAND).is(ExcaliburItems.DIAMOND_METAL_DETECTOR.get())) {
                radius = 3;
                posY = -64;
            } else {
                radius = 2;
                posY = -64;
            }

            for (int x = -radius; x <= radius; x++) {

                for (int z = -radius; z <= radius; z++) {

                    BlockPos checkPos = positionClicked.offset(x, 0, z);

                    for(int i = posY; i <= positionClicked.getY() + 5; i++) {
                        BlockState state = pContext.getLevel().getBlockState(checkPos.atY(i));

                        if(isValuableBlock(state)){


                            //outputValuableCoordinatess(positionClicked.below(i), player, state.getBlock());
                            foundBlock = true;
                            count++;


                        }

                    }
                }
            }

            if(!foundBlock){
                player.sendSystemMessage(Component.literal("Not Found!"));
            }else{
                player.sendSystemMessage(Component.literal("Found: " + count + " Blocks"));
            }

//            pContext.getLevel().playSeededSound(null, positionClicked.getX(), positionClicked.getY(), positionClicked.getZ(),
//                    ExcaliburSounds.METAL_DETECTOR_FOUND_ORE.get(), SoundSource.BLOCKS, 3f, 2f, 3);
        }

        damageTool(pContext);

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if (pStack.is(ExcaliburItems.SAPPHIRE_METAL_DETECTOR.get())){
            pTooltipComponents.add(Component.translatable("tooltip.excalibur.sapphire_metal_detector_valuables.tooltip"));
        }else if (pStack.is(ExcaliburItems.NETEHRITE_METAL_DETECTOR.get())){
            pTooltipComponents.add(Component.translatable("tooltip.excalibur.netherite_metal_detector_valuables.tooltip"));
        }else if (pStack.is(ExcaliburItems.DIAMOND_METAL_DETECTOR.get())){
            pTooltipComponents.add(Component.translatable("tooltip.excalibur.diamond_metal_detector_valuables.tooltip"));
        }else if (pStack.is(ExcaliburItems.IRON_METAL_DETECTOR.get())) {
            pTooltipComponents.add(Component.translatable("tooltip.excalibur.iron_metal_detector_valuables.tooltip"));
        }else{
            pTooltipComponents.add(Component.translatable("tooltip.excalibur.metal_detector.tooltip"));
        }

        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private void damageTool(UseOnContext pContext) {
        pContext.getItemInHand().hurtAndBreak(1,pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));
    }


    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId() + " at "+
                "(" + blockPos.getX()+ ", " + blockPos.getY()+ ", " + blockPos.getZ() +")")));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(ExcaliburTags.Blocks.METAL_DETECTOR_VALUABELS);
    }
}
