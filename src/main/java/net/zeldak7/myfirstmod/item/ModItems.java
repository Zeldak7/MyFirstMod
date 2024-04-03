package net.zeldak7.myfirstmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.zeldak7.myfirstmod.MyFirstMod;
import net.zeldak7.myfirstmod.entity.ModEntities;
import net.zeldak7.myfirstmod.item.custom.EmergencyStaffItem;
import net.zeldak7.myfirstmod.item.custom.TeleportationStaffItem;


public class ModItems {
    public static final Item EMERGENCYSTAFF = registerItem("emergencystaff", new EmergencyStaffItem(new FabricItemSettings().maxDamage(64)));
    public static final Item TELEPORTATIONSTAFF = registerItem("teleportationstaff", new TeleportationStaffItem(new FabricItemSettings().maxDamage(64)));

    public static final Item WIZARD_SPAWN_EGG = registerItem("wizard_spawn_egg", new SpawnEggItem(ModEntities.WIZARD, 0x0000,0x32421,new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(EMERGENCYSTAFF);
    }


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(MyFirstMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        MyFirstMod.LOGGER.info("Registering Mod Items for "+ MyFirstMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }

}
