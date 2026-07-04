package com.kito1z.pfd;

import com.atsuishio.superbwarfare.entity.vehicle.DroneEntity;
import com.atsuishio.superbwarfare.item.misc.MonitorItem;
import com.atsuishio.superbwarfare.tools.EntityFindUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class PingFromDroneUtils {
    public static Entity getDroneOrCameraEntity(Minecraft instance) {
        Entity cameraEntity = instance.cameraEntity;
        if(cameraEntity instanceof Player player){
            ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);
            if(!stack.hasTag()) return cameraEntity;
            if(!stack.getTag().getBoolean(MonitorItem.USING)) return cameraEntity;
            if(stack.getItem() instanceof MonitorItem){
                DroneEntity drone = EntityFindUtil.findDrone(player.level(), stack.getTag().getString(MonitorItem.LINKED_DRONE));
                if(drone==null) return cameraEntity;
                return drone;
            }
        }
        return cameraEntity;
    }
}
