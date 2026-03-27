package net.mat0u5.focusedwardens.events;

import net.mat0u5.focusedwardens.Main;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.gameevent.GameEvent;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class Events {

    public static void register() {
    }
    public static void wardenListen(GameEvent.Context emitter, CallbackInfoReturnable<Boolean> cir) {
        String enabled = Main.config.getProperty("enabled");
        if (enabled == null) return;
        if (!enabled.equalsIgnoreCase("true")) return;

        Entity sourceEntity = emitter.sourceEntity();

        String ignoreNonEntitySounds = Main.config.getProperty("ignoreNonEntitySounds");
        if (ignoreNonEntitySounds != null) {
            if (sourceEntity == null && ignoreNonEntitySounds.equalsIgnoreCase("true")) {
                cir.setReturnValue(false);
            }
        }

        String ignoreNonPlayerSounds = Main.config.getProperty("ignoreNonPlayerSounds");
        if (ignoreNonPlayerSounds != null) {
            if (!(sourceEntity instanceof ServerPlayer) && ignoreNonPlayerSounds.equalsIgnoreCase("true")) {
                cir.setReturnValue(false);
            }
        }
    }
}
