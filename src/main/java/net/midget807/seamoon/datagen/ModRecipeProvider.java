package net.midget807.seamoon.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.midget807.seamoon.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
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

    }
}
