package net.mat0u5.focusedwardens.mixin;

import net.mat0u5.focusedwardens.Main;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//? if > 1.20.3
import net.minecraft.core.Holder;

//? if <= 1.19 {
/*import net.minecraft.world.level.gameevent.vibrations.VibrationListener;
@Mixin(VibrationListener.class)
*///?} else {
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem.Listener;
@Mixin(Listener.class)
//?}
public abstract class VibrationListenerMixin implements GameEventListener {

    //? if <= 1.20.3 {
    /*@Inject(method = "handleGameEvent", at = @At("HEAD"), cancellable = true)
    private void onListen(ServerLevel serverLevel, GameEvent gameEvent, GameEvent.Context emitter, Vec3 emitterPos, CallbackInfoReturnable<Boolean> cir) {
    *///?} else {
    @Inject(method = "handleGameEvent(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/Holder;Lnet/minecraft/world/level/gameevent/GameEvent$Context;Lnet/minecraft/world/phys/Vec3;)Z", at = @At("HEAD"), cancellable = true)
    private void onListen(ServerLevel world, Holder<GameEvent> event, GameEvent.Context emitter, Vec3 emitterPos, CallbackInfoReturnable<Boolean> cir) {
    //?}
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