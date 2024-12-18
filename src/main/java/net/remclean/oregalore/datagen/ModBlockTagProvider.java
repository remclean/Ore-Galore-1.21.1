package net.remclean.oregalore.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.remclean.oregalore.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.CLUSTER_DIAMOND_ORE)
                .add(ModBlocks.DEEPSLATE_CLUSTER_DIAMOND_ORE)
                .add(ModBlocks.ALUMINUM_BLOCK)
                .add(ModBlocks.ALUMINUM_ORE)
                .add(ModBlocks.DEEPSLATE_ALUMINUM_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CLUSTER_DIAMOND_ORE)
                .add(ModBlocks.DEEPSLATE_CLUSTER_DIAMOND_ORE)
                .add(ModBlocks.ALUMINUM_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.ALUMINUM_ORE)
                .add(ModBlocks.DEEPSLATE_ALUMINUM_ORE);
        }
    }
