package net.zeldak7.myfirstmod.item.custom;

import net.minecraft.block.Blocks;
import net.minecraft.client.sound.SoundEngine;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkManager;


import java.util.concurrent.ThreadLocalRandom;

public class EmergencyStaffItem extends Item {
    public EmergencyStaffItem(Settings settings) {
        super(settings);
    }

    int x=0;
    int y=0;
    int z=0;

    BlockPos randomPos=null;

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient()){
            World world= context.getWorld();
            PlayerEntity player= context.getPlayer();
            randomPos=randomBlockPos(x,y,z);
            while (world.getBlockState(randomPos).getBlock()!=Blocks.AIR){                                                          //check if block is air //TODO nether and end dimension
                randomPos=new BlockPos(randomPos.getX(),randomPos.getY()+5,randomPos.getZ());                                     //if so gaining height
                System.out.println("x: "+randomPos.getX() + "y: "+ randomPos.getY()+"z: "+randomPos.getZ());
            }
            world.createExplosion(player,randomPos.getX(),randomPos.getY(),randomPos.getZ(),10, World.ExplosionSourceType.BLOCK);
            world.getWorldChunk(randomPos);
            player.requestTeleport(randomPos.getX(),randomPos.getY(),randomPos.getZ());
            world.playSound(null, randomPos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS,1f,1f);
            context.getStack().damage(1,player,playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand())); //responsible for durability
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        World world=user.getWorld();
        BlockPos pos=randomBlockPos(x,y,z);
        world.getBlockState(pos);
        while (world.getBlockState(pos).getBlock()!=Blocks.AIR && pos.getY()<250){                                                          //check if block is air //TODO nether and end dimension
            pos=new BlockPos(pos.getX(),pos.getY()+5,pos.getZ());                                     //if so gaining height
            System.out.println("x: "+pos.getX() + "y: "+ pos.getY()+"z: "+pos.getZ());
        }
        entity.requestTeleport(pos.getX(),pos.getY(),pos.getZ());
        entity.setCustomName(Text.of("Teleported"));
        entity.setCustomNameVisible(true);
        return ActionResult.SUCCESS;
    }

    private BlockPos randomBlockPos(int x, int y, int z){                             //find a random Blockpos with the height 20
         x=ThreadLocalRandom.current().nextInt(-100000, 100000 + 1);
         y=20;
         z=ThreadLocalRandom.current().nextInt(-100000, 100000 + 1);
         System.out.println("x: "+x + "y: "+ y+"z: "+z);
        return new BlockPos(x,y,z);
    }
}
