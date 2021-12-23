package io.github.darkkronicle.kolor;

import fi.dy.masa.malilib.event.InitializationHandler;
import fi.dy.masa.malilib.util.Color4f;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class Kolor implements ClientModInitializer {

    public static final String MOD_ID = "kolor";

    @Override
    public void onInitializeClient() {
        InitializationHandler.getInstance().registerInitializationHandler(new KolorInitHandler());
    }
}
