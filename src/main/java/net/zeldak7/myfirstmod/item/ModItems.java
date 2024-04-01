package net.zeldak7.myfirstmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.zeldak7.myfirstmod.MyFirstMod;
import net.zeldak7.myfirstmod.item.custom.FireStaffItem;
import net.zeldak7.myfirstmod.item.custom.TeleportationStaffItem;


public class ModItems {
    public static final Item FIRESTAFF = registerItem("firestaff", new FireStaffItem(new FabricItemSettings().maxDamage(64)));
    public static final Item TELEPORTATIONSTAFF = registerItem("teleportationstaff", new TeleportationStaffItem(new FabricItemSettings().maxDamage(64)));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(FIRESTAFF);
    }


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(MyFirstMod.MOD_ID, name), item);
    }

    public static void registerModItems(){
        MyFirstMod.LOGGER.info("Registering Mod Items for "+ MyFirstMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }

}
