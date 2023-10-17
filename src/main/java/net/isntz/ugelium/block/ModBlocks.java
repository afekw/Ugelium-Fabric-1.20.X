package net.isntz.ugelium.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.isntz.ugelium.Ugelium;
import net.isntz.ugelium.block.custom.Ugelium_Fuser_Block;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block UGELIUM_BLOCK = registerBlock("ugelium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block RAW_UGELIUM_BLOCK = registerBlock("raw_ugelium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK)));

    public static final Block UGELIUM_ORE = registerBlock("ugelium_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.END_STONE).strength(5f), UniformIntProvider.create(2, 5)));

    public static final Block UGELIUM_FUSER = registerBlock("ugelium_fuser",
            new Ugelium_Fuser_Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).nonOpaque()));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Ugelium.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(Ugelium.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void RegisterModBlocks(){
        Ugelium.LOGGER.info("Registering Mod Blocks For " + Ugelium.MOD_ID);
    }
}
