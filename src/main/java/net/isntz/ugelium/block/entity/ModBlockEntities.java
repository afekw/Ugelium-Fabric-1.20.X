package net.isntz.ugelium.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.isntz.ugelium.Ugelium;
import net.isntz.ugelium.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<UgeliumFuserBlockEntity> UGELIUM_FUSER_BLOCK_ENTITY_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Ugelium.MOD_ID, "ugelium_fuser_be"),
                    FabricBlockEntityTypeBuilder.create(UgeliumFuserBlockEntity::new,
                            ModBlocks.UGELIUM_FUSER).build());

    public static void registerBlockEntities(){
        Ugelium.LOGGER.info("Registering Block Entities for " + Ugelium.MOD_ID);
    }
}
