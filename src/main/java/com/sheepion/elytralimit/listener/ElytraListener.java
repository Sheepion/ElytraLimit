package com.sheepion.elytralimit.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class ElytraListener implements Listener {
    public static double maxElytraSpeed = 1.7;

    //鞘翅飞行时限制速度
    @EventHandler(ignoreCancelled = true)
    public void onElytraGlide(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        //op、有权限的玩家不会限制速度
        if (!player.isOp() && !player.hasPermission("elytralimit.unlimited") && player.isGliding()) {
            //超过最大速度则将速度变成最大速度
            double currentSpeed = player.getVelocity().length();
            if (currentSpeed > maxElytraSpeed) {
                player.setVelocity(player.getVelocity().multiply(maxElytraSpeed / currentSpeed));
            }
        }
    }
}
