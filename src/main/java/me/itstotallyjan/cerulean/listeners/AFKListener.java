package me.itstotallyjan.cerulean.listeners;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.itstotallyjan.cerulean.managers.AFKManager;

public class AFKListener implements Listener {
    public void onPlayerJoin(PlayerJoinEvent e) {
        AFKManager.registerPlayerJoin(e.getPlayer());
    }
    
    public void onPlayerQuit(PlayerQuitEvent e) {
        AFKManager.registerPlayerLeave(e.getPlayer());
    }
}
