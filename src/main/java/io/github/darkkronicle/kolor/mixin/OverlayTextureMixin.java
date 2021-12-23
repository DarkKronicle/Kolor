package io.github.darkkronicle.kolor.mixin;

import io.github.darkkronicle.kolor.CustomOverlayColor;
import net.minecraft.client.render.OverlayTexture;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OverlayTexture.class)
public class OverlayTextureMixin {


    @Shadow @Mutable @Final public static int DEFAULT_UV = OverlayTexture.packUv(0, 15);

    @Inject(method = "setupOverlayColor", at = @At("HEAD"), cancellable = true)
    private void overlaySetup(CallbackInfo ci) {
        CustomOverlayColor.getInstance().setupOverlay();
        ci.cancel();
    }

    @Inject(method = "teardownOverlayColor", at = @At("HEAD"), cancellable = true)
    private void overlayTeardown(CallbackInfo ci) {
        CustomOverlayColor.getInstance().teardownOverlay();
        ci.cancel();
    }

    @Inject(method = "close", at = @At("HEAD"))
    private void overlayClose(CallbackInfo ci) {
        CustomOverlayColor.getInstance().close();
    }

}
