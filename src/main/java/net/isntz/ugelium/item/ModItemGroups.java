package net.isntz.ugelium.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.isntz.ugelium.block.ModBlocks;
import net.isntz.ugelium.Ugelium;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup UGELIUM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Ugelium.MOD_ID, "ugelium"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ugelium"))
                    .icon(() -> new ItemStack(ModItem.UGELIUM)).entries((displayContext, entries) -> {
                        entries.add(ModItem.RAW_UGELIUM);
                        entries.add(ModItem.UGELIUM);
                        entries.add(ModItem.UGELIUM_DETECTOR);

                        entries.add(ModItem.UGELIUM_SHOVEL);
                        entries.add(ModItem.UGELIUM_PICKAXE);
                        entries.add(ModItem.UGELIUM_AXE);
                        entries.add(ModItem.UGELIUM_HOE);
                        entries.add(ModItem.UGELIUM_SWORD);

                        entries.add(ModBlocks.UGELIUM_BLOCK);
                        entries.add(ModBlocks.UGELIUM_ORE);
                        entries.add(ModBlocks.RAW_UGELIUM_BLOCK);

                        entries.add(ModItem.UGELIUM_HELMET);
                        entries.add(ModItem.UGELIUM_CHESTPLATE);
                        entries.add(ModItem.UGELIUM_LEGGINGS);
                        entries.add(ModItem.UGELIUM_BOOTS);

                        entries.add(ModBlocks.UGELIUM_FUSER);

                    }).build());

    public static void registerItemGroups(){
        Ugelium.LOGGER.info("Registering Item Groups For " + Ugelium.MOD_ID);
    }
}
