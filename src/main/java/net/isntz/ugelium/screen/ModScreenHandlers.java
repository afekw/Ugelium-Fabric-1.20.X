package net.isntz.ugelium.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.isntz.ugelium.Ugelium;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<UgeliumFuserScreenHandler> UGELIUM_FUSER_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(Ugelium.MOD_ID, "ugelium_fuser"),
                    new ExtendedScreenHandlerType<>(UgeliumFuserScreenHandler::new));

    public static void registerScreenHandler(){
        Ugelium.LOGGER.info("Registering Screen Handlers for " + Ugelium.MOD_ID);
    }
}
