package io.github.darkkronicle.kolor.mixin;

import fi.dy.masa.malilib.util.Color4f;
import io.github.darkkronicle.kolor.OverlayColorManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntityRenderer.class)
public class LivingEntityMixin {

    @Inject(
            method = "getOverlay",
            at = @At("HEAD"),
            cancellable = true
    )
    private static void getColor(LivingEntity entity, float whiteOverlayProgress, CallbackInfoReturnable<Integer> ci) {
        ci.setReturnValue(OverlayColorManager.getInstance().getUv(entity, whiteOverlayProgress));
    }

}
