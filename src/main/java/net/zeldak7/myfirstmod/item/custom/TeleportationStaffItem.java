package net.zeldak7.myfirstmod.item.custom;

import net.minecraft.block.AirBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.concurrent.ThreadLocalRandom;

public class TeleportationStaffItem extends Item {
    public TeleportationStaffItem(Settings settings) {
        super(settings);
    }

    BlockPos pos;
    int x;
    int y;
    int z;

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient()){
            World world= context.getWorld();
            PlayerEntity player= context.getPlayer();
            System.out.println("Block name: "+world.getBlockState(context.getBlockPos()).getBlock().getName());
            System.out.println("Teleporting!");
            player.requestTeleport(x,y,z);
            context.getStack().damage(1,player,playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand())); //responsible for durability
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        entity.requestTeleport(x,y,z);
        return ActionResult.SUCCESS;
    }

    @Override
    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        System.out.println("Setting new Point!");
        System.out.println("Block name: "+world.getBlockState(miner.getBlockPos()).getBlock());
        pos=new BlockPos(miner.getBlockPos());
        x=pos.getX();
        y=pos.getY();
        z=pos.getZ();
        return super.canMine(state, world, pos, miner);
    }
}
