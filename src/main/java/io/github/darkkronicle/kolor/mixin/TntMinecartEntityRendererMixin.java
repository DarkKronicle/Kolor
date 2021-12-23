package io.github.darkkronicle.kolor.mixin;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.entity.TntMinecartEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(TntMinecartEntityRenderer.class)
public class TntMinecartEntityRendererMixin {

    @ModifyVariable(
            method = "renderFlashingBlock",
            at = @At("STORE"),
            ordinal = 1
    )
    private static int renderFlashing(int original) {
        // Modifies the UV value of TNT
        if (original == OverlayTexture.DEFAULT_UV) {
            // Not flash
            return OverlayTexture.packUv(0, 13);
        }
        return OverlayTexture.packUv(15, 13);
    }

}
