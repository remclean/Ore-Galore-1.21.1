package net.remclean.oregalore.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.remclean.oregalore.block.ModBlocks;
import net.remclean.oregalore.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CLUSTER_DIAMOND_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_CLUSTER_DIAMOND_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALUMINUM_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ALUMINUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ALUMINUM, Models.GENERATED);
    }
}
