package net.isntz.ugelium.item.custom;

import net.isntz.ugelium.block.ModBlocks;
import net.isntz.ugelium.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UgeliumDetectorItem extends Item {
    public UgeliumDetectorItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(!context.getWorld().isClient()){
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;
            for(int i = 0; i <= positionClicked.getY() + 64; i++){
                BlockState state = context.getWorld().getBlockState(positionClicked.down(i));

                if(isValuableBlock(state)){
                    outputValuableCoordinates(positionClicked.down(i).getY(), player, state.getBlock(), positionClicked.getY());
                    foundBlock = true;

                    break;
                }
            }

            if(!foundBlock){
                player.sendMessage(Text.literal("No Ugelium ore Found!"));
            }
        }

        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    private void outputValuableCoordinates(int blockPos, PlayerEntity player, Block block, int clickBlock) {
        int blockDown = clickBlock - blockPos;
        player.sendMessage(Text.literal("Found " + block.asItem().getName().getString() + ", " + blockDown + " Blocks Down"), false);
    }

    private boolean isValuableBlock(BlockState state) {
        return  state.isIn(ModTags.Blocks.UGELIUM_DETECTOR_DETECTABLE_BLOCKS);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.ugelium.ugelium_detector"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
