package me.blueysh.cerulean.managers;

import java.util.HashMap;

import org.bukkit.entity.Player;

import me.blueysh.cerulean.Cerulean;

public class AFKManager {
    
    private static final HashMap<Player, Long> movementMap = new HashMap<>();
    private static final long AFK_TIMEOUT = Cerulean.getPluginConfig().getLong("features.afk.afk-timeout");

    public static void registerPlayerJoin(Player player) {
        movementMap.put(player, System.currentTimeMillis());
    }

    public static void registerPlayerLeave(Player player) {
        movementMap.remove(player);
    }

    public static void registerPlayerMovement(Player player) {
        movementMap.put(player, System.currentTimeMillis());

        //TODO - Check to see if player is still AFK
    }

    public static boolean isAFK(Player player) {
        long timeElapsed = System.currentTimeMillis() - movementMap.get(player);
        if (timeElapsed >= AFK_TIMEOUT) return true;
        return false;
    }

}
