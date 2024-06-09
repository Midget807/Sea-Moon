package net.midget807.seamoon.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.midget807.seamoon.block.ModBlocks;
import net.midget807.seamoon.item.ModItems;
import net.minecraft.block.Blocks;
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEAMOON_BLOCK, 1)
                .pattern("SSS")
                .pattern("SNS")
                .pattern("SSS")
                .input('S', ModItems.SEAMOON_BOTTLE)
                .input('N', Blocks.NETHERITE_BLOCK)
                .criterion(hasItem(ModItems.SEAMOON_BOTTLE), conditionsFromItem(ModItems.SEAMOON_BOTTLE))
                .criterion(hasItem(Items.GLASS_BOTTLE), conditionsFromItem(Items.GLASS_BOTTLE))
                .criterion(hasItem(Blocks.NETHERITE_BLOCK), conditionsFromItem(Blocks.NETHERITE_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEAMOON_BLOCK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEAMOON_STAIR, 4)
                .pattern("S  ")
                .pattern("SS ")
                .pattern("SSS")
                .input('S', ModBlocks.SEAMOON_BLOCK)
                .criterion(hasItem(ModBlocks.SEAMOON_BLOCK), conditionsFromItem(ModBlocks.SEAMOON_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEAMOON_STAIR)));

        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEAMOON_SLAB, ModBlocks.SEAMOON_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEAMOON_POST, 8)
                .pattern("S")
                .pattern("S")
                .input('S', ModBlocks.SEAMOON_BLOCK)
                .criterion(hasItem(ModBlocks.SEAMOON_BLOCK), conditionsFromItem(ModBlocks.SEAMOON_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEAMOON_POST)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEAMOON_FENCE, 3)
                .pattern("SPS")
                .pattern("SPS")
                .input('S', ModBlocks.SEAMOON_BLOCK)
                .input('P', ModBlocks.SEAMOON_POST)
                .criterion(hasItem(ModBlocks.SEAMOON_BLOCK), conditionsFromItem(ModBlocks.SEAMOON_BLOCK))
                .criterion(hasItem(ModBlocks.SEAMOON_POST), conditionsFromItem(ModBlocks.SEAMOON_POST))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEAMOON_FENCE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEAMOON_FENCE_GATE, 1)
                .pattern("PSP")
                .pattern("PSP")
                .input('S', ModBlocks.SEAMOON_BLOCK)
                .input('P', ModBlocks.SEAMOON_POST)
                .criterion(hasItem(ModBlocks.SEAMOON_BLOCK), conditionsFromItem(ModBlocks.SEAMOON_BLOCK))
                .criterion(hasItem(ModBlocks.SEAMOON_POST), conditionsFromItem(ModBlocks.SEAMOON_POST))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEAMOON_FENCE_GATE)));

        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEAMOON_WALL, ModBlocks.SEAMOON_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEAMOON_DOOR, 3)
                .pattern("SS")
                .pattern("SS")
                .pattern("SS")
                .input('S', ModBlocks.SEAMOON_BLOCK)
                .criterion(hasItem(ModBlocks.SEAMOON_BLOCK), conditionsFromItem(ModBlocks.SEAMOON_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEAMOON_DOOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEAMOON_TRAPDOOR, 2)
                .pattern("SSS")
                .pattern("SSS")
                .input('S', ModBlocks.SEAMOON_BLOCK)
                .criterion(hasItem(ModBlocks.SEAMOON_BLOCK), conditionsFromItem(ModBlocks.SEAMOON_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEAMOON_TRAPDOOR)));

        offerPressurePlateRecipe(exporter, ModBlocks.SEAMOON_PRESSURE_PLATE, ModBlocks.SEAMOON_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SEAMOON_BUTTON)
                .input(ModBlocks.SEAMOON_BLOCK)
                .criterion(hasItem(ModBlocks.SEAMOON_BLOCK), conditionsFromItem(ModBlocks.SEAMOON_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.SEAMOON_BUTTON)));


    }
}
