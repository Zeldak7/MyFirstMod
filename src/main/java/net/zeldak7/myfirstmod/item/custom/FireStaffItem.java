package net.zeldak7.myfirstmod.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


import java.util.concurrent.ThreadLocalRandom;

public class FireStaffItem extends Item {
    public FireStaffItem(Settings settings) {
        super(settings);

    }

    LivingEntity myEntity=null;
    Entity target=null;

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        myEntity=null;
        if (!context.getWorld().isClient()){
            World world= context.getWorld();
            PlayerEntity player= context.getPlayer();


            int x=ThreadLocalRandom.current().nextInt(-100000, 100000 + 1);
            int y=ThreadLocalRandom.current().nextInt(-100000, 100000 + 1);
            int z=20;
            System.out.println("Teleportet to x: "+x+ " y: "+y+ "z: "+z);
            //player.teleport(x,z,y,true);
            BlockPos pos=new BlockPos(x,z,y);
            while (world.getBlockState(pos).getBlock()!=Blocks.AIR){
                z=z+5;
                pos=new BlockPos(x,z,y);
            }
            world.createExplosion(player,x,z,y,10, World.ExplosionSourceType.BLOCK);
            world.getWorldChunk(pos);
            player.requestTeleport(x,z,y);
            context.getStack().damage(1,player,playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand())); //responsible for durability

        }

        return ActionResult.SUCCESS;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {

        System.out.println("Clicked on " + entity.getName() );
        World world=user.getWorld();
        int x=ThreadLocalRandom.current().nextInt(-100000, 100000 + 1);
        int y=ThreadLocalRandom.current().nextInt(-100000, 100000 + 1);
        int z=20;


        BlockPos pos=new BlockPos(x,z,y);

        entity.requestTeleport(x,z,y);
        entity.setCustomName(Text.of("Teleported"));
        entity.setCustomNameVisible(true);
        System.out.println("Teleportet to x: "+x+ " y: "+y+ " z: "+z);


        return ActionResult.SUCCESS;
    }
}
