package net.isntz.ugelium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.isntz.ugelium.block.ModBlocks;
import net.isntz.ugelium.util.ModTags;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.UGELIUM_DETECTOR_DETECTABLE_BLOCKS)
                .add(ModBlocks.UGELIUM_ORE)
                .add(ModBlocks.UGELIUM_BLOCK)
                .add(ModBlocks.RAW_UGELIUM_BLOCK);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RAW_UGELIUM_BLOCK)
                .add(ModBlocks.UGELIUM_BLOCK)
                .add(ModBlocks.UGELIUM_FUSER)
                .add(ModBlocks.UGELIUM_ORE);


        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                .add(ModBlocks.RAW_UGELIUM_BLOCK)
                .add(ModBlocks.UGELIUM_BLOCK)
                .add(ModBlocks.UGELIUM_ORE);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_5")))
                .add(ModBlocks.UGELIUM_FUSER)
        ;
    }
}
