# Overlay files

There are two overlay files. `overlay_vanilla.png` is what is used internally by the game. `overlay_inverted.png` is what is used by Kolor. If you have custom shaders on and the overlays are weird use `overlay_vanilla.png`. To use put in a resource pack at in `~assets/Kolor/color/overlay.png`.

The reason for the other files is that in vanilla the alpha channel of the overlay is inverted (i.e. if it's set to 70% opacity, it will show as 30% opacity). There are shaders that invert this and make it so that opacity is shown up directly in game.

In the shaders that use the overlay there is a line `color.rgb = mix(overlayColor.rgb, color.rgb, overlayColor.a);`. Kolor converts this into `color.rgb = mix(overlayColor.rgb, color.rgb, 1 - overlayColor.a);`.