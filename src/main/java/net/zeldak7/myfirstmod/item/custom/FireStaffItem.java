package net.zeldak7.myfirstmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.item.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class FireStaffItem extends Item {
    public FireStaffItem(Settings settings) {
        super(settings);

    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient()){
            BlockPos positionClicked= context.getBlockPos();
            World world= context.getWorld();
            PlayerEntity player= context.getPlayer();
            world.setBlockState(positionClicked, Blocks.LAVA.getDefaultState());

            context.getStack().damage(1,player,playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand())); //responsible for durability
        }
        return ActionResult.SUCCESS;
    }

}
