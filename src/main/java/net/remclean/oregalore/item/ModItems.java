package net.remclean.oregalore.item;


import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.remclean.oregalore.OreGalore;


public class ModItems {
    public static final Item ALUMINUM_INGOT = registerItem("aluminum_ingot",
            new Item(new Item.Settings()));
    public static final Item RAW_ALUMINUM = registerItem("raw_aluminum",
            new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(OreGalore.MOD_ID, name), item);
    }


    public static void registerModItems() {
        OreGalore.LOGGER.info("Registering Mod Items for " + OreGalore.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ALUMINUM_INGOT);
            entries.add(RAW_ALUMINUM);
        });
    }
}