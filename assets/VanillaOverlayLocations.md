Overlay texture is used in a very small amount of places. Here are my findings:

- Every entity references DEFAULT_UV (0, 10). If anything is rendered with an overlay, it is almost always defaulted to here.
- Hurt entity (LivingEntityRenderer)
  - References 15, 3 by default
  - If creeper, it can be 7-15, 3 (CreeperEntityRenderer)
  - Used for extensions of models (Sheep's wool, shulker heads...)
- Creeper (CreeperEntityRenderer)
  - On hurt 15, 3 if not on fuse
  - On hurt 7-15, 3 if on fuse
  - On fuse 7-15, 10
- Ender dragon - Hurt time (EnderDragonEntityRenderer). Same postitions as normal hurt entity, but different method calls.
- TNT (TntMinecartEntityRenderer). Flashing when primed. (7-15, 10)