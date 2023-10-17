package net.isntz.ugelium.recipe;

import net.isntz.ugelium.Ugelium;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes(){
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(Ugelium.MOD_ID, UgeliumFuserRecipe.Serializer.ID),
                UgeliumFuserRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(Ugelium.MOD_ID, UgeliumFuserRecipe.Type.ID),
                UgeliumFuserRecipe.Type.INSTANCE);
    }
}
