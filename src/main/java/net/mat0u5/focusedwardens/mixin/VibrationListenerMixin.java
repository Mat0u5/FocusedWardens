package net.mat0u5.focusedwardens.mixin;

import net.mat0u5.focusedwardens.events.Events;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.gameevent.vibrations.VibrationSystem.Listener;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Listener.class)
public abstract class VibrationListenerMixin implements GameEventListener {

    @Inject(method = "handleGameEvent(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/Holder;Lnet/minecraft/world/level/gameevent/GameEvent$Context;Lnet/minecraft/world/phys/Vec3;)Z", at = @At("HEAD"), cancellable = true)
    private void onListen(ServerLevel world, Holder<GameEvent> event, GameEvent.Context emitter, Vec3 emitterPos, CallbackInfoReturnable<Boolean> cir) {
        Events.wardenListen(emitter, cir);
    }
}