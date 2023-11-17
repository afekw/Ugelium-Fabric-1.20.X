package net.isntz.ugelium.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.isntz.ugelium.block.ModBlocks;
import net.isntz.ugelium.recipe.UgeliumFuserRecipe;
import net.isntz.ugelium.screen.UgeliumFuserScreen;

public class UgeliumREIClientPlugin implements REIClientPlugin {

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new UgeliumFusingCategory());

        registry.addWorkstations(UgeliumFusingCategory.UGELIUM_FUSING, EntryStacks.of(ModBlocks.UGELIUM_FUSER));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(UgeliumFuserRecipe.class, UgeliumFuserRecipe.Type.INSTANCE,
                UgeliumFusingDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(75,30,20,30), UgeliumFuserScreen.class,
                UgeliumFusingCategory.UGELIUM_FUSING);
    }
}
