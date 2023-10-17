package net.isntz.ugelium;

import net.fabricmc.api.ClientModInitializer;
import net.isntz.ugelium.screen.ModScreenHandlers;
import net.isntz.ugelium.screen.UgeliumFuserScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class UgeliumClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.UGELIUM_FUSER_SCREEN_HANDLER, UgeliumFuserScreen::new);
    }
}
