package io.github.darkkronicle.kolor;

import fi.dy.masa.malilib.render.RenderUtils;
import fi.dy.masa.malilib.util.Color4f;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;

public class GlintColorManager {

    private final static GlintColorManager INSTANCE = new GlintColorManager();

    public static GlintColorManager getInstance() {
        return INSTANCE;
    }

    private GlintColorManager() {}

    public void onGlintItem(ItemStack stack) {
        setColor(getColor());
    }

    public void setColor(Color4f color) {
        RenderUtils.color(color.r, color.g, color.b, color.a);
    }

    public Color4f getColor() {
        return new Color4f(0, 1, 0, 1);
    }

    public void onGlintArmor(ArmorItem item) {
        setColor(getColor());
    }
}
