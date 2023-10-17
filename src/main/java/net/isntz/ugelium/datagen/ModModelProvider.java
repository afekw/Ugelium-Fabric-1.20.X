package net.isntz.ugelium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.isntz.ugelium.block.ModBlocks;
import net.isntz.ugelium.item.ModItem;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.UGELIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_UGELIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.UGELIUM_ORE);

        blockStateModelGenerator.registerSimpleState(ModBlocks.UGELIUM_FUSER);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItem.UGELIUM, Models.GENERATED);
        itemModelGenerator.register(ModItem.RAW_UGELIUM, Models.GENERATED);

        itemModelGenerator.register(ModItem.UGELIUM_DETECTOR, Models.GENERATED);

        itemModelGenerator.register(ModItem.UGELIUM_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItem.UGELIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItem.UGELIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItem.UGELIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItem.UGELIUM_AXE, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItem.UGELIUM_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItem.UGELIUM_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItem.UGELIUM_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItem.UGELIUM_BOOTS));
    }
}
