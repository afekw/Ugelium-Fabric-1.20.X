package net.isntz.ugelium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.isntz.ugelium.block.ModBlocks;
import net.isntz.ugelium.item.ModItem;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> UGELIUM_SMELTABLES = List.of(ModBlocks.UGELIUM_ORE, ModItem.RAW_UGELIUM);
    private static final List<ItemConvertible> UGELIUM_BLOCK_SMELTABLES = List.of(ModBlocks.RAW_UGELIUM_BLOCK);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, UGELIUM_SMELTABLES, RecipeCategory.MISC, ModItem.UGELIUM, 0.7f, 200, "ugelium");
        offerBlasting(exporter, UGELIUM_SMELTABLES, RecipeCategory.MISC, ModItem.UGELIUM, 0.7f, 100, "ugelium");

        offerSmelting(exporter, UGELIUM_BLOCK_SMELTABLES , RecipeCategory.MISC, ModBlocks.UGELIUM_BLOCK, 6.3f, 200, "ugelium_block");
        offerBlasting(exporter,UGELIUM_BLOCK_SMELTABLES, RecipeCategory.MISC, ModBlocks.UGELIUM_BLOCK, 6.3f, 100, "ugelium_block");


        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItem.UGELIUM, RecipeCategory.DECORATIONS, ModBlocks.UGELIUM_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItem.UGELIUM_DETECTOR, 1)
                .pattern("  #")
                .pattern(" R#")
                .pattern("UUS")
                .input('#', Items.STICK)
                .input('R', Blocks.REDSTONE_BLOCK)
                .input('U', ModItem.UGELIUM)
                .input('S', Items.STRING)
                .criterion(hasItem(ModItem.UGELIUM),conditionsFromItem(ModItem.UGELIUM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItem.UGELIUM_DETECTOR)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.UGELIUM_FUSER, 1)
                .pattern("###")
                .pattern("UUU")
                .pattern("U U")
                .input('#', Blocks.POLISHED_BLACKSTONE_SLAB)
                .input('U', ModItem.UGELIUM)
                .criterion(hasItem(ModItem.UGELIUM),conditionsFromItem(ModItem.UGELIUM))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.UGELIUM_FUSER)));
    }
}
