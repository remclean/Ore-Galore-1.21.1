package net.remclean.oregalore.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.remclean.oregalore.block.ModBlocks;
import net.remclean.oregalore.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        addDrop(ModBlocks.ALUMINUM_BLOCK);

        addDrop(ModBlocks.CLUSTER_DIAMOND_ORE, multipleOreDrops(ModBlocks.CLUSTER_DIAMOND_ORE, Items.DIAMOND, 3, 5));
        addDrop(ModBlocks.DEEPSLATE_CLUSTER_DIAMOND_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_CLUSTER_DIAMOND_ORE, Items.DIAMOND, 3, 5));
        addDrop(ModBlocks.ALUMINUM_ORE, oreDrops(ModBlocks.ALUMINUM_ORE, ModItems.RAW_ALUMINUM));
        addDrop(ModBlocks.DEEPSLATE_ALUMINUM_ORE, oreDrops(ModBlocks.DEEPSLATE_ALUMINUM_ORE, ModItems.RAW_ALUMINUM));

    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
