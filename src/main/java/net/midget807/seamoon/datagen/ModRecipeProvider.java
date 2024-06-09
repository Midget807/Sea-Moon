package net.midget807.seamoon.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.midget807.seamoon.block.ModBlocks;
import net.midget807.seamoon.item.ModItems;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SEAMOON_BUCKET, 1)
                .pattern("SSS")
                .pattern("SSS")
                .pattern(" B ")
                .input('S', ModItems.SEAMOON_BOTTLE)
                .input('B', Items.BUCKET)
                .criterion(hasItem(ModItems.SEAMOON_BOTTLE), conditionsFromItem(ModItems.SEAMOON_BOTTLE))
                .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
                .criterion(hasItem(Items.BUCKET), conditionsFromItem(Items.BUCKET))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SEAMOON_BUCKET)));

        createStairsRecipe(ModBlocks.SEAMOON_STAIR, Ingredient.ofItems(ModBlocks.SEAMOON_BLOCK));

        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEAMOON_SLAB, ModBlocks.SEAMOON_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEAMOON_POST, 8)
                .pattern("S")
                .pattern("S")
                .input('S', ModBlocks.SEAMOON_BLOCK)
                .criterion(hasItem(ModBlocks.SEAMOON_BLOCK), conditionsFromItem(ModBlocks.SEAMOON_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEAMOON_POST)));

        createFenceRecipe(ModBlocks.SEAMOON_FENCE, Ingredient.ofItems(ModBlocks.SEAMOON_BLOCK));

        createFenceGateRecipe(ModBlocks.SEAMOON_FENCE_GATE, Ingredient.ofItems(ModBlocks.SEAMOON_BLOCK));

        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEAMOON_WALL, ModBlocks.SEAMOON_BLOCK);

        createDoorRecipe(ModBlocks.SEAMOON_FENCE, Ingredient.ofItems(ModBlocks.SEAMOON_BLOCK));

        createTrapdoorRecipe(ModBlocks.SEAMOON_FENCE, Ingredient.ofItems(ModBlocks.SEAMOON_BLOCK));

        offerPressurePlateRecipe(exporter, ModBlocks.SEAMOON_PRESSURE_PLATE, ModBlocks.SEAMOON_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEAMOON_BUTTON)
                .input(ModBlocks.SEAMOON_BUTTON)
                .criterion(hasItem(ModBlocks.SEAMOON_BLOCK), conditionsFromItem(ModBlocks.SEAMOON_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEAMOON_BUTTON)));


    }
}
