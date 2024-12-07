package net.remclean.oregalore.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.remclean.oregalore.OreGalore;
import net.remclean.oregalore.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup ORE_GALORE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(OreGalore.MOD_ID, "ore_galore_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.CLUSTER_DIAMOND_ORE)).displayName(Text.translatable("itemgroup.oregalore.ore_galore_group"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.RAW_ALUMINUM);
                        entries.add(ModItems.ALUMINUM_INGOT);
                        entries.add(ModBlocks.ALUMINUM_BLOCK);
                        entries.add(ModBlocks.CLUSTER_DIAMOND_ORE);
                        entries.add(ModBlocks.DEEPSLATE_CLUSTER_DIAMOND_ORE);

                    }).build());

    public static void registerItemGroups() {
        OreGalore.LOGGER.info("Registering Item Groups for " + OreGalore.MOD_ID);
    }
}
