package net.midget807.seamoon.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.midget807.seamoon.block.ModBlocks;
import net.midget807.seamoon.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.STICKY_BICKY, 1)
                .pattern("SSS")
                .pattern("SCS")
                .pattern("SSS")
                .input('S', ModBlocks.SEAMOON_BLOCK)
                .input('C', ModItems.GLAZED_COOKIE)
                .criterion(hasItem(ModBlocks.SEAMOON_BLOCK), conditionsFromItem(ModBlocks.SEAMOON_BLOCK))
                .criterion(hasItem(ModItems.GLAZED_COOKIE), conditionsFromItem(ModItems.GLAZED_COOKIE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.STICKY_BICKY)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SOGGY_SEAWEED, 1)
                .pattern("SSS")
                .pattern("SKS")
                .pattern("SSS")
                .input('S', ModBlocks.SEAMOON_BLOCK)
                .input('K', ModItems.GLAZED_DRIED_KELP)
                .criterion(hasItem(ModBlocks.SEAMOON_BLOCK), conditionsFromItem(ModBlocks.SEAMOON_BLOCK))
                .criterion(hasItem(ModItems.GLAZED_DRIED_KELP), conditionsFromItem(ModItems.GLAZED_DRIED_KELP))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SOGGY_SEAWEED)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CREAM_PIE, 1)
                .pattern("SSS")
                .pattern("SPS")
                .pattern("SSS")
                .input('S', ModBlocks.SEAMOON_BLOCK)
                .input('P', ModItems.GLAZED_PUMPKIN_PIE)
                .criterion(hasItem(ModBlocks.SEAMOON_BLOCK), conditionsFromItem(ModBlocks.SEAMOON_BLOCK))
                .criterion(hasItem(ModItems.GLAZED_PUMPKIN_PIE), conditionsFromItem(ModItems.GLAZED_PUMPKIN_PIE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GLAZED_PUMPKIN_PIE)));

        createGlazedFoodRecipe(exporter, Items.APPLE, ModItems.GLAZED_APPLE); //TODO Update all output items for standard glazing recipes
        createGlazedFoodRecipe(exporter, Items.BAKED_POTATO, ModItems.GLAZED_BAKED_POTATO);
        createGlazedFoodRecipe(exporter, Items.BEEF, ModItems.GLAZED_BEEF);
        createGlazedFoodRecipe(exporter, Items.BEETROOT, ModItems.GLAZED_BEETROOT);
        createGlazedFoodRecipe(exporter, Items.BEETROOT_SOUP, ModItems.GLAZED_BEETROOT_SOUP);
        createGlazedFoodRecipe(exporter, Items.BREAD, ModItems.GLAZED_BREAD);
        createGlazedFoodRecipe(exporter, Items.CARROT, ModItems.GLAZED_CARROT);
        createGlazedFoodRecipe(exporter, Items.CHICKEN, ModItems.GLAZED_CHICKEN);
        createGlazedFoodRecipe(exporter, Items.CHORUS_FRUIT, ModItems.GLAZED_CHORUS_FRUIT);
        createGlazedFoodRecipe(exporter, Items.COD, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.COOKED_BEEF, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.COOKED_CHICKEN, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.COOKED_COD, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.COOKED_MUTTON, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.COOKED_PORKCHOP, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.COOKED_RABBIT, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.COOKED_SALMON, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.COOKIE, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.DRIED_KELP, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.ENCHANTED_GOLDEN_APPLE, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.GOLDEN_APPLE, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.GOLDEN_CARROT, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.HONEY_BOTTLE, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.MELON_SLICE, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.MUSHROOM_STEW, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.MUTTON, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.POISONOUS_POTATO, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.PORKCHOP, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.POTATO, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.PUFFERFISH, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.PUMPKIN_PIE, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.RABBIT, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.RABBIT_STEW, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.ROTTEN_FLESH, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.SALMON, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.SPIDER_EYE, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.SUSPICIOUS_STEW, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.SWEET_BERRIES, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.GLOW_BERRIES, ModItems.GLAZED_COD);
        createGlazedFoodRecipe(exporter, Items.TROPICAL_FISH, ModItems.GLAZED_TROPICAL_FISH);
    }
    private void createGlazedFoodRecipe(RecipeExporter exporter, ItemConvertible baseFood, ItemConvertible output) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, output, 1)
                .input(baseFood)
                .input(ModItems.SEAMOON_BOTTLE)
                .criterion(hasItem(baseFood), conditionsFromItem(baseFood))
                .criterion(hasItem(ModItems.SEAMOON_BOTTLE), conditionsFromItem(ModItems.SEAMOON_BOTTLE))
                .offerTo(exporter);
    }
}
