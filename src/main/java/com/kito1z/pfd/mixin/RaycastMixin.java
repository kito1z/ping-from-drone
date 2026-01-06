package com.kito1z.pfd.mixin;

import com.kito1z.pfd.PingFromDroneClient;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import nx.pingwheel.common.math.Raycast;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Raycast.class)
public class RaycastMixin {
    @Redirect(method = "traceDirectional", at = @At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;cameraEntity:Lnet/minecraft/world/entity/Entity;"))
    private static Entity pfd_traceDirectional(Minecraft instance) {
        return PingFromDroneClient.getDroneOrCameraEntity(instance);
    }
    @Redirect(method = "traceDistantAsync", at = @At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;cameraEntity:Lnet/minecraft/world/entity/Entity;"))
    private static Entity pfd_traceDistantAsync(Minecraft instance) {
        return PingFromDroneClient.getDroneOrCameraEntity(instance);
    }
}
