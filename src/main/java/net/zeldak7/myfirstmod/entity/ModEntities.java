package net.zeldak7.myfirstmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.zeldak7.myfirstmod.MyFirstMod;
import net.zeldak7.myfirstmod.entity.custom.WizardEntity;

public class ModEntities {
    public static final EntityType<WizardEntity> WIZARD = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(MyFirstMod.MOD_ID, "wizard"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, WizardEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 1.75f)).build());
}
