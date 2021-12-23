package io.github.darkkronicle.kolor;

import fi.dy.masa.malilib.interfaces.IInitializationHandler;
import net.minecraft.client.texture.ResourceTexture;

public class KolorInitHandler implements IInitializationHandler {
    @Override
    public void registerModHandlers() {
        CustomOverlayColor.getInstance().load();
    }
}
