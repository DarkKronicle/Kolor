package io.github.darkkronicle.kolor;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.ResourceTexture;
import net.minecraft.util.Identifier;

public class CustomOverlayColor implements AutoCloseable {

    public final static CustomOverlayColor INSTANCE = new CustomOverlayColor();

    public static CustomOverlayColor getInstance() {
        return INSTANCE;
    }

    private final static Identifier OVERLAY_IDENTIFIER = new Identifier(Kolor.MOD_ID, "color/overlay.png");
    private ResourceTexture texture;

    private CustomOverlayColor() {
    }

    public void load() {
        this.texture = new ResourceTexture(OVERLAY_IDENTIFIER);
        MinecraftClient.getInstance().getTextureManager().registerTexture(OVERLAY_IDENTIFIER, texture);
    }

    public void setupOverlay() {
        RenderSystem.setupOverlayColor(this.texture::getGlId, 16);
    }

    public void teardownOverlay() {
        RenderSystem.teardownOverlayColor();
    }

    @Override
    public void close() {
        this.texture.close();
    }
}
