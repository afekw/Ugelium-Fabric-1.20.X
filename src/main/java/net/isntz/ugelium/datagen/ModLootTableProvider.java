package net.isntz.ugelium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.isntz.ugelium.block.ModBlocks;
import net.isntz.ugelium.item.ModItem;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.UGELIUM_BLOCK);
        addDrop(ModBlocks.UGELIUM_ORE);
        addDrop(ModBlocks.RAW_UGELIUM_BLOCK);
        addDrop(ModBlocks.UGELIUM_FUSER);

        addDrop(ModBlocks.UGELIUM_ORE, oreDrops(ModBlocks.UGELIUM_ORE, ModItem.RAW_UGELIUM));
    }
}
