package net.zeldak7.myfirstmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.zeldak7.myfirstmod.MyFirstMod;

public class ModItemGroups {

    public static final ItemGroup STAFF_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MyFirstMod.MOD_ID, "firestaff"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.firestaff"))
                    .icon(() -> new ItemStack(ModItems.FIRESTAFF)).entries((displayContext, entries) -> {
                        entries.add(ModItems.FIRESTAFF);
                        entries.add(ModItems.TELEPORTATIONSTAFF);

                    }).build());

    public static void registerItemGroups(){
        MyFirstMod.LOGGER.info("Registering Item Groups for "+ MyFirstMod.MOD_ID);

    }
}
