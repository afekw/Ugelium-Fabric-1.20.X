package net.isntz.ugelium.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.isntz.ugelium.item.custom.UgeliumDetectorItem;
import net.isntz.ugelium.Ugelium;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItem {
    public static final  Item UGELIUM = registerItem("ugelium", new Item(new FabricItemSettings()));
    public static final  Item RAW_UGELIUM = registerItem("raw_ugelium", new Item(new FabricItemSettings()));

    public static final  Item UGELIUM_DETECTOR = registerItem("ugelium_detector", new UgeliumDetectorItem(new FabricItemSettings().maxDamage(225)));

    public static final Item UGELIUM_PICKAXE = registerItem("ugelium_pickaxe",
            new PickaxeItem(ModToolMaterial.UGELIUM, 1, -1.8F, new FabricItemSettings()));
    public static final Item UGELIUM_AXE = registerItem("ugelium_axe",
            new AxeItem(ModToolMaterial.UGELIUM, 5.0F, -2.0F, new FabricItemSettings()));
    public static final Item UGELIUM_SHOVEL = registerItem("ugelium_shovel",
            new ShovelItem(ModToolMaterial.UGELIUM, 1.5F, -2.0F, new FabricItemSettings()));
    public static final Item UGELIUM_SWORD = registerItem("ugelium_sword",
            new SwordItem(ModToolMaterial.UGELIUM, 3, -1.4F, new FabricItemSettings()));
    public static final Item UGELIUM_HOE = registerItem("ugelium_hoe",
            new HoeItem(ModToolMaterial.UGELIUM, -4, 1.0F, new FabricItemSettings()));

    public static final Item UGELIUM_HELMET = registerItem("ugelium_helmet",
            new ArmorItem(ModArmorMaterials.UGELIUM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item UGELIUM_CHESTPLATE = registerItem("ugelium_chestplate",
            new ArmorItem(ModArmorMaterials.UGELIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item UGELIUM_LEGGINGS = registerItem("ugelium_leggings",
            new ArmorItem(ModArmorMaterials.UGELIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item UGELIUM_BOOTS = registerItem("ugelium_boots",
            new ArmorItem(ModArmorMaterials.UGELIUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    private static void  addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(RAW_UGELIUM);
        entries.add(UGELIUM);
        entries.add(UGELIUM_DETECTOR);
    }
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Ugelium.MOD_ID, name), item);
    }
    public static void RegisterModItems(){
        Ugelium.LOGGER.info("Registering Mod Items For " + Ugelium.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItem::addItemsToIngredientItemGroup);
    }
}
