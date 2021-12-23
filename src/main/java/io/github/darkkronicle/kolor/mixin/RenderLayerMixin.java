package io.github.darkkronicle.kolor.mixin;

import fi.dy.masa.malilib.render.RenderUtils;
import io.github.darkkronicle.kolor.GlintColorManager;
import net.minecraft.client.render.RenderLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RenderLayer.class)
public class RenderLayerMixin {

    @Inject(method = "getDirectGlint", at = @At("HEAD"))
    private static void getGlintNew(CallbackInfoReturnable<RenderLayer> ci) {
        RenderUtils.color(1, 0, 0, 1);
    }

    @Inject(method = "getGlint", at = @At("HEAD"))
    private static void gGlint(CallbackInfoReturnable<RenderLayer> ci) {
        RenderUtils.color(1, 0, 0, 1);
    }

    @Inject(method = "getGlintTranslucent", at = @At("HEAD"))
    private static void gTrans(CallbackInfoReturnable<RenderLayer> ci) {
        RenderUtils.color(1, 0, 0, 1);
    }

    @Inject(method = "getArmorGlint", at = @At("HEAD"))
    private static void getArmor(CallbackInfoReturnable<RenderLayer> ci) {
        RenderUtils.color(1, 0, 0, 1);
    }

    @Inject(method = "getArmorEntityGlint", at = @At("HEAD"))
    private static void getArmorEntity(CallbackInfoReturnable<RenderLayer> ci) {
        RenderUtils.color(1, 0, 0, 1);
    }

    @Inject(method = "getEntityGlint", at = @At("HEAD"))
    private static void getEntity(CallbackInfoReturnable<RenderLayer> ci) {
        RenderUtils.color(1, 0, 0, 1);
    }

    @Inject(method = "getDirectEntityGlint", at = @At("HEAD"))
    private static void getDrectEntity(CallbackInfoReturnable<RenderLayer> ci) {
        RenderUtils.color(1, 0, 0, 1);
    }
}
