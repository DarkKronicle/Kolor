package io.github.darkkronicle.kolor;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;

import java.util.Arrays;
import java.util.List;

public class OverlayColorManager {

    private final static OverlayColorManager INSTANCE = new OverlayColorManager();

    public final static EntityType<?>[] ENTITY_TYPES = new EntityType<?>[] {
            EntityType.PLAYER, EntityType.AXOLOTL, EntityType.BAT, EntityType.BLAZE, EntityType.BEE, EntityType.BLAZE, EntityType.CAT,
            EntityType.CAVE_SPIDER, EntityType.CHICKEN, EntityType.COD, EntityType.COW, EntityType.CREEPER,
            EntityType.DOLPHIN, EntityType.DONKEY, EntityType.DROWNED, EntityType.ELDER_GUARDIAN, EntityType.ENDER_DRAGON,
            EntityType.ENDERMAN, EntityType.ENDERMITE, EntityType.EVOKER, EntityType.FOX, EntityType.GHAST, EntityType.GIANT,
            EntityType.GLOW_SQUID, EntityType.GOAT, EntityType.GUARDIAN, EntityType.HOGLIN, EntityType.HORSE, EntityType.HUSK,
            EntityType.ILLUSIONER, EntityType.IRON_GOLEM, EntityType.LLAMA, EntityType.MAGMA_CUBE, EntityType.MULE, EntityType.MOOSHROOM,
            EntityType.OCELOT, EntityType.PANDA, EntityType.PARROT, EntityType.PHANTOM, EntityType.PIG, EntityType.PIGLIN, EntityType.PIGLIN_BRUTE,
            EntityType.PILLAGER, EntityType.POLAR_BEAR, EntityType.PUFFERFISH, EntityType.RABBIT, EntityType.RAVAGER, EntityType.SALMON, EntityType.SHEEP, EntityType.SHULKER,
            EntityType.SILVERFISH, EntityType.SKELETON, EntityType.SKELETON_HORSE, EntityType.SNOW_GOLEM, EntityType.SPIDER,
            EntityType.SQUID, EntityType.STRAY, EntityType.STRIDER, EntityType.TRADER_LLAMA, EntityType.TROPICAL_FISH, EntityType.TURTLE,
            EntityType.VEX, EntityType.VILLAGER, EntityType.VINDICATOR, EntityType.WANDERING_TRADER, EntityType.WITCH, EntityType.WITHER,
            EntityType.WITHER_SKELETON, EntityType.WOLF, EntityType.ZOGLIN, EntityType.ZOMBIE, EntityType.ZOMBIE_HORSE,
            EntityType.ZOMBIE_VILLAGER, EntityType.ZOMBIFIED_PIGLIN
    };
    private final static List<EntityType<?>> ENTITY_TYPES_ARRAY = Arrays.asList(ENTITY_TYPES);

    public static OverlayColorManager getInstance() {
        return INSTANCE;
    }

    private OverlayColorManager() {}

    public int getDamageUV(EntityType<?> entityType) {
        int index = ENTITY_TYPES_ARRAY.indexOf(entityType);
        if (index < 0) {
            return OverlayTexture.packUv(0, 0);
        }
        index += 1;
        return OverlayTexture.packUv(index % 16, index / 16);
    }

    public int getUv(LivingEntity entity, float whiteOverlayProgress) {
        if (entity.hurtTime > 0 || entity.deathTime > 0) {
            return getDamageUV(entity.getType());
        }
        if (entity.getType() == EntityType.CREEPER) {
            return OverlayTexture.packUv(
                    OverlayTexture.getU(whiteOverlayProgress),
                    14
            );
        }
        return OverlayTexture.DEFAULT_UV;
    }

}
