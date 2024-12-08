package net.remclean.oregalore.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.remclean.oregalore.block.ModBlocks;
import net.remclean.oregalore.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        List<ItemConvertible> ALUMINUM_SMELTABLES = List.of(ModItems.RAW_ALUMINUM, ModBlocks.ALUMINUM_ORE, ModBlocks.DEEPSLATE_ALUMINUM_ORE);

        offerSmelting(exporter, ALUMINUM_SMELTABLES, RecipeCategory.MISC, ModItems.ALUMINUM_INGOT, 0.50f, 200, "aluminum_ingot");
        offerBlasting(exporter, ALUMINUM_SMELTABLES, RecipeCategory.MISC, ModItems.ALUMINUM_INGOT, 0.50f, 100, "aluminum_ingot");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ALUMINUM_INGOT, RecipeCategory.MISC, ModBlocks.ALUMINUM_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ORE_DETECTOR)
                .pattern(" AA")
                .pattern(" D ")
                .pattern("ARA")
                .input('A', ModItems.ALUMINUM_INGOT)
                .input('D', Items.DIAMOND)
                .input('R', Items.REDSTONE_BLOCK)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);

    }
}
