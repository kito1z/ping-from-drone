package com.kito1z.pfd.mixin;


import com.kito1z.pfd.PingFromDroneClient;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import nx.pingwheel.common.core.PingController;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(PingController.class)
public class PingControllerMixin {
    @Redirect(method = "performPingAction", at = @At(value = "FIELD", target = "Lnet/minecraft/client/Minecraft;cameraEntity:Lnet/minecraft/world/entity/Entity;"))
    private static Entity pfd_performPingAction(Minecraft instance) {
        return PingFromDroneClient.getDroneOrCameraEntity(instance);
    }
}
